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

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("delete.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeId = request.getParameter("officeId");
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");


        // Create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // Begin a transaction
            transaction.begin();

            // Find the existing office by ID
            Office existingOffice = entityManager.find(Office.class, officeId);

            if (existingOffice != null) {
                // Remove the office from the database
                entityManager.remove(existingOffice);

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
}}