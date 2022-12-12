package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bean;
import model.UserHandler;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		if(httpSession != null){
			RequestDispatcher rd = request.getRequestDispatcher("views/Profile.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession httpSession = request.getSession();
		Bean user = new Bean();
		user.setUser(username);
		user.setPassword(password);
	
		if(UserHandler.logIn(username, password)) {
			httpSession.setAttribute("isLoggedIn",user);
			RequestDispatcher rd = request.getRequestDispatcher("views/Profile.jsp");
			rd.forward(request, response);
			
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.print("<div class=\"center\"><p>Wrong username or password.</p>");
			out.print("<p>Try again!</p></div>");
			out.print("</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}	
}
