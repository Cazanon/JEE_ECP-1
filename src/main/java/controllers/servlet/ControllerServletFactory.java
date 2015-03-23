package controllers.servlet;

import controllers.AnyadirTemaController;
import controllers.ControllerFactory;

public class ControllerServletFactory extends ControllerFactory {
	
	private AnyadirTemaController anyadirTemaController;

	@Override
	public AnyadirTemaController getAnyadirTemaController() {
		if (this.anyadirTemaController == null) {
			this.anyadirTemaController = new AnyadirTemaServletController();
			}
			return anyadirTemaController;
	}

}
