package views.beans;

import java.io.Serializable;
import java.util.List;

import controllers.ControllerFactory;

public class VerVotacionesBean extends TemaBean implements Serializable, GenericBean {
	private static final long serialVersionUID = 1L;
	
	private List<Integer> numeroVotosPorTema;
	
	private Integer id;
	
	private List<List<Integer>> numeroVotosPorTemaYNivelDeEstudios;

    public VerVotacionesBean() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Integer> getNumeroVotosPorTema() {
		return numeroVotosPorTema;
	}

	public void setNumeroVotosPorTema(List<Integer> numeroVotosPorTema) {
		this.numeroVotosPorTema = numeroVotosPorTema;
	}
	
	public List<List<Integer>> getNumeroVotosPorTemaYNivelDeEstudios() {
		return numeroVotosPorTemaYNivelDeEstudios;
	}

	public void setNumeroVotosPorTemaYNivelDeEstudios(
			List<List<Integer>> numeroVotosPorTemaYNivelDeEstudios) {
		this.numeroVotosPorTemaYNivelDeEstudios = numeroVotosPorTemaYNivelDeEstudios;
	}
	
	@Override
	public void update() {
		super.update();
		this.setNumeroVotosPorTema(ControllerFactory.getFactory().getVerVotacionesController().obtenerListaVotosPorTema(this.temas));
	}

	@Override
	public void process() {
	}
	
}
