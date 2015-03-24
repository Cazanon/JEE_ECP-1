package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface AnyadirTemaController {

	void anyadirTema(Tema tema);
	
	List<Tema> obtenerListaTemas();
	
}
