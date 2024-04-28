package com.unique;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

public class CalculatorServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/Calculator.wsdl")  // Assuming WSDL exists
    private CalculatorService service; // Use proper naming convention (Service)

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));

            // Call the web service using the injected service
            int result = service.getCalculatorPort().getNumber(num1, num2);

            out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace(out); // Print error stack trace to response for debugging
        }
    }
}
