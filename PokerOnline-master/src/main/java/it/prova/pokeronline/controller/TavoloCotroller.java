package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.TavoloService;
import it.prova.pokeronline.service.UtenteService;
import it.prova.pokeronline.validator.TavoloValidator;
@Controller
@RequestMapping("/tavolo/*")
public class TavoloCotroller {

	@Autowired
	TavoloService tavoloService;	
	@Autowired
	UtenteService utenteService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	
	@RequestMapping(value = "search", method = { RequestMethod.GET})
	public String search() {
		
		return "tavolo/search";
		
		}
	
	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, Model model, HttpSession session) {
		Tavolo example = TavoloDTO.buildTavoloInstanceForFindByExample(tavoloDTOInstance);
		example.setCreatore((Utente)session.getAttribute("userInfo"));
		model.addAttribute("listTavoli", tavoloService.findByExample(example));
		return "tavolo/list";
	}
	

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("tavoloCommand", new TavoloDTO());
		return "tavolo/create";
	}
	
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, BindingResult result, Model model,
			HttpSession session) {
		Date data=new Date();
		tavoloDTOInstance.setDataCreazione(data);
		// se la validazione fallisce
		new TavoloValidator().validate(tavoloDTOInstance, result);
		if (result.hasErrors()) {
			return "tavolo/create";
		}
		Tavolo nuovoTavolo =TavoloDTO.buildTavoloInstanceForFindByExample(tavoloDTOInstance);
		nuovoTavolo.setCreatore((Utente)session.getAttribute("userInfo"));
		tavoloService.inserisciNuovo(nuovoTavolo);
		model.addAttribute("listTavoli", tavoloService.findByCreatore((Utente)session.getAttribute("userInfo")));
		return "/tavolo/list";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("idTavolo") Long idTavolo, Model model) {
		TavoloDTO tavoloDTO=TavoloDTO.buildDtoFromTavolo(tavoloService.caricaSingolo(idTavolo));
		model.addAttribute("tavoloCommand", tavoloDTO);
		return "/tavolo/edit";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, BindingResult result, Model model,
			HttpSession session) {

		// se la validazione fallisce
		new TavoloValidator().validate(tavoloDTOInstance, result);
		if (result.hasErrors()) {
			return "tavolo/edit";
		}
		
		Tavolo temp=TavoloDTO.buildTavoloFromDTO(tavoloDTOInstance);
		temp.setId(tavoloDTOInstance.getId());
		temp.setCreatore((Utente)session.getAttribute("userInfo"));
		tavoloService.aggiorna(temp);
		
		model.addAttribute("listTavoli", tavoloService.findByCreatore((Utente)session.getAttribute("userInfo")));
		return "/tavolo/list";
	}

	@RequestMapping(value ="show", method = RequestMethod.GET)
    public String show(@RequestParam("idTavolo") Long idTavolo, Model model){
		Tavolo temp= tavoloService.caricaSingolo(idTavolo);
		TavoloDTO tavoloDTO= TavoloDTO.buildDtoFromTavolo(temp);
		model.addAttribute("tavoloCommand", tavoloDTO);
        return "/tavolo/show";
    }
	
	@RequestMapping(value ="delete", method = RequestMethod.GET)
    public String delete(@RequestParam("idTavolo") Long idTavolo, Model model){
		Tavolo temp= tavoloService.caricaSingolo(idTavolo);
		TavoloDTO tavoloDTO= TavoloDTO.buildDtoFromTavolo(temp);
		model.addAttribute("tavoloCommand", tavoloDTO);
        return "/tavolo/delete";
    }
	
	}

