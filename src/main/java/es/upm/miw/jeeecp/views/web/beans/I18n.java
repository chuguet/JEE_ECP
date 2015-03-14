package es.upm.miw.jeeecp.views.web.beans;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class I18n {

    private Locale locale;

    public I18n() {
        this.setLocale(FacesContext.getCurrentInstance().getExternalContext().getRequestLocale());
    }

    public String change(String language) {
        this.locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return null;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
