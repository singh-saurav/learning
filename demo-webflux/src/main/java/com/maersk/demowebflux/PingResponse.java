package com.maersk.demowebflux;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PingResponse {
    private String name;
    private LocalDate date;
}
