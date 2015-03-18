package views.beans;

public class AnyadirTemaView {
	private String[] temas;

    private String tema;

    public AnyadirTemaView() {
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
