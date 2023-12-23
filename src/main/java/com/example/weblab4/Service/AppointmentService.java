package com.example.weblab4.Service;

import com.example.weblab4.Model.Appointment;
import com.example.weblab4.Model.Doctor;
import com.example.weblab4.Repository.AppointmentRepository;
import com.example.weblab4.Repository.DoctorRepository;
import com.example.weblab4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.Duration;

@Service
public class AppointmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedRate = 60 * 1000)
    public void sendReminders() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        List<Appointment> appointments = appointmentRepository.findBySlotBetween(now.minusMinutes(1), now.plusHours(2));

        for (Appointment appointment : appointments) {
            LocalDateTime slotTruncated = appointment.getSlot().truncatedTo(ChronoUnit.MINUTES);
            Duration duration = Duration.between(now, slotTruncated);

            if (duration.equals(Duration.ofHours(2))) {
                notificationService.sendReminderTwoHoursBefore(appointment,
                        userRepository.findById(appointment.getUserId()).orElse(null),
                        doctorRepository.findById(appointment.getDoctorId()).orElse(null));
            } else if (duration.equals(Duration.ofHours(1))) {
                notificationService.sendReminderOneHourBefore(appointment,
                        userRepository.findById(appointment.getUserId()).orElse(null),
                        doctorRepository.findById(appointment.getDoctorId()).orElse(null));
            }
        }
    }


    public boolean isSlotAvailable(String doctorId, LocalDateTime slot) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

        if (doctor == null) {
            return false;
        }

        return !doctor.getSlots().contains(slot.truncatedTo(ChronoUnit.MINUTES));
    }

    public void createAppointment(String userId, String doctorId, LocalDateTime slot) {
        Appointment appointment = new Appointment();
        appointment.setUserId(userId);
        appointment.setDoctorId(doctorId);
        appointment.setSlot(slot.truncatedTo(ChronoUnit.MINUTES));

        appointmentRepository.save(appointment);

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor != null) {
            doctor.getSlots().add(slot.truncatedTo(ChronoUnit.MINUTES));
            doctorRepository.save(doctor);
        }
    }

    public List<Appointment> getAllAppointmentsByDoctor(String doctorId) {
        return appointmentRepository.findAllByDoctorId(doctorId);
    }
}




