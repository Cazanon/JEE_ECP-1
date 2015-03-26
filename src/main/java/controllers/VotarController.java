package controllers;

import persistence.models.entities.Voto;

public interface VotarController {
	
	void votar(Integer id, Voto voto);

}
