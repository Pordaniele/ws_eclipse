package it.checkupprogetto.service;

public class CheckupServiceImpl implements CheckupService {
	private CardiologoService cardiologoService;
	private EmatologoService ematologoService;
	private OrtopedicoService ortopedicoService;
	public MedicoGenericoService medicoGenericoService;

	@Override
	public void checkupCompleto() {
		System.out.println("Inizio Checkup...");
		System.out.println();
		cardiologoService.controlloCardiologico();
		ematologoService.controlloEmatologo();
		ortopedicoService.controlloOrdopedico();
		medicoGenericoService.visitaMedicoGenerico();
		System.out.println();
		System.out.println("Fine Checkup!!!!");
	}

	public CardiologoService getCardiologoService() {
		return cardiologoService;
	}

	public void setCardiologoService(CardiologoService cardiologoService) {
		this.cardiologoService = cardiologoService;
	}

	public EmatologoService getEmatologoService() {
		return ematologoService;
	}

	public void setEmatologoService(EmatologoService ematologoService) {
		this.ematologoService = ematologoService;
	}

	public OrtopedicoService getOrtopedicoService() {
		return ortopedicoService;
	}

	public void setOrtopedicoService(OrtopedicoService ortopedicoService) {
		this.ortopedicoService = ortopedicoService;
	}

	public MedicoGenericoService getMedicoGenericoService() {
		return medicoGenericoService;
	}

	public void setMedicoGenericoService(MedicoGenericoService medicoGenericoService) {
		this.medicoGenericoService = medicoGenericoService;
	}
	
}
