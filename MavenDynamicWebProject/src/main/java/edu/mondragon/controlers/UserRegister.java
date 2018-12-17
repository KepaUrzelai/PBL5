package edu.mondragon.controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mondragon.config.AppConfig;
import edu.mondragon.entity.User;
import edu.mondragon.service.UserService;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// Set charset for request
		response.setCharacterEncoding("UTF-8");// Set charset for response
		String dispatchURL = "/index.jsp";
		
		String action = request.getParameter("action");

		AnnotationConfigApplicationContext context = 
	            new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		if(action==null){ action="new"; }
		
		// Perform different actions depending on the request
		switch(action){
		case "save":
			User newUser = new User();

			newUser.setUsername(request.getParameter("username"));
			newUser.setPass(request.getParameter("password"));
			newUser.setDirection(request.getParameter("direction"));
			newUser.setMail(request.getParameter("email"));
			newUser.setRole(request.getParameter("0"));
			if(userService.add(newUser)){
				request.setAttribute("message", "newUser.successful");
			}else{
				request.setAttribute("error", "newUser.failed");
			}
			dispatchURL="/index.jsp";
			break;
		case "new":
		default:
			request.setAttribute("user", null);
			dispatchURL="/userForm.jsp";
			
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatchURL);
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
