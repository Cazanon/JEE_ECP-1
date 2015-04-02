package controllers.ws;

import ws.TemaUris;
import controllers.EliminarTemaController;

public class EliminarTemaControllerWs extends TemaControllerWs implements EliminarTemaController {

	@Override
	public void eliminarTema(Integer id) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString()).delete();
	}

}
