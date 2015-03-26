package controllers.servlet;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import controllers.VerVotacionesController;

public class VerVotacionesServletController implements VerVotacionesController {

	@Override
	public List<Integer> obtenerListaVotosPorTema(List<Tema> temas) {
		List<Integer> numeroVotosPorTema = new ArrayList<Integer>();
		DaoFactory.setFactory(new DaoJpaFactory());
		for(Tema tema : temas) {
			numeroVotosPorTema.add(tema.getVotos().size());
		}
    	return numeroVotosPorTema;
	}

}
