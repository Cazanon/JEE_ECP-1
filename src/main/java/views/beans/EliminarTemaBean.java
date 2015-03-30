package views.beans;

import java.io.Serializable;

import controllers.ControllerFactory;
import controllers.ejb.ControllerEjbFactory;

public class EliminarTemaBean extends TemaBean implements Serializable, GenericBean {
	private static final long serialVersionUID = 1L;

    private Integer id;

    public EliminarTemaBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void process() {
    	ControllerFactory.setFactory(new ControllerEjbFactory());
    	ControllerFactory.getFactory().getEliminarTemaController().eliminarTema(id);
    }
}
