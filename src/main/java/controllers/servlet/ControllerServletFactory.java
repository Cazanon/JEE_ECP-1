package controllers.servlet;

import controllers.AnyadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;

public class ControllerServletFactory extends ControllerFactory {
	
	private AnyadirTemaController anyadirTemaController;
	private EliminarTemaController eliminarTemaController;

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

}
