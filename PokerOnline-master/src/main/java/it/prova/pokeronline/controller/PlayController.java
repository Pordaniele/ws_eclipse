package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.dto.UtenteDTO;
import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.RuoloService;
import it.prova.pokeronline.service.StatoUtenzaService;
import it.prova.pokeronline.service.TavoloService;
import it.prova.pokeronline.service.UtenteService;
@Controller
@RequestMapping("/play/*")
public class PlayController {
	@Autowired
	UtenteService utenteService;
	@Autowired
	RuoloService ruoloService;
	@Autowired
	StatoUtenzaService statoUtenzaService;
	@Autowired
	TavoloService tavoloService;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	
	@RequestMapping(value = "home", method = { RequestMethod.GET})
	public String home() {
		
		return "play/home";
		
		}
	
	@RequestMapping(value = "credito", method = RequestMethod.GET)
	public String credito(Model model) {
		model.addAttribute("playCommand", new UtenteDTO());
		return "play/credito";
	}
	
	@RequestMapping(value = "buyCredit", method = RequestMethod.POST)
	public String buyCredit(@ModelAttribute("playCommand") UtenteDTO utenteDTOInstance, BindingResult result, Model model,
			HttpSession session) {

		Utente utenteRicaricaCredito = (Utente)session.getAttribute("userInfo");
		Double ricarica =utenteDTOInstance.getCreditoAccumulato();
		utenteRicaricaCredito.setCreditoAccumulato(utenteRicaricaCredito.getCreditoAccumulato()+ricarica);
		utenteService.aggiorna(utenteRicaricaCredito);
		
		
		return "/play/home";
	}
	
	@RequestMapping(value = "search", method = { RequestMethod.GET})
	public String search() {
		
		return "play/search";
		
		}
	

	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(@ModelAttribute("playCommand") TavoloDTO tavoloDTOInstance, Model model, HttpServletRequest request) {
		Tavolo example = TavoloDTO.buildTavoloInstanceForFindByExample(tavoloDTOInstance);
		
		String partecipante= request.getParameter("partecipante");
		String creatore = request.getParameter("creatore");
		Utente creatoreExample= utenteService.findByUsername(creatore);
		example.setCreatore(creatoreExample);
		
		
		Utente utenteExample= new Utente();
		utenteExample.setUsername(partecipante);
		
		
		List <Utente> giocatori = utenteService.findByExample(utenteExample);
		for (Utente item : giocatori) {
			example.getGiocatori().add(item);
			
		}
	
		model.addAttribute("listTavoli", tavoloService.findByExample(example));
		return "play/list";
	}
	
	
	@RequestMapping(value = "cercaPerGiocatore", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView listGiocatore(@RequestParam("giocatore") String giocatore, Model model) {
		
		Utente utenteGiocante = utenteService.findByUsername(giocatore);
		Set <Utente> set = new HashSet<Utente>();
		set.add(utenteGiocante);
		
		
		System.out.println(giocatore);
		model.addAttribute("listTavoli", tavoloService.findByGiocatori(set));

		return new ModelAndView("play/list");
	}
	
	
	@RequestMapping(value ="game", method = RequestMethod.GET)
    public String game(@RequestParam("idTavolo") Long idTavolo, Model model, HttpSession session){
		Tavolo tavoloInstance= tavoloService.findGiocatori(idTavolo);
		Utente utenteChegioca=(Utente)session.getAttribute("userInfo");
		if( tavoloInstance.getCifraMin()> utenteChegioca.getCreditoAccumulato()) {
			return "/play/search";
		}
		utenteChegioca.setTavoloGiocato(tavoloInstance);
		
		model.addAttribute("playCommand", new UtenteDTO(utenteChegioca));
		return "/play/game";
    }
	
	@RequestMapping(value = "playButton", method = RequestMethod.POST)
	public String update(@ModelAttribute("playCommand") UtenteDTO utenteDTOInstance, BindingResult result, Model model
	 ,HttpServletRequest request, HttpSession session) {
		
		
		Utente utenteCheGioca =  (Utente)session.getAttribute("userInfo");
		double segno = Math.random();
		if (utenteCheGioca.getCreditoAccumulato()<=0) {
			request.setAttribute("messaggioDiErrore", "Credito esaurito");
			model.addAttribute("playCommand", new UtenteDTO(utenteCheGioca));
			return "/play/game";
		}
		if (segno>=0.5)
			utenteCheGioca.setCreditoAccumulato(utenteCheGioca.getCreditoAccumulato()-Math.random()*1000);
		else utenteCheGioca.setCreditoAccumulato(utenteCheGioca.getCreditoAccumulato()+Math.random()*1000);
		utenteService.aggiorna(utenteCheGioca);
		
		model.addAttribute("playCommand", new UtenteDTO(utenteCheGioca));
		return "/play/game";
	}
	
	
	@RequestMapping(value = "exit", method = RequestMethod.GET)
	public ModelAndView exit(HttpSession session) {
		Utente exitUtente =(Utente)session.getAttribute("userInfo");
		exitUtente.setTavoloGiocato(null);
		utenteService.aggiorna(exitUtente);
		return new ModelAndView("/play/search");
	}
}
