package controllers.ws;

import controllers.AnyadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.TemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;

//@ManagedBean(name = "controllerFactory")
//@SessionScoped
public class ControllerWsFactory extends ControllerFactory {

    private AnyadirTemaController anyadirTemaController;

    private EliminarTemaController eliminarTemaController;
    
    private TemaController temaController;

    private VerVotacionesController verVotacionesController;

    private VotarController votarController;

    public ControllerWsFactory() {
    }

	@Override
	public AnyadirTemaController getAnyadirTemaController() {
		if (anyadirTemaController == null) {
			anyadirTemaController = new AnyadirTemaControllerWs();
        }
        return anyadirTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaControllerWs();
        }
        return eliminarTemaController;
	}

	@Override
	public TemaController getTemaController() {
		if (temaController == null) {
			temaController = new TemaControllerWs();
        }
        return temaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerWs();
        }
        return verVotacionesController;
	}

	@Override
	public VotarController getVotarController() {
		if (votarController == null) {
			votarController = new VotarControllerWs();
        }
        return votarController;
	}

}
