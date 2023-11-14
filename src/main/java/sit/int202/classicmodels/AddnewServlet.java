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

@WebServlet(name = "AddnewServlet", value = "/AddnewServlet")
public class AddnewServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeCode = request.getParameter("officeCode");
        String addressLine1 = request.getParameter("addressLine1");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");
        String phone = request.getParameter("phone");
        String territory = request.getParameter("territory");

        // Create an Office entity with the retrieved data
        Office newOffice = new Office();
        newOffice.setOfficeCode(officeCode);
        newOffice.setAddressLine1(addressLine1);
        newOffice.setCity(city);
        newOffice.setState(state);
        newOffice.setCountry(country);
        newOffice.setPostalCode(postalCode);
        newOffice.setPhone(phone);
        newOffice.setTerritory(territory);

        // Persist the new office to the database
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // Begin a transaction
            transaction.begin();

            // Persist the new office
            entityManager.persist(newOffice);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // Handle exceptions, log or show an error message
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the EntityManager
            entityManager.close();
        }

        request.getRequestDispatcher("add.jsp").forward(request,response);
    }
}