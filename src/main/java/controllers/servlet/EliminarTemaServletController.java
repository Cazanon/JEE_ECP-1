package controllers.servlet;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import controllers.EliminarTemaController;

public class EliminarTemaServletController extends TemaServletController implements EliminarTemaController {

	@Override
	public void eliminarTema(Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().deleteById(id);
	}

}
