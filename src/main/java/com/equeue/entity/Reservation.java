package com.equeue.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation extends Identity {


    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;


    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime arranged;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean isConfirmed = false;

    private boolean isVisited = false;

    private boolean isClosed = false;

    public Reservation(LocalDateTime created, LocalDateTime arranged, User user) {
        this.created = created;
        this.arranged = arranged;
        this.user = user;
    }
}
