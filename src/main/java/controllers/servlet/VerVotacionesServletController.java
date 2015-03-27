package controllers.servlet;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.utils.NivelEstudios;
import utils.Utils;
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

	@Override
	public List<List<Double>> obtenerListaVotosPorTemaYNivelDeEstudios(
			List<Tema> temas) {
		List<List<Double>> numeroVotosPorTemaYNivelDeEstudios = new ArrayList<List<Double>>();
		DaoFactory.setFactory(new DaoJpaFactory());
		for(NivelEstudios nivelEstudios : NivelEstudios.values()) {
			numeroVotosPorTemaYNivelDeEstudios.add(Utils.calcularMedia(temas, nivelEstudios.toString()));
		}
		return numeroVotosPorTemaYNivelDeEstudios;
	}

}
