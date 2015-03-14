package es.upm.miw.jeeecp.views.web.beans;

import javax.faces.bean.ManagedProperty;

import es.upm.miw.jeeecp.controllers.ControllerFactory;

public class ViewBean {

    @ManagedProperty(value = "#{controllerEJBFactory}")
    private ControllerFactory controllerFactory;

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

}
