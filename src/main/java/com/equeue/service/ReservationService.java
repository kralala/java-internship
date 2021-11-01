package com.equeue.service;

import com.equeue.dto.ReservationDTO;
import com.equeue.entity.Reservation;
import com.equeue.entity.User;
import com.equeue.mapper.Mapper;
import com.equeue.persistence.ReservationRepository;
import com.equeue.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final Mapper mapper;

    @Value("${scheduled.open}")
    private LocalTime open;

    @Value("${scheduled.close}")
    private LocalTime close;

    @Value("${reserve.duration}")
    private int duration;

    @Value("${reserve.confirm_time}")
    private int confirmationTime;

    @Value("${reserve.arrive_time}")
    private int arrivalTime;

    private User userFromContext() {
        return userRepository.findByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    private List<LocalDateTime> loadReservedSlots(LocalDate date) {
        List<Reservation> reservationList = reservationRepository.findAllByArrangedBetween(LocalDateTime.of(date, open), LocalDateTime.of(date, close));
        return reservationList.stream()
                .map(Reservation::getArranged)
                .collect(Collectors.toList());
    }

    private List<LocalDateTime> getScheduleForDate(LocalDate date, List<LocalDateTime> reservedSlots) {
        List<LocalDateTime> schedule = new ArrayList<>();
        LocalDateTime it = LocalDateTime.of(date, open);
        while (it.isBefore(LocalDateTime.of(date, close))) {
            if (reservedSlots.contains(it)) {
                schedule.add(it);
            }
            it = it.plusMinutes(duration);
        }
        return schedule;
    }

    public List<ReservationDTO> loadReservationsForUser() {
        return reservationRepository.findByUser(userFromContext()).stream()
                .filter(res -> !res.isClosed())
                .map(mapper::toReservationDTO)
                .collect(Collectors.toList());
    }

    public List<ReservationDTO> loadAllReservations() {
        return reservationRepository.findAll().stream()
                .map(mapper::toReservationDTO)
                .collect(Collectors.toList());
    }

    private List<Reservation> loadAllReservationsEntity() {
        return new ArrayList<>(reservationRepository.findAll());
    }

    public ReservationDTO loadNextReservation() {
        return mapper.toReservationDTO(reservationRepository.findNext());
    }

    @Transactional
    public void deleteUnconfirmed() {
        loadAllReservationsEntity().stream()
                .filter(res -> !res.isClosed())
                .filter(res -> res.isConfirmed())
                .filter(res -> ((Duration.between(res.getCreated(), LocalDateTime.now())).toMinutes() > confirmationTime))
                .forEach(reservationRepository::delete);
    }

    @Transactional
    public void deleteUnvisited() {
        loadAllReservationsEntity().stream()
                .filter(res -> !res.isClosed())
                .filter(res -> res.isVisited())
                .filter(res -> ((Duration.between(res.getArranged(), LocalDateTime.now())).toMinutes() > arrivalTime))
                .forEach(reservationRepository::delete);
    }

    @Transactional
    public void createReservation(LocalDateTime timeslot) {
        if (reservationRepository.findByArranged(timeslot) != null){
            throw new IllegalStateException("Timeslot not available");
        }

        Reservation reservation = new Reservation(
                LocalDateTime.now(),
                timeslot,
                userFromContext()
                );

        reservationRepository.save(reservation);
    }

    public List<LocalDateTime> showAvailableTimeslots(LocalDate date) {
        List<LocalDateTime> reservedSlots = loadReservedSlots(date);
        return getScheduleForDate(date, reservedSlots);
    }

    @Transactional
    public void confirmReservation(Long id) {
        Reservation reservation = reservationRepository.getById(id);
        reservation.setConfirmed(true);
        reservationRepository.save(reservation);
    }

    @Transactional
    public void visitReservation(Long id) {
        Reservation reservation = reservationRepository.getById(id);
        reservation.setVisited(true);
        reservationRepository.save(reservation);
    }

    @Transactional
    public void closeReservation(Long id) {
        Reservation reservation = reservationRepository.getById(id);
        reservation.setClosed(true);
        reservationRepository.save(reservation);
    }

}
