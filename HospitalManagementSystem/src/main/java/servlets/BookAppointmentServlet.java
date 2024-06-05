package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospitalmanagement.BookAppointment;
import com.hospitalmanagement.DatabaseConnection;
import com.hospitalmanagement.Doctor;
import com.hospitalmanagement.Patient;

@WebServlet("/BookAppointmentServlet")
public class BookAppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    public BookAppointmentServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (SQLException e) {
            throw new ServletException("Unable to establish database connection.", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String appointmentDate = request.getParameter("appointmentDate");

        // Create Patient and Doctor objects
        Patient patient = new Patient(connection);
        Doctor doctor = new Doctor(connection);

        // Create BookAppointment object
        BookAppointment bookAppointment = new BookAppointment(connection, patient, doctor);

        try {
            if (!patient.getPatientById(patientId)) {
                request.setAttribute("message", "Please provide a valid patient ID.");
            } else if (!doctor.getDoctorById(doctorId)) {
                request.setAttribute("message", "Please provide a valid doctor ID.");
            } else if (!bookAppointment.checkAvailability(doctorId, appointmentDate)) {
                request.setAttribute("message", "Doctor not available.");
            } else {
                bookAppointment.bookAppointment(patientId, doctorId, appointmentDate);
                request.setAttribute("message", "Appointment booked successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while booking the appointment.");
        }

        request.getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        DatabaseConnection.closeDatabase(connection);
    }
}
