package com.rpcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rpcl.domain.Person;
import com.rpcl.service.SsnMgmtService;

@Controller
public class PersonDetailsSsnController {
	@Autowired
	private SsnMgmtService ssnMgmtService;
	
	@RequestMapping(value = "/")
	public String showPersonDetailsForm(Model model) {
		Person person=new Person();
		model.addAttribute("person", person);
		List<String> states = ssnMgmtService.fetchAllStates();
		if(states!=null) {
			model.addAttribute("states", states);
		}
		return "personSsnDtlsForm";
	}
	
	@RequestMapping(value="/handleSubmitBtn",method=RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("person")Person person,RedirectAttributes attributes) {
		person = ssnMgmtService.savePersonSsnDetails(person);
		if(person!=null) {
			String ssn = String.valueOf(person.getPersonSsn());
			StringBuilder sb=new StringBuilder(ssn);
			sb.insert(3,'-');
			sb.insert(6, '-');
			attributes.addFlashAttribute("successMsg","SSN Enrollment Successful Your SSN Number :: ");
			attributes.addFlashAttribute("SSN",sb.toString());
		}else {
			attributes.addFlashAttribute("errorMsg","SSN Enrollment is Failed");
		}
		return "redirect:/ssnEnrollmentDashboard";
	}
	
	@RequestMapping(value = "/ssnEnrollmentDashboard")
	private String ssnDashBoard() {
		return "dashboard";
	}
	
}
