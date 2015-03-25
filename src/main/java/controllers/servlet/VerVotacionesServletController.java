package controllers.servlet;

import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Voto;
import controllers.VerVotacionesController;

public class VerVotacionesServletController implements VerVotacionesController {

	@Override
	public List<Voto> obtenerListaVotosPorTema(Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
    	return DaoFactory.getFactory().getTemaDao().read(id).getVotos();
	}

}
