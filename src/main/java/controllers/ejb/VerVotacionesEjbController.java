package controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;
import controllers.VerVotacionesController;

public class VerVotacionesEjbController implements VerVotacionesController {

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
			numeroVotosPorTemaYNivelDeEstudios.add(calcularMedia(temas, nivelEstudios.toString()));
		}
		return numeroVotosPorTemaYNivelDeEstudios;
	}

	@Override
	public List<String> obtenerColumnHeaders() {
		List<String> columnsHeaders = new ArrayList<String>();
		columnsHeaders.add("Temas:");
		columnsHeaders.add("Número de votos:");
		for(NivelEstudios nivelEstudios : NivelEstudios.values()) {
			columnsHeaders.add(nivelEstudios.name() + ":");
		}
		return columnsHeaders;
	}
	
	@Override
	public List<Double> calcularMedia(List<Tema> temas, String nivelDeEstudios) {
		List<Double> mediaVotosPorNivelDeEstudios = new ArrayList<Double>();
		int sumaValoraciones;
		int totalVotos;
		double media;

		for (Tema tema : temas) {
			sumaValoraciones = 0;
			totalVotos = 0;
			media = 0;
			for (Voto voto : tema.getVotos()) {
				if(voto.getNivelEstudios().name().equals(nivelDeEstudios)) {
					sumaValoraciones += voto.getValoracion();
					totalVotos++;
				}
			}
			if(totalVotos == 0) {
				media = 0;
			} else {
				media = sumaValoraciones / totalVotos;
			}
			mediaVotosPorNivelDeEstudios.add(media);
		}

		return mediaVotosPorNivelDeEstudios;
	}

}
