package controllers.servlet;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import controllers.AnyadirTemaController;

public class AnyadirTemaServletController extends TemaServletController implements AnyadirTemaController {

	@Override
	public void anyadirTema(Tema tema) {
    	DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().create(tema);
	}

}
