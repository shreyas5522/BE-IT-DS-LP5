package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Get input parameters
        double n1 = Double.parseDouble(request.getParameter("txtN1"));
        double n2 = Double.parseDouble(request.getParameter("txtN2"));
        String opr = request.getParameter("opr");

        // Perform calculation based on selected operation
        double result = 0;
        if (opr.equals("+")) {
            result = n1 + n2;
        } else if (opr.equals("-")) {
            result = n1 - n2;
        } else if (opr.equals("*")) {
            result = n1 * n2;
        } else if (opr.equals("/")) {
            result = n1 / n2;
        }

        // Display result
        out.println("<html><head><title>Calculator Result</title></head><body>");
        out.println("<h1>Result = " + result + "</h1>");
        out.println("</body></html>");
    }
}
