package es.upm.miw.jeeecp.views.web.beans;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.jeeecp.controllers.ControllerFactory;
import es.upm.miw.jeeecp.controllers.ejb.ControllerEJBFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;
import es.upm.miw.jeeecp.models.entities.VotoEntity;
import es.upm.miw.jeeecp.models.utils.NivelEstudios;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {

    private static final String BEAN = "Bean";

    private static final String JSP = ".jsp";

    private static final long serialVersionUID = -8237077722948003615L;

    private static String PATH_ROOT_VIEW = "/views/jsp/";

    private ControllerFactory controllerFactory;

    @Override
    public void init() {
        controllerFactory = new ControllerEJBFactory();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "votar":
            VotarBean votarBean = new VotarBean();
            if (request.getParameter("id") != null) {
                votarBean.setTema(new TemaEntity(Integer.parseInt(request.getParameter("id"))));
            } else {
                votarBean.setTema(new TemaEntity());
            }
            votarBean.setVoto(new VotoEntity());
            votarBean.setTemas(new ArrayList<TemaEntity>());
            votarBean.setControllerFactory(this.controllerFactory);
            votarBean.process();
            request.setAttribute(action + BEAN, votarBean);
            view = action;
            break;
        case "anadirTema":
            AnadirTemaBean anadirTemaBean = new AnadirTemaBean();
            anadirTemaBean.setTema(new TemaEntity());
            anadirTemaBean.setControllerFactory(this.controllerFactory);
            request.setAttribute(action + BEAN, anadirTemaBean);
            view = action;
            break;
        case "eliminarTema":
            EliminarTemaBean eliminarTemaBean = new EliminarTemaBean(null, new TemaEntity(),
                    new ArrayList<TemaEntity>());
            eliminarTemaBean.setControllerFactory(this.controllerFactory);
            request.setAttribute(action + BEAN, eliminarTemaBean);
            view = action;
            break;
        case "verVotaciones":
            /*
             * RolView rolView = new RolView(); hecho en el @init el
             * controllerejb porque el managedbean no nfuncionaara cuando no
             * estemos en jsf y tendremos que inyectarlo desde aquí con un new
             * rolView.setControllerFactory(controllerEJB);
             * request.setAttribute(action, rolView);
             */
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + JSP)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        TemaEntity tema;
        VotoEntity voto;
        String view;
        switch (action) {
        case "votar":
            if (request.getParameter("id") != null) {
                tema = new TemaEntity(Integer.parseInt(request.getParameter("id")));
                voto = new VotoEntity();
            } else if (request.getParameter("valoracion") != null) {
                tema = new TemaEntity(Integer.parseInt(request.getParameter("idTema")));
                voto = new VotoEntity(Integer.parseInt(request.getParameter("valoracion")),
                        request.getRemoteAddr(), NivelEstudios.valueOf(request
                                .getParameter("nivel_estudios")));
            } else {
                tema = new TemaEntity();
                voto = new VotoEntity();
            }
            VotarBean votarBean = new VotarBean();
            votarBean.setTema(tema);
            votarBean.setVoto(voto);
            votarBean.setTemas(new ArrayList<TemaEntity>());
            votarBean.setControllerFactory(controllerFactory);
            votarBean.process();
            request.setAttribute(action + BEAN, votarBean);
            view = action;
            break;
        case "anadirTema":
            tema = new TemaEntity(Integer.parseInt(request.getParameter("id")),
                    request.getParameter("nombre"), request.getParameter("pregunta"));
            AnadirTemaBean anadirTemaBean = new AnadirTemaBean(tema);
            anadirTemaBean.setControllerFactory(controllerFactory);
            anadirTemaBean.process();
            request.setAttribute(action + BEAN, anadirTemaBean);
            view = action;
            break;
        case "eliminarTema":
            String autorizacion = request.getParameter("autorizacion");

            if (request.getParameter("id") != null) {
                tema = new TemaEntity(Integer.parseInt(request.getParameter("id")));
            } else {
                tema = new TemaEntity();
            }
            EliminarTemaBean eliminarTemaBean = new EliminarTemaBean(autorizacion, tema,
                    new ArrayList<TemaEntity>());
            eliminarTemaBean.setControllerFactory(controllerFactory);
            eliminarTemaBean.process();
            request.setAttribute(action + BEAN, eliminarTemaBean);
            view = action;
            break;
        case "verVotaciones":
            /*
             * RolView rolView = new RolView(); request.setAttribute(action,
             * rolView);
             */
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + JSP)
                .forward(request, response);
    }
}
