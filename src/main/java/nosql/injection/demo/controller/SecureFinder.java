package nosql.injection.demo.controller;

import nosql.injection.demo.model.InjectionResult;
import nosql.injection.demo.model.NoSQLDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecureFinder extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        NoSQLDatabase noSQLDatabase = NoSQLDatabase.getInstance();
        InjectionResult result = noSQLDatabase.secureFindByName(name);

        request.setAttribute("result", result);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/InjectionResult.jsp");
        rd.forward(request, response);
    }
}
