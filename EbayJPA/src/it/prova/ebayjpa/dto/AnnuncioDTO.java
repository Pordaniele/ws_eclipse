package it.prova.ebayjpa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Categoria;
import it.prova.ebayjpa.model.Utente;

public class AnnuncioDTO {
	private Long id;

	private boolean ApertoChiuso;
	private Date dataAnnuncio;
	private String testoAnnuncio;
	private double prezzo;
	private Utente utente;
	private Set<Categoria> categorie = new HashSet<>(0);
	
	public AnnuncioDTO() {}
	
	public AnnuncioDTO(boolean apertoChiuso, String testoAnnuncio, double prezzo) {
		super();
		ApertoChiuso = apertoChiuso;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
	}
	
	
	public Date getDataAnnuncio() {
		return dataAnnuncio;
	}


	public void setDataAnnuncio(Date dataAnnuncio) {
		this.dataAnnuncio = dataAnnuncio;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isApertoChiuso() {
		return ApertoChiuso;
	}
	public void setApertoChiuso(boolean apertoChiuso) {
		ApertoChiuso = apertoChiuso;
	}
	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}
	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Set<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	public List <String> validate(){
		List<String> listaErrori = new ArrayList<String>();
		if (StringUtils.isEmpty(this.getTestoAnnuncio())) {
			listaErrori.add("Nome non valido");
		}
		if(this.getPrezzo()<0) {
			listaErrori.add("Prezzo non valido");
		}
		return listaErrori;
	}
	
	public static Annuncio buildAnnuncioFromDto(AnnuncioDTO annuncioDTO) {
		Annuncio temp=new Annuncio();
		temp.setApertoChiuso(annuncioDTO.isApertoChiuso());
		temp.setCategorie(annuncioDTO.getCategorie());
		temp.setDataAnnuncio(annuncioDTO.getDataAnnuncio());
		temp.setId(annuncioDTO.getId());
		temp.setPrezzo(annuncioDTO.getPrezzo());
		temp.setTestoAnnuncio(annuncioDTO.getTestoAnnuncio());
		temp.setUtente(annuncioDTO.getUtente());
		return temp;
	}
	
	public static AnnuncioDTO buildDTOFromAnnuncio(Annuncio annuncio) {
		AnnuncioDTO temp= new AnnuncioDTO();
		temp.setApertoChiuso(annuncio.isApertoChiuso());
		temp.setCategorie(annuncio.getCategorie());
		temp.setDataAnnuncio(annuncio.getDataAnnuncio());
		temp.setId(annuncio.getId());
		temp.setPrezzo(annuncio.getPrezzo());
		temp.setTestoAnnuncio(annuncio.getTestoAnnuncio());
		temp.setUtente(annuncio.getUtente());
		return temp;
	}
	
}
