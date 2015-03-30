package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import controllers.EliminarTemaController;

public class EliminarTemaEjbController extends TemaEjbController implements EliminarTemaController {

	@Override
	public void eliminarTema(Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().deleteById(id);
	}

}
