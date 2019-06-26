package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.UtenteService;

@Controller
public class HomeController {
	@Autowired
	UtenteService utenteService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

//	@Autowired
//	private AutoreService autoreService;
//	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(HttpSession session) {
		if(session.getAttribute("userInfo")==null) {
		return new ModelAndView("login");}
		else {
			return new ModelAndView("home");
		}
	}
	
	@RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(@ModelAttribute("loginCommand") Utente utenteInstance, HttpSession session) {
		Utente temp= utenteService.findByUsernameAndPassword(utenteInstance.getUsername(), utenteInstance.getPassword());
		if (temp== null) {
			return "login";
		}else {
			Utente utenteInSessione= utenteService.caricaUtentePerUsernamePasswordeRuolo(temp.getId());
			session.setAttribute("userInfo", utenteInSessione);
		return "home";
		}
	
	}
	
	@RequestMapping(value = "logout", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView logout(HttpSession session, HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("/");
	}
		
	
	
	

}
