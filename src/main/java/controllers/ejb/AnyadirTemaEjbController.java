package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import controllers.AnyadirTemaController;

public class AnyadirTemaEjbController extends TemaEjbController implements AnyadirTemaController {

	@Override
	public void anyadirTema(Tema tema) {
    	DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().create(tema);
	}

}
