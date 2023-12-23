package com.example.weblab4.Request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentRequest {
    private String userId;
    private String doctorId;
    private LocalDateTime slot;
}
