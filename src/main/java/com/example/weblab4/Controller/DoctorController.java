package com.example.weblab4.Controller;

import com.example.weblab4.Repository.DoctorRepository;
import com.example.weblab4.Model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @PostMapping
    @RequestMapping("/createDoctor")
    public Doctor createDoctor() {
        Doctor doctor = new Doctor();
        doctor.setName("name");
        doctor.setSpec("spec");
        doctor.setSlots(List.of(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)));
        return doctorRepository.save(doctor);
    }
}

