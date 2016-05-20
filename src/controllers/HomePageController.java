package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import databaseClient.ClientDAO;
import databaseHistoryLogin.HistoryLoginDAO;
import databaseInvalidAccess.InvalidAccessDAO;
import login.LoginBean;
import types.Client;
import types.InvalidAccess;

@Controller
public class HomePageController {
	@Autowired
	ClientDAO clientDAO;
	@Autowired
	HistoryLoginDAO historyLoginDAO;
	@Autowired
	InvalidAccessDAO invalidAccessDAO;
	
	private void log(String s){
		System.out.println(s);
	}
	
	@RequestMapping("/loginPage")
	public ModelAndView getHomePageLogin(){
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean",loginBean);
		log("Openning login page");
		return model;
	}
	
	public String getSqlDate(){
		Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String sqlDate = formatter.format(now);
		return sqlDate;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String loginClient(@ModelAttribute("loginBean") LoginBean loginBean, ModelMap model){
		if ((!loginBean.getUsername().isEmpty())&&(!loginBean.getPassword().isEmpty())){
			Boolean invalidTries = false;
			List<InvalidAccess> invalidAccesses = invalidAccessDAO.getListOfUsername(loginBean.getUsername());
			if (invalidAccesses.size()>=3) invalidTries = true;
			int id = clientDAO.getLoginClient(loginBean.getUsername());
	        if (id != 0){
	        	String passCode = clientDAO.getPassword(id);
	        	if (passCode.equals(loginBean.getPassword())){
	        		if (!invalidTries){
	        			Client client = clientDAO.getClient(id);
			        	model.addAttribute("client",client);
			        	historyLoginDAO.create(client.getId(), getSqlDate());
			        	invalidAccessDAO.delete(loginBean.getUsername());
			        	log(getSqlDate());
			            return "homePage";
	        		}
	        		else{
	        			return "redirect:/login.failed2";
	        		}
	        	}
	        	else{
	        		log("User exists just wrong password");
	        		invalidAccessDAO.create(loginBean.getUsername(),getSqlDate());
	        		
	        		log(String.valueOf(invalidAccesses.size()));
	        		return "redirect:/login.failed1";
	        	}
	        	
	        }
	        else {
	        	return "redirect:/login.failed1";
	        }
		}
		else{
			log("Empty field");
			return "redirect:/login.failed3";
		}
        
    }
	
	@RequestMapping(value="/login.failed{reason}", method = RequestMethod.GET)
	public String loginFailed(@PathVariable("reason") int reason, Model model, LoginBean loginBean) {
		log("Showing the login failed page");
		model.addAttribute("error", true);
		String text = null;
		if (reason==1) text = "Wrong username or password!";
		if (reason==2) text = "Your account is blocked!";
		if (reason==3) text = "You left empty field!";
		model.addAttribute("msg", text);
		log(text.toString());
		model.addAttribute("loginBean", loginBean);
		return "login";
	}

}
