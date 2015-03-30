package controllers.ejb;

import controllers.AnyadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.TemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;

public class ControllerEjbFactory extends ControllerFactory {

	private AnyadirTemaController anyadirTemaController;
	private EliminarTemaController eliminarTemaController;
	private TemaController temaController;
	private VerVotacionesController verVotacionesController;
	private VotarController votarController;

	@Override
	public AnyadirTemaController getAnyadirTemaController() {
		if (this.anyadirTemaController == null) {
			this.anyadirTemaController = new AnyadirTemaEjbController();
		}
		return anyadirTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (this.eliminarTemaController == null) {
			this.eliminarTemaController = new EliminarTemaEjbController();
		}
		return eliminarTemaController;
	}

	@Override
	public TemaController getTemaController() {
		if (this.temaController == null) {
			this.temaController = new TemaEjbController();
		}
		return temaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (this.verVotacionesController == null) {
			this.verVotacionesController = new VerVotacionesEjbController();
		}
		return verVotacionesController;
	}

	@Override
	public VotarController getVotarController() {
		if (this.votarController == null) {
			this.votarController = new VotarEjbController();
		}
		return votarController;
	}

}
