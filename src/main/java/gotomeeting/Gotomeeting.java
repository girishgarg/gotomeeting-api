package gotomeeting;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.logmein.gotocorelib.api.OAuth2Api;
import com.logmein.gotocorelib.api.common.ApiException;
import com.logmein.gotocorelib.api.model.LoginResponse;
//import java.net.URL;
//import javax.print.DocFlavor.URL;

public class Gotomeeting {
	public static void main(String[] args) throws ApiException /*throws MalformedURLException, IOException, URISyntaxException*/, FailingHttpStatusCodeException, MalformedURLException, IOException, URISyntaxException{
	String consumerKey = "NgzPn48YEARvjKgdCtFNNbcjpnX1yK6z";
	String redirectUrl = "https://www.google.co.in/";
	OAuth2Api oauth2Api = new OAuth2Api();
	String authUrl = oauth2Api.getOAuth2AuthorisationUrl(consumerKey, redirectUrl); 
	System.out.println(authUrl);
	
	//System.out.println(page);
	Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
		Desktop.getDesktop().browse(new URL(authUrl).toURI());
	}
	
	
	//HtmlPage page = webClient.getPage(authUrl);
	
	//HtmlPage page; 
	URL url = page.getUrl();
	String responseKey = oauth2Api.getResponseKey(url);
	LoginResponse response = oauth2Api.getAccessTokenResponse(consumerKey, responseKey);
	String accessToken = response.getAccessToken(); 
	System.out.println(accessToken);
}
}
