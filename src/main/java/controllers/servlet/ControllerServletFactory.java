package controllers.servlet;

import controllers.AnyadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.TemaController;

public class ControllerServletFactory extends ControllerFactory {

	private AnyadirTemaController anyadirTemaController;
	private EliminarTemaController eliminarTemaController;
	private TemaController temaController;

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

}
