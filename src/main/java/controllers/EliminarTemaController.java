package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface EliminarTemaController {

	void eliminarTema(Tema tema);

	List<Tema> obtenerListaTemas();

}
