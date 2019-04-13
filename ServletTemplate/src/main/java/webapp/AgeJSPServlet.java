package webapp;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/age")
public class AgeJSPServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String age = request.getParameter("age");
        request.setAttribute("age", age);
        request.getRequestDispatcher("/WEB-INF/views/age.jsp").forward(request, response);
    }
}
