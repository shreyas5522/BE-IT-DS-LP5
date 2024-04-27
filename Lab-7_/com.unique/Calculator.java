package com.unique;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

public class CalculatorClientServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/Calculator.wsdl")
    private Calculator_Service service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            com.unique.Calculator port = service.getCalculatorPort();
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            int result = port.getNumber(num1, num2);
            response.getWriter().println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}