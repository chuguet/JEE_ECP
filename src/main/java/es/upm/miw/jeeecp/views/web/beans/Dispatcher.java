package es.upm.miw.jeeecp.views.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.jeeecp.controllers.ControllerFactory;
import es.upm.miw.jeeecp.controllers.ejb.ControllerEJBFactory;
import es.upm.miw.jeeecp.models.entities.TemaEntity;

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
            /*
             * PersonaView personaView = new PersonaView();
             * personaView.setPersona(new Persona());
             * request.setAttribute(action, personaView);
             */
            view = action;
            break;
        case "anadirTema":
            AnadirTemaBean anadirTemaBean = new AnadirTemaBean();
            anadirTemaBean.setTema(new TemaEntity());
            request.setAttribute(action + BEAN, anadirTemaBean);
            view = action;
            break;
        case "eliminarTema":
            /*
             * RolView rolView = new RolView(); request.setAttribute(action,
             * rolView);
             */
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

        String view;
        switch (action) {
        case "votar":
            /*
             * PersonaView personaView = new PersonaView();
             * personaView.setPersona(new Persona());
             * request.setAttribute(action, personaView);
             */
            view = action;
            break;
        case "anadirTema":
            TemaEntity temaEntity = new TemaEntity(Integer.parseInt(request.getParameter("id")),
                    request.getParameter("nombre"), request.getParameter("pregunta"));
            AnadirTemaBean anadirTemaBean = new AnadirTemaBean(temaEntity);
            anadirTemaBean.setControllerFactory(controllerFactory);
            request.setAttribute(action + BEAN, anadirTemaBean);
            anadirTemaBean.process();
            view = action;
            break;
        case "eliminarTema":
            /*
             * RolView rolView = new RolView(); request.setAttribute(action,
             * rolView);
             */
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
