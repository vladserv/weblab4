package com.example.weblab4.Controller;

import com.example.weblab4.Model.Appointment;
import com.example.weblab4.Request.AppointmentRequest;
import com.example.weblab4.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments(@RequestParam String doctorId) {
        return appointmentService.getAllAppointmentsByDoctor(doctorId);
    }

    @PostMapping
    @RequestMapping("/createAppointment")
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentRequest request) {
        try {
            if (!appointmentService.isSlotAvailable(request.getDoctorId(), request.getSlot())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Slot not available");
            }

            appointmentService.createAppointment(request.getUserId(), request.getDoctorId(), request.getSlot());

            return ResponseEntity.ok("Appointment created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating appointment");
        }
    }
}



