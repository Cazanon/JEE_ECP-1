package controllers.servlet;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import controllers.AnyadirTemaController;

public class AnyadirTemaServletController implements AnyadirTemaController {

	@Override
	public void anyadirTema(Tema tema) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> obtenerListaTemas() {
		DaoFactory.setFactory(new DaoJpaFactory());
    	List<Tema> listaTemas = DaoFactory.getFactory().getTemaDao().findAll();
    	ArrayList<String> listaNameTemas = new ArrayList<String>();
    	for(Tema tema : listaTemas) {
    		listaNameTemas.add(tema.getName());
    	}
    	return listaNameTemas;
	}

}
