package utils;

import java.util.ArrayList;
import java.util.List;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

public class Utils {

	public static List<Double> calcularMedia(List<Tema> temas, String nivelDeEstudios) {
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

	public static List<String> getNivelesEstudios() {
		List<String> nivelesEstudios = new ArrayList<String>();
		for(NivelEstudios nivelEstudios : NivelEstudios.values()) {
			nivelesEstudios.add(nivelEstudios.name());
		}
		return null;
	}

}
