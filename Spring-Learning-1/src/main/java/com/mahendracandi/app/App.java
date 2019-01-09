package com.mahendracandi.app;

import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahendracandi.app.configuration.HelloWordConfig;
import com.mahendracandi.app.domain.HelloWorld;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*AbstractApplicationContext context = new AnnotationConfigApplicationContext(HelloWordConfig.class);
        HelloWorld bean = (HelloWorld)  context.getBean("helloWordlBean");
        bean.sayHello("Candi Mahendra");
        context.close();*/
        
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        try {
        	// getnumber send body as json 
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("NO_AGGR", "01500572001503510");
            
            MediaType JSON = MediaType.parse("");
            RequestBody body = RequestBody.create(JSON, jsonObject.toString());
            Request request = new Request.Builder()
    				.url("https://sofiadev.acc.co.id/rest/com/acc/chatbot/in/httprest/chatbot/getphonenumber")
    				.addHeader("Content-Type", "application/json")
    				.post(body)
    				.build();
    		Call call = client.newCall(request);
    		Response response = call.execute();
    		JSONObject token = new JSONObject(response.body().string());
    		System.out.println(request.body().contentType());
    		System.out.println(request.method());
    		System.out.println(request.url());
    		System.out.println(request.headers());
    		System.out.println(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
}
