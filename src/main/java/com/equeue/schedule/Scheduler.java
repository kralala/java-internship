package com.equeue.schedule;

import com.equeue.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
@EnableScheduling
@AllArgsConstructor
public class Scheduler {
    private final ReservationService reservationService;

    @Scheduled(fixedRate = 180000)
    public void deleteNonRelevant() {
        reservationService.deleteUnconfirmed();
        reservationService.deleteUnvisited();
    }
}
