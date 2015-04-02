package views.beans;

import java.io.Serializable;
import java.util.List;

import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;
import controllers.ControllerFactory;
import controllers.ejb.ControllerEjbFactory;
import controllers.ws.ControllerWsFactory;

public class VotarBean extends TemaBean implements Serializable, GenericBean {

	private static final long serialVersionUID = 1L;
	
	private int valoracion;
	
	private Integer id;
	
	private List<String> nivelesEstudios;
	
	private String nivelEstudios;

	public int getValoracion() {
		return valoracion;
	}
	
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<String> getNivelesEstudios() {
		return nivelesEstudios;
	}
	
	public void setNivelesEstudios(List<String> nivelesEstudios) {
		this.nivelesEstudios = nivelesEstudios;
	}

	public String getNivelEstudios() {
		return nivelEstudios;
	}
	
	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	@Override
	public void update() {
		super.update();
//		ControllerFactory.setFactory(new ControllerEjbFactory());
		ControllerFactory.setFactory(new ControllerWsFactory());
		this.setNivelesEstudios(ControllerFactory.getFactory().getVotarController().getNivelesEstudios());
	}

	@Override
	public void process() {
		Voto voto = new Voto(valoracion, "cualquierString", NivelEstudios.valueOf(nivelEstudios));
		ControllerFactory.setFactory(new ControllerEjbFactory());
    	ControllerFactory.getFactory().getVotarController().votar(id, voto);
	}

}
