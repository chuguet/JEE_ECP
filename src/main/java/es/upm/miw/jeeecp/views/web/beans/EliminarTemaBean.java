package es.upm.miw.jeeecp.views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import es.upm.miw.jeeecp.controllers.EliminarTemaController;
import es.upm.miw.jeeecp.controllers.VotarController;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

@ManagedBean
@ViewScoped
public class EliminarTemaBean extends ViewBean {

	private String autorizacion;

	private boolean autorizado;

	private TemaEntity tema;

	private List<TemaEntity> temas;

	public EliminarTemaBean() {
	}

	@PostConstruct
	public void init() {
		this.temas = new ArrayList<TemaEntity>();
		this.tema = new TemaEntity();
	}

	public EliminarTemaBean(String autorizacion, TemaEntity tema,
			List<TemaEntity> temas) {
		this.autorizacion = autorizacion;
		this.tema = tema;
		this.temas = temas;
	}

	public String getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}

	public TemaEntity getTema() {
		return tema;
	}

	public void setTema(TemaEntity tema) {
		this.tema = tema;
	}

	public List<TemaEntity> getTemas() {
		return temas;
	}

	public void setTemas(List<TemaEntity> temas) {
		this.temas = temas;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}


	public String process() {
		EliminarTemaController eliminarTemaController = this
				.getControllerFactory().getEliminarTemaController();
		VotarController votarController = this.getControllerFactory()
				.getVotarController();
		this.setAutorizado(eliminarTemaController.autorizar(this.getAutorizacion()));
		if (this.isAutorizado()) {
			if (this.getTema().getId() != null) {
				eliminarTemaController.eliminarTema(this.getTema());
			}
			this.setTemas(votarController.recuperaTemas());
			this.setTema(new TemaEntity());
		}
		return null;
	}

	public String eliminar() {
		EliminarTemaController eliminarTemaController = this
				.getControllerFactory().getEliminarTemaController();
		VotarController votarController = this.getControllerFactory()
				.getVotarController();
		if (this.getTema().getId() != null) {
			eliminarTemaController.eliminarTema(this.getTema());
		}
		this.setTemas(votarController.recuperaTemas());
		return null;
	}

	public String autorizar() {
		VotarController votarController = this.getControllerFactory()
				.getVotarController();
		EliminarTemaController eliminarTemaController = this
				.getControllerFactory().getEliminarTemaController();
		this.setAutorizado(eliminarTemaController.autorizar(this.getAutorizacion()));
		if (this.isAutorizado()) {
			this.setTemas(votarController.recuperaTemas());
		}
		return null;
	}

}
