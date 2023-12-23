package com.example.weblab4.Repository;

import com.example.weblab4.Model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAllByDoctorId(String doctorId);
    List<Appointment> findBySlotBetween(LocalDateTime start, LocalDateTime end);

}


