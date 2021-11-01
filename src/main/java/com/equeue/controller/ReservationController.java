package com.equeue.controller;

import com.equeue.dto.ReservationDTO;
import com.equeue.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api(value = "Reservation controller")
public class ReservationController {

    private final ReservationService reservationService;

    @ApiOperation(value = "For admin: Lists all reservations")
    @GetMapping("/admin/all-reservations")
    public List<ReservationDTO> loadAllReservations() {
        return reservationService.loadAllReservations();
    }

    @ApiOperation(value = "For admin: Shows next active reservation")
    @GetMapping("/admin/next-reservation")
    public ReservationDTO loadNextReservation() {
        return reservationService.loadNextReservation();
    }

    @ApiOperation(value = "For admin: Closes visited reservation")
    @ResponseStatus(ACCEPTED)
    @PostMapping("/admin/reservation/{id}/close")
    public void closeReservation(@PathVariable Long id) {
        reservationService.closeReservation(id);
    }

    @ApiOperation(value = "Lists all reservations for user")
    @GetMapping("/user/my-reservations")
    public List<ReservationDTO> loadReservationsForUser() {
        return reservationService.loadReservationsForUser();
    }

    @ApiOperation(value = "Creates a new reservation for user")
    @ResponseStatus(ACCEPTED)
    @PostMapping("/user/create-reservation")
    public void createReservation(@RequestBody LocalDateTime timeslot) {
        reservationService.createReservation(timeslot);
    }

    @ApiOperation(value = "Lists timeslots available for reservations on a given date")
    @GetMapping("/user/show-timeslots/{date}")
    public List<LocalDateTime> showAvailableTimeslots(@PathVariable LocalDate date) {
        return reservationService.showAvailableTimeslots(date);
    }

    @ApiOperation(value = "Confirms reservation by id")
    @ResponseStatus(ACCEPTED)
    @PostMapping("/user/reservation/{id}/confirm")
    public void confirmReservation(@PathVariable Long id) {
        reservationService.confirmReservation(id);
    }

    @ApiOperation(value = "Declare visiting reserved timeslot")
    @ResponseStatus(ACCEPTED)
    @PostMapping("/user/reservation/{id}/visit")
    public void visitReservation(@PathVariable Long id) {
        reservationService.visitReservation(id);
    }

}
