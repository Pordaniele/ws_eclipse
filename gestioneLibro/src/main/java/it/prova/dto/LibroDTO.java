package it.prova.dto;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;

import it.prova.model.Autore;
import it.prova.model.Libro;

public class LibroDTO {
	private Long id;
	private String titolo;
	private String genere;
	private Integer numeroPagine;
	private Date dataPubblicazione;
	private AutoreDTO autore;

	public LibroDTO() {
	}

	public LibroDTO(Libro libroInput) {
		this.id = libroInput.getId();
		this.autore = new AutoreDTO(libroInput.getAutore());
		this.dataPubblicazione = libroInput.getDataPubblicazione();
		this.genere = libroInput.getGenere();
		this.numeroPagine = libroInput.getNumeroPagine();
		this.titolo = libroInput.getTitolo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Integer getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public AutoreDTO getAutore() {
		return autore;
	}

	public void setAutore(AutoreDTO autore) {
		this.autore = autore;
	}

	public static Libro buildLibroInstance(LibroDTO libroDTO) {
		Libro temp = new Libro();
		temp.setId(libroDTO.getId());
		temp.setAutore(AutoreDTO.buildAutoreInstance(libroDTO.getAutore()));
		temp.setDataPubblicazione(libroDTO.getDataPubblicazione());
		temp.setGenere(libroDTO.getGenere());
		temp.setNumeroPagine(libroDTO.getNumeroPagine());
		temp.setTitolo(libroDTO.getTitolo());
		return temp;
	}
	public static Libro buildLibroInstanceForFindByExample(LibroDTO input) {
		Libro example = new Libro();
		example.setGenere(StringUtils.isNotBlank(input.getGenere()) ? input.getGenere() : null);
		example.setTitolo(StringUtils.isNotBlank(input.getTitolo()) ? input.getTitolo() : null);
		example.setDataPubblicazione(input.getDataPubblicazione());
		return example;
	}

}
