package edu.mondragon.controllers; 
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.SessionAttributes;  
import edu.mondragon.beans.Login; 

@Controller  
@SessionAttributes  
public class LoginController {  
    @RequestMapping(value = "/viewLogin", method = RequestMethod.POST)  
    public String addContact(@ModelAttribute("login") Login login, BindingResult result) {  
        //write the code here to add Login 
        return "redirect:login.html";  
    }  
      
    @RequestMapping("/login")  
    public String showContacts(Model m) {  
        m.addAttribute("command", new Login());  
        return "login";  
    }  
}