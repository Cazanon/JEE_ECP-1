package views.beans;

import java.io.Serializable;

import controllers.ControllerFactory;
import controllers.servlet.ControllerServletFactory;

public class VerVotacionesBean extends TemaBean implements Serializable, GenericBean {
	private static final long serialVersionUID = 1L;
	
	private int numeroVotosPorTema;
	
	private Integer id;

    public VerVotacionesBean() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumeroVotosPorTema() {
		return numeroVotosPorTema;
	}

	public void setNumeroVotosPorTema(int numeroVotosPorTema) {
		this.numeroVotosPorTema = numeroVotosPorTema;
	}
	
	@Override
    public void update() {
    	super.update();
    	ControllerFactory.setFactory(new ControllerServletFactory());
    	this.setNumeroVotosPorTema(ControllerFactory.getFactory().getVerVotacionesController().obtenerListaVotosPorTema(id).size());
    }

	@Override
	public void process() {
	}
	
}
