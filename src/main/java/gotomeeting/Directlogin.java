package gotomeeting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.eclipse.jetty.client.api.Authentication;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.impl.client.DefaultHttpClient;
//import com.logmein.gotocorelib.api;
import com.logmein.gotocorelib.api.AuthenticationApi;
import com.logmein.gotocorelib.api.common.ApiException;
import com.logmein.gotocorelib.api.model.LoginResponse;
public class Directlogin {
	public static void main(String[] args) throws ClientProtocolException, IOException, JSONException{
		
		HttpClient client = new DefaultHttpClient();
		StringBuilder   builder = new StringBuilder();
		String userid = "enter mail" ;
		String password = "enterpassword";
		  HttpGet request = new HttpGet("https://api.getgo.com/oauth/access_token?grant_type=password&user_id="+userid+"&password="+password+"&client_id=NgzPn48YEARvjKgdCtFNNbcjpnX1yK6z");
		 
		  HttpResponse response = client.execute(request);
		  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		  String line = "";
		  while ((line = rd.readLine()) != null) {
		   // System.out.println(line);
		    builder.append(line);
		  }
		  JSONObject  jsonObject = new JSONObject(builder.toString());
		  String name = jsonObject.getString("access_token");
		 // System.out.println(name);
		  
		  //for fetching data
		  /*HttpClient client1 = new DefaultHttpClient();
		  HttpGet request1 = new HttpGet("https://api.getgo.com/G2M/rest/upcomingMeetings");
		  request1.addHeader("Authorization", "Bearer "+name);
		  HttpResponse response1 = client1.execute(request1);
		  BufferedReader rd1 = new BufferedReader (new InputStreamReader(response1.getEntity().getContent()));
		  String line1 = "";
		  while ((line1 = rd1.readLine()) != null) {
		    System.out.println(line1);
		    
		  }*/
		  
		  //for creating meeting and gotolink
		  HttpClient client11 = new DefaultHttpClient();
		  StringBuilder   builder1 = new StringBuilder();
		  HttpPost request11 = new HttpPost("https://api.getgo.com/G2M/rest/meetings");
		  request11.addHeader("Authorization", "Bearer "+name);
		  
		  JSONObject json = new JSONObject();
		  
		  json.put("subject", "sadafssa");
		  json.put("starttime", "2017-09-18T13:00:00Z");
		  json.put("endtime", "2017-09-18T14:00:00Z");
		  json.put("passwordrequired", "true");
		  json.put("conferencecallinfo", "video");
		  json.put("timezonekey","string");
		  json.put("meetingtype", "immediate");
		  //json.put("timezonekey","string");
		  StringEntity se = new StringEntity(json.toString());
		  request11.setEntity(se);
		  HttpResponse response11 = client11.execute(request11);
		  BufferedReader rd11 = new BufferedReader (new InputStreamReader(response11.getEntity().getContent()));
		  String line11 = "";
		  while ((line11 = rd11.readLine()) != null) {
		    System.out.println(line11);
		    builder1.append(line11);
		  }
		 // JSONObject  jsonObject1 = new JSONObject(builder1.toString());
		 // String name1 = jsonObject1.getString("joinURL");
		  
	}

}
