import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.wink.json4j.JSONObject;
import org.junit.Test;


/**
 * This class shows how a client library communicates with the remote driver  (RemoteWebDriver Server)
 * @author Lewis
 *
 */
public class TestScriptUsingJSONWireProtocol {
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestScriptUsingJSONWireProto(){
		
		@SuppressWarnings("deprecation")
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response=null;
		String searchBox = null;
		String searchButton = null;
		HttpPost postMethod = null;
		HttpGet getMethod = null;
		HttpDelete deleteMethod = null;
		
		try{
			/*Create a session with RemoteWebDriver to open Internet Explorer*/
			postMethod = new HttpPost("http://10.1.2.11:4444/wd/hub/session");
			StringEntity input = null;
			JSONObject jo = new JSONObject();
			jo.put("browserName", "internet explorer");
			JSONObject caps = new JSONObject();
			caps.put("desiredCapabilities", jo);
			System.out.println(caps.toString());
			input = new StringEntity(caps.toString());
			input.setContentEncoding("UTF-8");
			input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			postMethod.setEntity(input);
			
			/*postMethod.set */
			response = httpClient.execute(postMethod);
			
			/*Get sessions*/
			httpClient = new DefaultHttpClient();
			getMethod = new HttpGet("http://10.1.2.11:4444/wd/hub/sessions");
			response = httpClient.execute(getMethod);
			JSONObject json = new JSONObject(response.getEntity().getContent());
			System.out.println(json.toString());
			
			String sessionId = new JSONObject(json.getString("value").substring(1, json.getString("value").length()-1)).getString("id");
				System.out.println("Current SessionId is:  " + sessionId);
				
				/*Navigae to Google Search page*/
				httpClient = new DefaultHttpClient();
				postMethod = new HttpPost("http://10.1.2.11:4444/wd/hub/session/"+sessionId+"/url");
				jo = new JSONObject();
				jo.put("url","http://www.google.com");
				input = new StringEntity(jo.toString());
				input.setContentEncoding("UTF-8");
				input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				postMethod.setEntity(input);
				response = httpClient.execute(postMethod);
				
				/*Find SearchBox Element*/
				httpClient = new DefaultHttpClient();
				postMethod = new HttpPost("http://10.1.2.11:4444/wd/hub/session/"+sessionId+"/element");
				jo = new JSONObject();
				jo.put("using","name");
				jo.put("value","q");
				input = new StringEntity(jo.toString());
				input.setContentEncoding("UTF-8");
				input.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				postMethod.setEntity(input);
				response = httpClient.execute(postMethod);
				json = new JSONObject(response.getEntity().getContent());
				System.out.println(json.toString());
				String searchBoxId = json.getJSONObject("value").getString("ELEMENT");
				System.out.println("SearchBox Id is :  " + searchBoxId);
				
				/*Click on SearchBox*/
				httpClient = new DefaultHttpClient();
				postMethod = new HttpPost("http://10.1.2.11:4444/wd/hub/session/"+sessionId+"/element/"+searchBoxId+"/click");
				response = httpClient.execute(postMethod);
				
				/*Type Packt Publishing in SearchBox*/
				httpClient = new DefaultHttpClient();
				postMethod = new HttpPost("http://10.1.2.11:4444/wd/hub/session/"+sessionId+"/element/"+searchBoxId+"/value");
				jo = new JSONObject();
				jo.put("value", Arrays.asList(new String[] {"packt publishing"}));
				postMethod.setEntity(input);
				response = httpClient.execute(postMethod);
				
				/*End the Session*/
				httpClient = new DefaultHttpClient();
				postMethod = new HttpPost("http://10.1.2.11:4444/wd/hub/session/"+sessionId);
				//response = httpClient.execute(deleteMethod);
		}catch (Exception e){
			e.printStackTrace();
		}
			
	   /*Replacing the client library with your own code.....To better understand what the how the client library talks to the remote webdriver
	    * server...Very cool
	    */
		
		/*Each section in the original test script that uses a client library has a corresponding section in the other test script that
		 * does not use the client library.   Each command is mapped to an API, and the necessary JSON payload is built and sent accross
		 * the wire to the server or driver.  This is what the client library does all day
		 */
		 
		 /*In the previous example, we have used RemoteWebDriver; but you can instead talk directly to the drivers such as FireFox Driver,
		  * IE Driver, and Chrome Driver by replaceing the RemoteWebDriver server URL with the corresponding driver URL, tha is:
		  * http://localhost:<<port_the_driver_is_running>>.  You just have to make sure the drive is up and running. 
		  * 
		  */
		
		
	}

}
