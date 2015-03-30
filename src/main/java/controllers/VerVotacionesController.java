package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface VerVotacionesController {
	
	List<Integer> obtenerListaVotosPorTema(List<Tema> temas);
	
	List<List<Double>> obtenerListaVotosPorTemaYNivelDeEstudios(List<Tema> temas);

	List<String> obtenerColumnHeaders();
	
	List<Double> calcularMedia(List<Tema> temas, String nivelDeEstudios);

}
