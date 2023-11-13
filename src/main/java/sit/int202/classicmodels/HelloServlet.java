package sit.int202.classicmodels;

import java.io.*;
import java.util.List;

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
        response.setContentType("text/html");

        // Hello

        System.out.println("It run hello servlet" );
        List<String> columns = Office.getColumnNames();

        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    public void destroy() {
    }
}