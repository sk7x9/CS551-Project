package umkc.edu.challange2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.os.AsyncTask;


public class ResumeCreate extends AsyncTask<String, Void, String> {

	private String BASE_URL = "http://kc-sce-cs551.kc.umkc.edu/aspnet_client/Group6/ResumeService/Service1.svc";
	private Context contxt;
	public ResumeCreate(Context c) {
		contxt = c;
	}
	
	@Override
	protected String doInBackground(String... params) {
		
		String RESUME_URL= BASE_URL + "/validate/" +params[0] + "/" + params[1]+ "/" + params[2]+ "/" + params[3]+ "/" + params[4]+ "/" + params[5]+ "/" + params[6]+ "/" + params[7]+ "/" + params[8]+ "/" + params[9]+ "/" + params[10]+ "/" + params[11]+ "/" + params[12]; 
		return getJSONfromURL(RESUME_URL);
		}
	
	private String getJSONfromURL(String serviceurl) {
		// TODO Auto-generated method stub
		
		StringBuilder result = new StringBuilder();
		try {
			URL url = new URL(serviceurl);
		HttpURLConnection  httpUrlConnection = (HttpURLConnection)url.openConnection();
		//httpUrlConnection.setDoOutput(true);
		//httpUrlConnection.setRequestProperty("Content-Type", "application/json");
		httpUrlConnection.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				httpUrlConnection.getInputStream()));
		System.out.println(httpUrlConnection.getResponseCode());
		
		if (httpUrlConnection.getResponseCode() == 200) {
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				result.append(inputLine);
				System.out.println(inputLine);
			}
			in.close();
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return result.toString();
	}

	protected void onPostExecute(String result) {
          
		JSONObject obj;
		try {
			obj = new JSONObject(result);
			if(obj.getBoolean("success")){
				Toast.makeText(contxt, "Resume creation Successfull !!! \n Redirecting...", 
	      		Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent();
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.setClass(contxt, Resume.class);
				contxt.startActivity(intent);   
		}
		else{
				Toast.makeText(contxt, "Unable to process.... Please Re-Enter",
	      		Toast.LENGTH_SHORT).show();
				/*
				username.setText("");
				username.setFocusable(true);
				password.setFocusable(false);
				*/
		}
    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}			
}