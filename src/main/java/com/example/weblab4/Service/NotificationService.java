package com.example.weblab4.Service;

import com.example.weblab4.Model.Appointment;
import com.example.weblab4.Model.Doctor;
import com.example.weblab4.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    public void sendReminderTwoHoursBefore(Appointment appointment, User user, Doctor doctor) {
        String notification = String.format("%s | Привет %s! Вам через 2 часа к %s в %s",
                LocalDateTime.now(), user.getName(), doctor.getName(), appointment.getSlot());
        sendNotification(notification);
    }

    public void sendReminderOneHourBefore(Appointment appointment, User user, Doctor doctor) {
        String notification = String.format("%s | Привет %s! Вам через час к %s в %s!",
                LocalDateTime.now(), user.getName(), doctor.getName(), appointment.getSlot());
        sendNotification(notification);
    }

    private void sendNotification(String notification) {
        log.info(notification);
        // Доделать форматирование
        System.out.println(notification);
    }
}


