package views.beans;

import java.io.Serializable;

import controllers.ControllerFactory;
import controllers.ejb.ControllerEjbFactory;
import controllers.ws.ControllerWsFactory;
import persistence.models.entities.Tema;

public class AnyadirTemaBean extends TemaBean implements Serializable, GenericBean {
	private static final long serialVersionUID = 1L;

    private String name;
    
    private String pregunta;

    public AnyadirTemaBean() {
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    public void process() {
    	Tema tema = new Tema();
    	tema.setName(this.getName());
    	tema.setPregunta(this.getPregunta());
//    	ControllerFactory.setFactory(new ControllerEjbFactory());
    	ControllerFactory.setFactory(new ControllerWsFactory());
    	ControllerFactory.getFactory().getAnyadirTemaController().anyadirTema(tema);
    }

	
}
