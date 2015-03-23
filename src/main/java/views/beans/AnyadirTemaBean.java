package views.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import controllers.ControllerFactory;
import controllers.servlet.ControllerServletFactory;
import persistence.models.entities.Tema;

public class AnyadirTemaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> temas;

    private String tema;
    
    private String pregunta;

    public AnyadirTemaBean() {
    }

    public List<String> getTemas() {
        return temas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void update() {
    	ControllerFactory.setFactory(new ControllerServletFactory());
    	this.temas = new ArrayList<String>();
    	this.temas.addAll(ControllerFactory.getFactory().getAnyadirTemaController().obtenerListaTemas());
    }
    
    public void process() {
    	Tema tema = new Tema();
    	tema.setName(this.getTema());
    	tema.setPregunta(this.getPregunta());
    	ControllerFactory.setFactory(new ControllerServletFactory());
    	ControllerFactory.getFactory().getAnyadirTemaController().anyadirTema(tema);
    }
}
