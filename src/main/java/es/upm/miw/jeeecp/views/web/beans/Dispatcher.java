package es.upm.miw.jeeecp.views.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher/*")
public class Dispatcher extends HttpServlet {

	private static final long serialVersionUID = -8237077722948003615L;

    private static String PATH_ROOT_VIEW = "/jsp/";
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "votar":
            /*PersonaView personaView = new PersonaView();
            personaView.setPersona(new Persona());
            request.setAttribute(action, personaView);*/
            view = action;
            break;
        case "anadirtema":
            /*RolView rolView = new RolView();
            request.setAttribute(action, rolView);*/
            view = action;
            break;
        case "eliminartema":
            /*RolView rolView = new RolView();
            request.setAttribute(action, rolView);*/
            view = action;
            break;
        case "vervotaciones":
            /*RolView rolView = new RolView();
            request.setAttribute(action, rolView);*/
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);

        String view;
        switch (action) {
        case "votar":
            /*PersonaView personaView = new PersonaView();
            personaView.setPersona(new Persona());
            request.setAttribute(action, personaView);*/
            view = action;
            break;
        case "anadirtema":
        	System.out.println(request.getParameter("nombre"));
        	System.out.println(request.getParameter("pregunta"));
            /*RolView rolView = new RolView();
            request.setAttribute(action, rolView);*/
            view = action;
            break;
        case "eliminartema":
            /*RolView rolView = new RolView();
            request.setAttribute(action, rolView);*/
            view = action;
            break;
        case "vervotaciones":
            /*RolView rolView = new RolView();
            request.setAttribute(action, rolView);*/
            view = action;
            break;
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
	}

}
