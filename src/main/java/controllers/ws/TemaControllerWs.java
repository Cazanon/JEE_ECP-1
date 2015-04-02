package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import persistence.models.entities.Tema;
import ws.TemaUris;
import controllers.TemaController;

public class TemaControllerWs implements TemaController {

	@Override
	public List<Tema> obtenerListaTemas() {
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>() {
        };
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
	}

}
