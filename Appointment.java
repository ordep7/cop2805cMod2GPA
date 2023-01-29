import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Duration;
//
/*
name: pedro martinez amaro
Date: 1/29/23
Description: COP2805C Module 2 Graded Assignment.
 */
public class Appointment {
    private String title;
    private String description;
    private Contact contact;
    private ZonedDateTime appointmentTime;
    private ZonedDateTime reminderTime;

    public Appointment(String title, String description, Contact contact, ZonedDateTime appointmentTime, Duration reminder) {
        this.title = title;
        this.description = description;
        this.contact = contact;
        this.appointmentTime = appointmentTime;
        this.reminderTime = appointmentTime.minus(reminder);
    }

    public void display() {
        System.out.println("Appt:");
        System.out.println("Title: " + title);
        System.out.println("Desc: " + description);
        System.out.print("Contact: ");
        contact.display();
        System.out.println("Appt Date/Time: " + appointmentTime);
        System.out.println("Reminder: " + reminderTime);
    }

    public static void main(String[] args) {
        Contact contact = new Contact("Smith", "John", "JohnSmith@email.com", "904-555-1212", Contact.ReminderPreference.EMAIL, ZoneId.of("America/New_York"));
        ZonedDateTime appointmentTime = ZonedDateTime.of(2023, 7, 22, 22, 18, 26, 465531500, ZoneId.of("America/New_York"));
        Duration reminder = Duration.ofHours(12);
        Appointment appointment = new Appointment("Test Appointment", "This is a test appointment", contact, appointmentTime, reminder);
        appointment.display();
    }
}

class Contact {
    public enum ReminderPreference {
        NONE, TEXT, EMAIL
    }

    private StringBuilder name;
    private String email;
    private String phoneNumber;
    private ReminderPreference reminderPreference;
    private ZoneId timezone;

    public Contact(String lastName, String firstName, String email, String phoneNumber, ReminderPreference reminderPreference, ZoneId timezone) {
        this.name = new StringBuilder(lastName + ", " + firstName);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reminderPreference = reminderPreference;
        this.timezone = timezone;
    }

    public void display() {
        System.out.println(email + "," + name + phoneNumber + "," + reminderPreference + "," + timezone);
    }
}
