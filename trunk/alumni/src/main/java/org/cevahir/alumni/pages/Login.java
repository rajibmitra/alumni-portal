package org.cevahir.alumni.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.cevahir.alumni.services.UserManager;

public class Login {
	private static final String BAD_CREDENTIALS = "Bad login and/or password. Please retry.";

	@Persist
	private boolean error = false;

	@ApplicationState(create=false)
	private String login;

	@Inject
	@Service("userManager")
	private UserManager userManager;

	private String password;

	public String getLogin() {
		return login;
	}

	@Validate("required")
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public String getErrorMessage() {
		String ret = null;
		if (error) {
			ret = BAD_CREDENTIALS;
		}
		return ret;
	}

	@Validate("required")
	public void setPassword(String password) {
		this.password = password;
	}

	String onSuccess() {
		String ret = "Login";
		error = true;
		if (userManager.checkLogin(login, password)) {
			error = false;
			ret = "Home";
		}
		return ret;
	}

}
