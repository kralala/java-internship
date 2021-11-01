package com.equeue.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO {

    @NotNull
    private Long id;

    private LocalDateTime arranged;

    private LocalDateTime created;

    private boolean isConfirmed;

    private boolean isVisited;

    private boolean isClosed;

}
