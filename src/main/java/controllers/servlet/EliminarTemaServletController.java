package controllers.servlet;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import controllers.EliminarTemaController;

public class EliminarTemaServletController extends TemaServletController implements EliminarTemaController {

	@Override
	public void eliminarTema(Tema tema) {
		DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().deleteById(tema.getId());
	}

}
