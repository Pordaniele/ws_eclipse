package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.prova.pokeronline.dto.UtenteDTO;
import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.RuoloService;
import it.prova.pokeronline.service.StatoUtenzaService;
import it.prova.pokeronline.service.UtenteService;
import it.prova.pokeronline.validator.UtenteValidator;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	UtenteService utenteService;
	@Autowired
	RuoloService ruoloService;
	@Autowired
	StatoUtenzaService statoUtenzaService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	
	@RequestMapping(value = "search", method = { RequestMethod.GET})
	public String search() {
		
		return "admin/search";
		
		}
	
	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(@ModelAttribute("adminCommand") UtenteDTO utenteDTOInstance, Model model, HttpSession session) {
		Utente example= UtenteDTO.buildUtenteInstanceForFindByExample(utenteDTOInstance);
		
		model.addAttribute("listUtenti", utenteService.findByExample(example));
		return "admin/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("adminCommand", new UtenteDTO());
		model.addAttribute("listRuoli", ruoloService.listAllRuoli());
		model.addAttribute("listStati", statoUtenzaService.listAllStatiUtenza());
		return "admin/create";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("adminCommand") UtenteDTO utenteDTOInstance, BindingResult result, Model model
	,HttpServletRequest request ) {

		// se la validazione fallisce
		new UtenteValidator().validate(utenteDTOInstance, result);
		if (result.hasErrors()) {
			return "admin/create";
		}
		String[] ruoli = request.getParameterValues("ruoli");
		
		Set<Ruolo> listaRuoli = new HashSet<Ruolo>();
		for (int i=0; i<ruoli.length;i++) {
			listaRuoli.add(ruoloService.caricaSingolo(Long.parseLong(ruoli[i])));
		}
		Utente utenteDaInserire= UtenteDTO.buildUtenteFromDTO(utenteDTOInstance);
		utenteDaInserire.setDataRegistrazione(new Date());
		utenteDaInserire.setRuoli(listaRuoli);
		utenteService.inserisciNuovo(utenteDaInserire);
		model.addAttribute("listUtenti", utenteService.listAllUtenti());
		return "/admin/list";
	}
	
	@RequestMapping(value ="edit", method = RequestMethod.GET)
    public String edit(@RequestParam("idUtente") Long idUtente, Model model){
		model.addAttribute("listRuoli", ruoloService.listAllRuoli());
		model.addAttribute("listStati", statoUtenzaService.listAllStatiUtenza());
		model.addAttribute("adminCommand", new UtenteDTO(utenteService.caricaSingolo(idUtente)));
        return "/admin/edit";
    }
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("adminCommand") UtenteDTO utenteDTOInstance, BindingResult result, Model model
	 ,HttpServletRequest request) {

		//se la validazione fallisce
		new UtenteValidator().validate(utenteDTOInstance, result);
		if (result.hasErrors()) {
			return "admin/edit";
		}
		String[] ruoli = request.getParameterValues("ruoli");
		
		Set<Ruolo> listaRuoli = new HashSet<Ruolo>();
		for (int i=0; i<ruoli.length;i++) {
			listaRuoli.add(ruoloService.caricaSingolo(Long.parseLong(ruoli[i])));
		}
		Utente utenteDaModificare= UtenteDTO.buildUtenteFromDTO(utenteDTOInstance);
		utenteDaModificare.setRuoli(listaRuoli);
		utenteService.aggiorna(utenteDaModificare);
		model.addAttribute("listUtenti", utenteService.listAllUtenti());
		return "/admin/list";
	}

	@RequestMapping(value ="show", method = RequestMethod.GET)
    public String show(@RequestParam("idUtente") Long idUtente, Model model){
		model.addAttribute("adminCommand", new UtenteDTO(utenteService.caricaSingolo(idUtente)));
        return "/admin/show";
    }
	
	@RequestMapping(value ="delete", method = RequestMethod.GET)
    public String delete(@RequestParam("idUtente") Long idUtente, Model model){
		
		
		model.addAttribute("adminCommand",utenteService.caricaSingolo(idUtente));
        return "/admin/delete";
    }
	
	@RequestMapping(value ="confirmDelete", method = RequestMethod.GET)
    public String confirmDelete(@RequestParam("idUtente") Long idUtente, Model model, HttpSession session){
		
		utenteService.rimuovi(utenteService.caricaSingolo(idUtente));
		model.addAttribute("listUtenti", utenteService.listAllUtenti());
		return "/admin/list";
    }
	
	
}
