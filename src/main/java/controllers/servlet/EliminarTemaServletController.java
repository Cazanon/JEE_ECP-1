package controllers.servlet;

import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import controllers.EliminarTemaController;

public class EliminarTemaServletController implements EliminarTemaController {

	@Override
	public void eliminarTema(Tema tema) {
		DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().deleteById(tema.getId());
	}

	@Override
	public List<Tema> obtenerListaTemas() {
		DaoFactory.setFactory(new DaoJpaFactory());
    	List<Tema> listaTemas = DaoFactory.getFactory().getTemaDao().findAll();
    	return listaTemas;
	}

}
