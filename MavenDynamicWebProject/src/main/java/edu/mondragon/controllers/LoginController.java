package edu.mondragon.controllers; 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mondragon.beans.LoginTiles;
import edu.mondragon.config.AppConfig;
import edu.mondragon.entity.User;
import edu.mondragon.service.UserService; 

@Controller  
@SessionAttributes  
public class LoginController {  
    @RequestMapping(value = "/validateUser", method = RequestMethod.POST)  
    public String validateUser(@ModelAttribute("login") LoginTiles login, BindingResult result) {  
        //write the code here to add Login 
    	String username=login.getUsername();
    	String password=login.getPassword();
    	User user=null;
    			AnnotationConfigApplicationContext context = 
	            new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		if(username!=null && password!=null){
			user = userService.loadUser(username, password);
			if(user!=null) {
				System.out.println(user.getUsername()+" se ha logeado con exito");
				return "redirect:success.html";
			}
		}
        return "redirect:login.html";  
    }  
      
    @RequestMapping("/login")  
    public String showContacts(Model m) {  
        m.addAttribute("command", new LoginTiles());  
        return "login";  
    }  
}