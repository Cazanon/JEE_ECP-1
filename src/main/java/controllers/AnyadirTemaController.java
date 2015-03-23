package controllers;

import java.util.ArrayList;

import persistence.models.entities.Tema;

public interface AnyadirTemaController {

	void anyadirTema(Tema tema);
	
	ArrayList<String> obtenerListaTemas();
	
}
