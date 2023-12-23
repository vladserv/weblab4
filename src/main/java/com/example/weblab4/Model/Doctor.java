package com.example.weblab4.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Setter
@Getter
@Document(collection = "doctors")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String spec;
    private List<LocalDateTime> slots;
}

