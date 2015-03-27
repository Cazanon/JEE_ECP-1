package controllers;

import java.util.List;

import persistence.models.entities.Voto;

public interface VotarController {
	
	void votar(Integer id, Voto voto);

	List<String> getNivelesEstudios();

}
