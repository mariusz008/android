package com.teamproject.windows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//import com.teamproject.windows.Registration.GetClass;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Test extends Activity {
	private Button button;
	final Context context = this;
	 private String WYNIK;
	 private TextView data;
	ProgressDialog progress;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);	
		button = (Button) findViewById(R.id.buttonAlert);	
		data = (TextView) findViewById(R.id.showOutput);
		//asyncTask.delegate = this;
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			String output = "";
			String wy="";
			
			wy=	sendGetRequest(arg0);

//			try {
//				wy = sendGetRequest(arg0);
//			} catch (InterruptedException | ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//String elo = data.toString();
//			Toast.makeText(Test.this, output,
//		      		   Toast.LENGTH_LONG).show();
//			
			}
			});	
	}
	
	
//	public String sendGetRequest(View View) throws InterruptedException, ExecutionException {
//	    //new GetClass(this).execute();
//	    GetClass getclass = new GetClass(this);
//	    getclass.execute();
//	    return getclass.get();
//	}
	   public String sendGetRequest(View View) {
		    GetClass getclass = new GetClass(this);
		    getclass.execute();
		    return getclass.getStatus().toString();
		}
	private class GetClass extends AsyncTask<String, Void, String> {
		 
        private final Context context;
        public String wynik12="";
        public GetClass(Context c){
            this.context = c;
        }
        public String getWynik(){
    		return wynik12;
    	}
    	public void setWynik(String i){
    		this.wynik12 = i;
    	}
        protected void onPreExecute(){
            progress= new ProgressDialog(this.context);
            progress.setMessage("Loading");
            progress.show();
        }
        @Override
        protected String doInBackground(String... params) {
            String urlek="http://209785serwer.iiar.pwr.edu.pl/Rest/rest/user/login?login=mariusz14&password=mariusz1441";
            String urlek1=" http://209785serwer.iiar.pwr.edu.pl/Rest/rest/user?name=poco23&surname=p&login=ppp1ococo&password=pppppppp&email=pwwwwwwww1w@o2.pl&age=1&sex=M&club=&obywatelstwo=&nr_tel=&ice=";
          String wynik1="";
            try {
            	
                final TextView outputView = (TextView) findViewById(R.id.showOutput);
                URL url = new URL(urlek1);
			 HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			 connection.setRequestMethod("PUT");
			 BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 String line = "";
			 StringBuilder responseOutput = new StringBuilder();
			 
			 while((line = br.readLine()) != null ) {
			 responseOutput.append(line);
			 }
			 br.close();
			 final String wynik = responseOutput.toString();
			 wynik12=wynik;
			 wynik1=wynik;
			 Test.this.runOnUiThread(new Runnable() {
			 @Override
			 public void run() {
			 outputView.setText(wynik);
			 setWynik(wynik);
			 progress.dismiss();
			 
			 }
			 });
			 
			 } catch (MalformedURLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 return wynik1;
			 }
       
	}

}
