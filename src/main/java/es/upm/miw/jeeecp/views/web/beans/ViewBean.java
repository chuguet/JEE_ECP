package es.upm.miw.jeeecp.views.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import es.upm.miw.jeeecp.controllers.ControllerFactory;

public class ViewBean implements Serializable {

    private static final long serialVersionUID = 8793678886355302470L;

    @ManagedProperty(value = "#{controllerWSFactory}")
    private ControllerFactory controllerFactory;

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

}
