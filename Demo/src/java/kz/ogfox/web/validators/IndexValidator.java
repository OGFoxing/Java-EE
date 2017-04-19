/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.ogfox.web.validators;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author pala4
 */
@FacesValidator("kz.ogfox.web.validators.IndexValidator")
public class IndexValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        ResourceBundle rs = ResourceBundle.getBundle("kz.ogfox.web.nls.messages",FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
        try {
            String newValue = value.toString();
            if(newValue.length() < 3) {
                throw new IllegalArgumentException(rs.getString("login_lenght_error"));
            }
            if(!Character.isLetter(newValue.charAt(0))) {
                throw new IllegalArgumentException(rs.getString("first_symbor_error"));
            }
            
        }
        catch (IllegalArgumentException ex){
            FacesMessage msg = new FacesMessage(ex.getMessage());
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
