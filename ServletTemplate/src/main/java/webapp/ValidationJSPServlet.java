package webapp;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/validation")
public class ValidationJSPServlet extends HttpServlet {
   private UserValidationService validationService = new UserValidationService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String passwd = request.getParameter("password");
        boolean isValid = validationService.validate(login, passwd);
        if (isValid)
            request.setAttribute("message", "Valid");
        else
            request.setAttribute("message", "Not Valid!");
        request.getRequestDispatcher("/WEB-INF/views/validation.jsp").forward(request, response);
    }
}
