package it.checkupprogetto.service;

public class OrtopedicoServiceImpl implements OrtopedicoService{
private RadiologoService radiologoService;
	@Override
	public void controlloOrdopedico() {
		radiologoService.visitaRadiologo();
		System.out.println("Controllo Ortopedico effettuato!!!");
		
	}
	public RadiologoService getRadiologoService() {
		return radiologoService;
	}
	public void setRadiologoService(RadiologoService radiologoService) {
		this.radiologoService = radiologoService;
	}

}
