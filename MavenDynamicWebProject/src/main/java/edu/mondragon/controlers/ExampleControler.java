package edu.mondragon.controlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mondragon.config.AppConfig;
import edu.mondragon.entity.User;
import edu.mondragon.service.UserService;

/**
 * Servlet implementation class ExampleControler
 */
@WebServlet("/ExampleControler")
public class ExampleControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExampleControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	 
		AnnotationConfigApplicationContext context = 
		            new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = context.getBean(UserService.class);
		List<User> users = userService.listUsers();
	      for (User user : users) {
	         System.out.println("Id = "+user.getId());
	         System.out.println("Username = "+user.getUsername());
	         System.out.println("Password = "+user.getPass());
	         System.out.println();
	    }
	    context.close();
		session.setAttribute("username", "aperez");
		response.sendRedirect(response.encodeRedirectURL("second_page.jsp"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
