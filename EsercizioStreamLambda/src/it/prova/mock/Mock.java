package it.prova.mock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.Destinatario;
import it.prova.model.PostaDiPaese;

public class Mock {
	public static final List<PostaDiPaese> POSTE_LIST = new ArrayList<>();

	static {
		try {
		PostaDiPaese postaMilano= new PostaDiPaese("posta centrale Milano", "via degli orti (mi)",new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"),3 );
		Destinatario marco=new Destinatario("Marco", "Marchi", 26, "via marco marchi (mi)", true);
		postaMilano.getDestinatari().add(marco);
		Destinatario giovanni=new Destinatario("Giovanni", "Spicchi", 35, "via degli orti (mi)", false);
		postaMilano.getDestinatari().add(giovanni);

		PostaDiPaese postaRoma= new PostaDiPaese("posta centrale Roma", "via delle lampade (rm)",new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2010"), 51);
		Destinatario daniele=new Destinatario("Daniele", "Porcelli", 30, "via danieli (rm)", true);
		postaRoma.getDestinatari().add(daniele);
		Destinatario alessandro=new Destinatario("Alessandro", "Rulli", 35, "via degli arti (rm)", false);
		postaRoma.getDestinatari().add(alessandro);

		PostaDiPaese postaFiumicino= new PostaDiPaese("posta centrale Napoli", "via delle fiocine (na)", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2005"), 70);
		Destinatario paolo=new Destinatario("Paolo", "Picchi", 20, "via dei pizzi (na)", true);
		postaFiumicino.getDestinatari().add(paolo);
		Destinatario giorgio=new Destinatario("Giorgio", "Rulli", 35, "via degli arti (na)", false);
		postaFiumicino.getDestinatari().add(giorgio);

		PostaDiPaese postaMilano2= new PostaDiPaese("posta periferica Milano", "via degli stolti (mi)", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1999"), 15);
		Destinatario mauro=new Destinatario("Mauro", "", 20, "via dei pizzi (mi)", true);
		postaMilano2.getDestinatari().add(mauro);
		Destinatario franco=new Destinatario("Franco", "Scenzi", 36, "via degli arti (mi)", true);
		postaMilano2.getDestinatari().add(franco);
		Destinatario stefano=new Destinatario("Stefano", "Conti", 55, "via dei cani (mi)", false);
		postaMilano2.getDestinatari().add(stefano);
		
		POSTE_LIST.add(postaFiumicino);
		POSTE_LIST.add(postaMilano);
		POSTE_LIST.add(postaMilano2);
		POSTE_LIST.add(postaRoma);

		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
		



}
