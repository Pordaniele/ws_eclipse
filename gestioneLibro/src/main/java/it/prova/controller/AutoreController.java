package it.prova.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import it.prova.dto.AutoreDTO;
import it.prova.model.Autore;
import it.prova.service.AutoreService;
import it.prova.validator.AutoreValidator;

@Controller
@RequestMapping("/autore/*")
public class AutoreController {

	@Autowired
	private AutoreService autoreService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search() {
		return "autore/search";
	}

	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(@ModelAttribute("autoreCommand") AutoreDTO autoreDTOInstance, Model model) {
		Autore example = AutoreDTO.buildAutoreInstanceForFindByExample(autoreDTOInstance);
		model.addAttribute("listAutori", autoreService.findByExample(example));
		return "autore/list";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("autoreCommand", new AutoreDTO());
		return "autore/create";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("autoreCommand") AutoreDTO autoreDTOInstance, BindingResult result, Model model
	/* ,HttpServletRequest req */) {

		// se la validazione fallisce
		new AutoreValidator().validate(autoreDTOInstance, result);
		if (result.hasErrors()) {
			return "autore/create";
		}

		autoreService.inserisciNuovo(AutoreDTO.buildAutoreInstance(autoreDTOInstance));
		model.addAttribute("listAutori", autoreService.listAllAutori());
		return "/autore/list";
	}
	
	@RequestMapping(value ="show", method = RequestMethod.GET)
    public String show(@RequestParam("idAutore") Long idAutore, Model model){
		model.addAttribute("autoreCommand", new AutoreDTO(autoreService.caricaSingolo(idAutore)));
        return "/autore/show";
    }
	
	@RequestMapping(value ="edit", method = RequestMethod.GET)
    public String edit(@RequestParam("idAutore") Long idAutore, Model model){
		model.addAttribute("autoreCommand", new AutoreDTO(autoreService.caricaSingolo(idAutore)));
        return "/autore/edit";
    }
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("autoreCommand") AutoreDTO autoreDTOInstance, BindingResult result, Model model
	/* ,HttpServletRequest req */) {

		// se la validazione fallisce
		new AutoreValidator().validate(autoreDTOInstance, result);
		if (result.hasErrors()) {
			return "autore/edit";
		}

		autoreService.aggiorna(AutoreDTO.buildAutoreInstance(autoreDTOInstance));
		model.addAttribute("listAutori", autoreService.listAllAutori());
		return "/autore/list";
	}

}
