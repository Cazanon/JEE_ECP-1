package controllers.ejb;

import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import controllers.TemaController;

public class TemaEjbController implements TemaController {

	@Override
	public List<Tema> obtenerListaTemas() {
		DaoFactory.setFactory(new DaoJpaFactory());
    	List<Tema> listaTemas = DaoFactory.getFactory().getTemaDao().findAll();
    	return listaTemas;
	}

}
