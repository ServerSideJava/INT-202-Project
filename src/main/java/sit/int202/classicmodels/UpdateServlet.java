package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;

import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        String officeId = request.getParameter("officeId");
        String updateField = request.getParameter("updateField");
        String newValue = request.getParameter("newValue");

        // Create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // Begin a transaction
            transaction.begin();

            // Find the existing office by ID
            Office existingOffice = entityManager.find(Office.class, officeId);

            if (existingOffice != null) {
                // Update the selected field with the new value
                switch (updateField) {
                    case "addressLine1":
                        existingOffice.setAddressLine1(newValue);
                        break;
                    case "city":
                        existingOffice.setCity(newValue);
                        break;
                    case "state":
                        existingOffice.setState(newValue);
                        break;
                    case "country":
                        existingOffice.setCountry(newValue);
                        break;
                    case "postalCode":
                        existingOffice.setPostalCode(newValue);
                        break;
                    case "phone":
                        existingOffice.setPhone(newValue);
                        break;
                    case "territory":
                        existingOffice.setTerritory(newValue);
                        break;
                    // Add more cases based on your data fields

                    default:
                        // Handle unknown update field
                        break;
                }

                // Commit the transaction
                transaction.commit();
            } else {
                // Handle case where the office with the specified ID is not found
            }
        } catch (Exception e) {
            // Handle exceptions, log or show an error message
            if (transaction.isActive()) {
                transaction.rollback();
            }
    }


    }
}