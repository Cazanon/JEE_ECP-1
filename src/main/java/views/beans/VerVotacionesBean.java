package views.beans;

import java.io.Serializable;
import java.util.List;

import controllers.ControllerFactory;

public class VerVotacionesBean extends TemaBean implements Serializable, GenericBean {
	private static final long serialVersionUID = 1L;
	
	private List<Integer> numeroVotosPorTema;
	
	private Integer id;
	
	private List<List<Double>> numeroVotosPorTemaYNivelDeEstudios;
	
	private List<String> columnHeaders;

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
	
	public List<List<Double>> getNumeroVotosPorTemaYNivelDeEstudios() {
		return numeroVotosPorTemaYNivelDeEstudios;
	}

	public void setNumeroVotosPorTemaYNivelDeEstudios(
			List<List<Double>> numeroVotosPorTemaYNivelDeEstudios) {
		this.numeroVotosPorTemaYNivelDeEstudios = numeroVotosPorTemaYNivelDeEstudios;
	}
	
	public List<String> getColumnHeaders() {
		return columnHeaders;
	}

	public void setColumnHeaders(List<String> columnHeaders) {
		this.columnHeaders = columnHeaders;
	}
	
	@Override
	public void update() {
		super.update();
		this.setNumeroVotosPorTema(ControllerFactory.getFactory().getVerVotacionesController().obtenerListaVotosPorTema(this.temas));
		this.setNumeroVotosPorTemaYNivelDeEstudios(ControllerFactory.getFactory().getVerVotacionesController().obtenerListaVotosPorTemaYNivelDeEstudios(this.temas));
		this.setColumnHeaders(ControllerFactory.getFactory().getVerVotacionesController().obtenerColumnHeaders());
	}

	@Override
	public void process() {
	}
	
}
