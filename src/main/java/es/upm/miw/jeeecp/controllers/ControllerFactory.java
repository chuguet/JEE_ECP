package es.upm.miw.jeeecp.controllers;

public abstract class ControllerFactory {

	public abstract AnadirTemaController getAnadirTemaController();

	public abstract EliminarTemaController getEliminarTemaController();

	public abstract VerVotacionesController getVerVotacionesController();

	public abstract VotarController getVotarController();

}
