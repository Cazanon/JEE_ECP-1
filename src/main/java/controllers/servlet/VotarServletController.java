package controllers.servlet;

import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import utils.Utils;
import controllers.VotarController;

public class VotarServletController implements VotarController {

	@Override
	public void votar(Integer id, Voto voto) {
		DaoFactory.setFactory(new DaoJpaFactory());
		Tema tema = DaoFactory.getFactory().getTemaDao().read(id);
		tema.setVoto(voto);
    	DaoFactory.getFactory().getTemaDao().update(tema);
	}

	@Override
	public List<String> getNivelesEstudios() {
		return Utils.getNivelesEstudios();
	}

}
