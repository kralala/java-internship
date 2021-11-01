package com.equeue.persistence;

import com.equeue.entity.Reservation;
import com.equeue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    Reservation findByArranged(LocalDateTime arranged);
    @Query("select x from Reservation x where x.isClosed = false and x.arranged = (select min(x.arranged) from Reservation x)")
    Reservation findNext();
    List<Reservation> findAllByArrangedBetween(LocalDateTime open, LocalDateTime close);
}
