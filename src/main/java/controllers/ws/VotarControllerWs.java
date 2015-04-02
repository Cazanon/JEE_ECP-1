package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import persistence.models.entities.Voto;
import ws.VotoUris;
import controllers.VotarController;

public class VotarControllerWs implements VotarController {

	@Override
	public void votar(Integer id, Voto voto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getNivelesEstudios() {
		GenericType<List<String>> genericType = new GenericType<List<String>>() {
        };
		return ControllerWs.buildWebServiceManager(VotoUris.PATH_NIVELES_ESTUDIOS).entities(genericType);
	}

}
