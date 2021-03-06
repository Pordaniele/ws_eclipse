package it.prova.test;


import it.prova.model.MateriaPrima;
import it.prova.service.MateriaPrimaService;
import it.prova.spring.MyServiceFactory;

public class Test {
	public static void main(String[] args) {

		MateriaPrimaService materiaPrimaService = MyServiceFactory.getMateriaPrimaService();
		// STampo la ricerca
		MateriaPrima mat1 = materiaPrimaService.cercaPerId(1);
		System.out.println(mat1);
		System.out.println();
		// creo a aggiungo al database mock due materie prime
		MateriaPrima mat2 = new MateriaPrima(10, "ferro");
		materiaPrimaService.aggiungiMateriaPrima(mat2);

		MateriaPrima mat3 = new MateriaPrima(11, "roccia");
		materiaPrimaService.aggiungiMateriaPrima(mat3);
		materiaPrimaService.iniziaLavorazione();

		// Stampo situazione finale di una materia prima
		System.out.println(materiaPrimaService.cercaPerId(2));
		System.out.println(materiaPrimaService.cercaPerId(10));
	}
}
