package views.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class AnyadirTemaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<String> temas;

    private String tema;
    
    private String temaNuevo;

    public AnyadirTemaBean() {
    }

    public ArrayList<String> getTemas() {
        return temas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void update() {
    	this.temas = new ArrayList<String>();
        this.temas.add("deporte");
        this.temas.add("cultura");
        this.temas.add("gastronomia");
    }
    
    public void anyadirTema() {
    	this.temas.add(temaNuevo);
    }
}
