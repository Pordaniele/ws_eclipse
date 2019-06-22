package it.municipioabitantejpa.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import it.municipioabitantejpa.model.Abitante;
import it.municipioabitantejpa.model.Municipio;
import it.municipioabitantejpa.service.MyServiceFactory;
import it.municipioabitantejpa.struts.form.AbitanteForm;

public class AbitanteAction extends DispatchAction{
	
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		AbitanteForm abitanteForm = (AbitanteForm) form;
		Abitante abitanteInstance = MyServiceFactory.getAbitanteServiceInstance().caricaSingoloAbitante(abitanteForm.getId());
			
		BeanUtils.copyProperties(abitanteForm, abitanteInstance);
		
		return mapping.findForward("show");
		
		
	}
	
		public ActionForward showAll(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			String idAbitanteParam = request.getParameter("idAbitante");
			
			
					
			request.setAttribute("AbitantiList", MyServiceFactory.getAbitanteServiceInstance().listAllAbitanti());

			return mapping.findForward("showAll");
			
			
		}
		public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			request.setAttribute("listaMunicipi", MyServiceFactory.getMunicipioServiceInstance().listAllMunicipi());
			return mapping.findForward("create");
		}
		
		public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			AbitanteForm abitanteForm = (AbitanteForm) form;
			
			try {
				Abitante abitanteDaInserire = new Abitante();
				BeanUtils.copyProperties(abitanteDaInserire, abitanteForm);
				abitanteDaInserire.setMunicipio(new Municipio(abitanteForm.getMunicipioId()));
				// questa va fatta altrimenti il copyProperties ci mette 0
				abitanteDaInserire.setId(null);
				
				MyServiceFactory.getAbitanteServiceInstance().inserisciNuovo(abitanteDaInserire);
				
			} catch (Exception e) {
				throw e;
			}

			return mapping.findForward("home");
		}
}
