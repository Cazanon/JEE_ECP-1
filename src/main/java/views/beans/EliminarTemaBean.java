package views.beans;

import java.io.Serializable;
import java.util.List;

import controllers.ControllerFactory;
import controllers.servlet.ControllerServletFactory;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;

public class EliminarTemaBean implements Serializable, GenericBean {
	private static final long serialVersionUID = 1L;

	private List<Tema> temas;

    private Integer id;

    public EliminarTemaBean() {
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void update() {
    	ControllerFactory.setFactory(new ControllerServletFactory());
    	this.temas = ControllerFactory.getFactory().getAnyadirTemaController().obtenerListaTemas();
    	//this.temas.addAll(ControllerFactory.getFactory().getAnyadirTemaController().obtenerListaTemas());
    }
    
    public void process() {
    	DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().deleteById(id);
//    	Tema tema = new Tema();
//    	tema.setName(this.getTema());
//    	tema.setPregunta(this.getPregunta());
//    	ControllerFactory.setFactory(new ControllerServletFactory());
//    	ControllerFactory.getFactory().getAnyadirTemaController().anyadirTema(tema);
    }
}