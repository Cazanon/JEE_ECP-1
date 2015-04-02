package controllers.ws;

import persistence.models.entities.Tema;
import ws.TemaUris;
import controllers.AnyadirTemaController;

public class AnyadirTemaControllerWs extends TemaControllerWs implements AnyadirTemaController {

	@Override
	public void anyadirTema(Tema tema) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(tema);
	}

}
