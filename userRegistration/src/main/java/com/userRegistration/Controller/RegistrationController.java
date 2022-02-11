package com.userRegistration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.userRegistration.Entity.Registration;
import com.userRegistration.dto.RegistrationUpdate;
import com.userRegistration.service.RegistrationService;

@Controller

@RequestMapping
public class RegistrationController {
	
	
	@Autowired
	private RegistrationService registrationService;
	
	
	
	
//	@RequestMapping("/login")
//	public ModelAndView index() {
//		return new ModelAndView("index");
//	} 
	
	@RequestMapping("/")
	public String showindexPage() {
		return "index";
	} 
	
	@RequestMapping("/saveUser")
	public String showRegistrationPage() {
		return "saveUser";
	}
	
	
	@RequestMapping("/saveRegistrationInfo")
	public String saveRegistrationInformation(@ModelAttribute("registration")Registration registration, ModelMap modelMap) {
		
		
		registrationService.saveRegistration(registration);
		
		modelMap.addAttribute("msg","record is saved");
		return "saveUser";		
	

}
	
	@RequestMapping("/getRegistration")
	public String getAllRegistrations(ModelMap modelMap) {
		
		
		List<Registration> registration = registrationService.getAllRegistrations();
		modelMap.addAttribute("registration",registration);
		return "index";
	}
	
	@RequestMapping("/deleteRegistration")
	public String deleteRegistration(@RequestParam("emp_id") long emp_id,ModelMap modelMap) {
		registrationService.deleteRegistartionByID(emp_id);
		
		
		List<Registration> registration = registrationService.getAllRegistrations();
		modelMap.addAttribute("registration",registration);
		return "index";
		
	}
	
	@RequestMapping("/updateRegistration")
	public String updateLocation(@RequestParam("emp_id") long emp_id,ModelMap modelMap) {
		
		Registration registration = registrationService.findRegistrationById(emp_id);
		
		modelMap.addAttribute("registration",registration);
		return "updateRegistrationInfo";
	}
	
	@RequestMapping("/updateRegistrationData")
	public String updateRegistrationData(RegistrationUpdate update,ModelMap modelMap) {
		
		Registration registration =new Registration();
		registration. setEmp_id(update.getEmp_id());
		registration.setEmp_name(update.getEmp_name());
		registration.setEmail(update.getEmail());
		registration.setCity(update.getCity());
		registration.setMobile(update.getMobile());
		registration.setAddress(update.getAddress());
		
		registrationService.saveRegistration(registration);
		List<Registration> registration1 = registrationService.getAllRegistrations();
		modelMap.addAttribute("registration",registration1);
		return "index";
		
	}
}
