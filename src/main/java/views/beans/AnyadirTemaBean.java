package views.beans;

import java.io.Serializable;

public class AnyadirTemaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String[] temas;

    private String tema;

    public AnyadirTemaBean() {
    }

    public String[] getTemas() {
        return temas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void update() {
        this.temas = new String[] {"deporte", "cultura", "gastronomía"};
    }
}
