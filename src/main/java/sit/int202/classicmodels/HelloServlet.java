package sit.int202.classicmodels;

import java.io.*;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Welcome to Admin mode";


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        // Hello

        System.out.println("It run hello servlet");
        List<String> columns = Office.getColumnNames();
        for(String column:columns){
            System.out.println(column);
        }
        request.setAttribute("columns", columns);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Using FIND_ALL named query
            TypedQuery<Office> findAllQuery = entityManager.createNamedQuery("OFFICE.FIND_ALL", Office.class);
            List<Office> allOffices = findAllQuery.getResultList();

            // Set the result as a request attribute
            request.setAttribute("allOffices", allOffices);

            // Forward the request to a JSP for rendering

        } finally {
            // Close the EntityManager
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }


            request.getRequestDispatcher("index.jsp").forward(request, response);

        }


    }
}