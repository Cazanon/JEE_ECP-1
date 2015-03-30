package controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;
import controllers.VotarController;

public class VotarEjbController implements VotarController {

	@Override
	public void votar(Integer id, Voto voto) {
		DaoFactory.setFactory(new DaoJpaFactory());
		Tema tema = DaoFactory.getFactory().getTemaDao().read(id);
		tema.setVoto(voto);
    	DaoFactory.getFactory().getTemaDao().update(tema);
	}

	@Override
	public List<String> getNivelesEstudios() {
		List<String> nivelesEstudios = new ArrayList<String>();
		for(NivelEstudios nivelEstudios : NivelEstudios.values()) {
			nivelesEstudios.add(nivelEstudios.name());
		}
		return nivelesEstudios;
	}

}
