package org.cevahir.alumni.pages;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.services.Session;

public class Home {
	@Inject
	private ComponentResources resources;

	@Inject
	private RequestGlobals requestGlobals;

	@ApplicationState(create=false)
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@OnEvent(component = "logout")
	public Link onLogout() {
		Session session = requestGlobals.getRequest().getSession(false);
		if (session != null)
			session.invalidate();
		return resources.createPageLink("login", false);
	}

}
