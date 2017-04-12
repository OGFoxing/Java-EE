/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ogfox.web.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author pala4
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class LocaleChanger implements Serializable{
    private Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    
    public LocaleChanger() {
    }
    
    public void changeLocale(String locale) {
        currentLocale = new Locale(locale);
    }
    
    public Locale getCurrentLocale() {
        return currentLocale;
    }
}
