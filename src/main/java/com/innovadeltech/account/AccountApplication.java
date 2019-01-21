package com.innovadeltech.account;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("restapi")
public class AccountApplication extends ResourceConfig{
	public AccountApplication() {
		packages("com.innovadeltech.account.rest");
	}
}
