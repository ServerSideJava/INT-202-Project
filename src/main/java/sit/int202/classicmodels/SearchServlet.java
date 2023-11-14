package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("search.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchBy = request.getParameter("searchBy");
        String searchTerm = request.getParameter("searchTerm");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Build the JPQL query based on the selected search criteria
            String jpql = "SELECT o FROM Office o WHERE ";

            if ("country".equals(searchBy)) {
                jpql += "o.country = :searchTerm";
            } else if ("city".equals(searchBy)) {
                jpql += "o.city = :searchTerm";
            }

            // Create the TypedQuery
            TypedQuery<Office> query = entityManager.createQuery(jpql, Office.class);

            // Set the parameter
            query.setParameter("searchTerm", searchTerm);

            // Execute the query to retrieve the search results
            List<Office> searchResults = query.getResultList();

            // Set the search results in the request attributes
            request.setAttribute("searchResults", searchResults);
        } catch (Exception e) {
            // Handle exceptions, log or show an error message
            e.printStackTrace();
        } finally {
            // Close the EntityManager
            entityManager.close();
        }

        // Forward to the search results page
        request.getRequestDispatcher("search.jsp").forward(request, response);


    }
}