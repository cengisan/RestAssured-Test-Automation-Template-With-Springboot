package com.springboot.automation.testclasses;

import com.springboot.automation.assertion.Assertion;
import com.springboot.automation.controller.AuthController;
import com.springboot.automation.model.request.auth.AuthRequest;
import com.springboot.automation.model.response.auth.AuthResponse;
import com.springboot.automation.model.response.auth.GetCurrentAuthUserResponse;
import com.springboot.automation.model.response.auth.RefreshAuthSessionResponse;
import com.springboot.automation.reporter.annotation.description.Description;
import com.springboot.automation.reporter.annotation.link.Link;
import com.springboot.automation.route.Route;
import com.springboot.automation.util.TestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;


@SpringBootTest
public class AuthControllerTestClass extends TestBase {

	@Autowired
	AuthController authController;
	AuthResponse authResponse = new AuthResponse();
	int userId;
	String token;

	@Test(priority = 1)
	@Link(url = "/auth/login") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
	@Description("Authenticate with a user")
	public void TestCase_AuthenticateWithUser_Success(){

		AuthRequest authRequest = new AuthRequest();
		authRequest.setUsername("kminchelle");
		authRequest.setPassword("0lelplR");
		authRequest.setExpiresInMins(30);

		authResponse = authController.AuthenticateWithUser(Route.AUTH_LOGIN, authRequest);
		Assertion.ResponseAssertion(authResponse.getFirstName(),"Jeanne");
		Assertion.ResponseAssertion(authResponse.getLastName(),"Halvorson");
		userId = authResponse.getId();
		token = authResponse.getToken();
	}

	@Test(priority = 2)
	@Link(url = "/auth/me") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
	@Description("Get current authenticated user.")
	public void TestCase_GetCurrentAuthUser_Success(){

		GetCurrentAuthUserResponse getCurrentAuthUserResponse = authController.GetCurrentAuthUser(Route.AUTH_ME, token);
		Assertion.ResponseAssertion(getCurrentAuthUserResponse.getId(), userId);
		Assertion.NotNullAssertion(getCurrentAuthUserResponse.getBank());
	}

	@Test(priority = 3)
	@Link(url = "/auth/refresh") // After replacing the url in the LinkProcessor class with the jira baseurl, it is sufficient to add the jira task number here. For example JIRA-1234.
	@Description("Refresh authenticate token")
	public void TestCase_RefreshAuthSession_Success(){

		RefreshAuthSessionResponse refreshAuthSessionResponse = authController.RefreshAuthSession(Route.AUTH_REFRESH, token);
		Assertion.ResponseAssertion(refreshAuthSessionResponse.getId(), userId);
		Assertion.ResponseAssertion(refreshAuthSessionResponse.getFirstName(), authResponse.getFirstName());
		Assertion.ResponseAssertion(refreshAuthSessionResponse.getLastName(), authResponse.getLastName());
	}
}