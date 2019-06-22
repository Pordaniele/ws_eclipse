package it.prova.ebayjpa.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Categoria;

public class CategoriaDTO {
	private Long id;
	private String descrizione;
	private String codice;
	private Set<Annuncio> annunci = new HashSet<>(0);

	public CategoriaDTO() {
	}

	public CategoriaDTO(String descrizione, String codice, Set<Annuncio> annunci) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.annunci = annunci;
	}

	public CategoriaDTO(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public CategoriaDTO(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Set<Annuncio> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<Annuncio> annunci) {
		this.annunci = annunci;
	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();
		if (StringUtils.isEmpty(this.getDescrizione())) {
			listaErrori.add("descrizione non valido");
		}
		if (StringUtils.isEmpty(this.getCodice())) {
			listaErrori.add("descrizione non valido");
		}
		return listaErrori;
	}

	public static Categoria buildCategoriaFromDTO(CategoriaDTO categoriaDTO) {
		Categoria temp = new Categoria();
		temp.setCodice(categoriaDTO.getCodice());
		temp.setDescrizione(categoriaDTO.getDescrizione());
		temp.setId(categoriaDTO.getId());
		temp.setAnnunci(categoriaDTO.getAnnunci());
		return temp;
	}

	public static CategoriaDTO buildDTOFromCategoria(Categoria categoria) {
		CategoriaDTO temp = new CategoriaDTO();
		temp.setCodice(categoria.getCodice());
		temp.setDescrizione(categoria.getDescrizione());
		temp.setId(categoria.getId());
		temp.setAnnunci(categoria.getAnnunci());
		return temp;
	}
}
