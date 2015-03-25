package controllers;

import java.util.List;

import persistence.models.entities.Voto;

public interface VerVotacionesController {
	
	List<Voto> obtenerListaVotosPorTema();

}
