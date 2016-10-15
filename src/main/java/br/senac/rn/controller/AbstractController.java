package br.senac.rn.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.senac.rn.dao.PersistDB;

public class AbstractController<T extends PersistDB> {

    public void addInfo(String msg) {
        FacesMessage fm = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
	
}