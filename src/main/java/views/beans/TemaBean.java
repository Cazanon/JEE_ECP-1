package views.beans;

import java.io.Serializable;
import java.util.List;

import persistence.models.entities.Tema;
import controllers.ControllerFactory;
import controllers.ejb.ControllerEjbFactory;
import controllers.ws.ControllerWsFactory;

public class TemaBean implements Serializable {
	
	protected List<Tema> temas;

	private static final long serialVersionUID = 1L;

	public void update() {
//    	ControllerFactory.setFactory(new ControllerEjbFactory());
		ControllerFactory.setFactory(new ControllerWsFactory());
    	this.setTemas(ControllerFactory.getFactory().getTemaController().obtenerListaTemas());
    }

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

}
