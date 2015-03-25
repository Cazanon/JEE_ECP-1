package controllers;

import persistence.models.entities.Tema;

public interface EliminarTemaController extends TemaController {

	void eliminarTema(Tema tema);

}
