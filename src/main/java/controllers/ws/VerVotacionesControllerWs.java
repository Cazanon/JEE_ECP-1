package controllers.ws;

import java.util.List;

import persistence.models.entities.Tema;
import controllers.VerVotacionesController;

public class VerVotacionesControllerWs implements VerVotacionesController {

	@Override
	public List<Integer> obtenerListaVotosPorTema(List<Tema> temas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Double>> obtenerListaVotosPorTemaYNivelDeEstudios(
			List<Tema> temas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> obtenerColumnHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> calcularMedia(List<Tema> temas, String nivelDeEstudios) {
		// TODO Auto-generated method stub
		return null;
	}

}
