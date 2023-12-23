package com.example.weblab4.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;
    private String userId;
    private String doctorId;
    private LocalDateTime slot;
}

