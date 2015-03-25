package controllers;

import persistence.models.entities.Tema;

public interface AnyadirTemaController extends TemaController {

	void anyadirTema(Tema tema);
	
}
