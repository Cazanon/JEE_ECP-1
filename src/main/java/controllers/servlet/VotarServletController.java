package controllers.servlet;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import controllers.VotarController;

public class VotarServletController implements VotarController {

	@Override
	public void votar(Tema tema, Voto voto) {
		tema.setVoto(voto);
		DaoFactory.setFactory(new DaoJpaFactory());
    	DaoFactory.getFactory().getTemaDao().update(tema);
	}

}
