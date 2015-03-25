package controllers.servlet;

import controllers.AnyadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.TemaController;
import controllers.VerVotacionesController;

public class ControllerServletFactory extends ControllerFactory {

	private AnyadirTemaController anyadirTemaController;
	private EliminarTemaController eliminarTemaController;
	private TemaController temaController;
	private VerVotacionesController verVotacionesController;

	@Override
	public AnyadirTemaController getAnyadirTemaController() {
		if (this.anyadirTemaController == null) {
			this.anyadirTemaController = new AnyadirTemaServletController();
		}
		return anyadirTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (this.eliminarTemaController == null) {
			this.eliminarTemaController = new EliminarTemaServletController();
		}
		return eliminarTemaController;
	}

	@Override
	public TemaController getTemaController() {
		if (this.temaController == null) {
			this.temaController = new TemaServletController();
		}
		return temaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (this.verVotacionesController == null) {
			this.verVotacionesController = new VerVotacionesServletController();
		}
		return verVotacionesController;
	}

}
