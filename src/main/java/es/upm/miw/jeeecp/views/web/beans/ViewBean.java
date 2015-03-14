package es.upm.miw.jeeecp.views.web.beans;

import es.upm.miw.jeeecp.controllers.ControllerFactory;

public class ViewBean {
	
	private ControllerFactory controllerFactory;

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}

	protected ControllerFactory getControllerFactory() {
		return controllerFactory;
	}
	
}
