/**
 * 
 */
package com.devpredator.projectjsf.controllers;

import java.io.IOException;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;

/**
 * @author gonza Clase que permite controlar el funcionamiento con la pantalla
 *         de login.xhtml
 */

@SuppressWarnings("deprecation")
@ManagedBean(name = "LoginController")

public class LoginController {
	/**
	 * Usuario que ingresan en el login
	 */
	private String usuario;
	private String password;

	/**
	 * @return the usuraio
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuraio) {
		this.usuario = usuraio;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public void ingresar() {
		System.out.println("Usuario: " + usuario);

		if (usuario.equals("devpredator") && password.equals("12345")) {
			try {
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario",
						new FacesMessage(FacesMessage.SEVERITY_FATAL, "La pagina no existe", ""));
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraeña incorrecto", ""));
		}
	}

	private void redireccionar(String pagina) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}
}
