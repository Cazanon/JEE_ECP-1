package views.beans;

import java.io.Serializable;

public class VotarBean extends TemaBean implements Serializable, GenericBean {

	private static final long serialVersionUID = 1L;
	
	private int valoracion;

	public int getValoracion() {
		return valoracion;
	}
	
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public void process() {
	}

}
