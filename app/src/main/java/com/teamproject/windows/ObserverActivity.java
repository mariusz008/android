package com.teamproject.windows;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ObserverActivity extends Activity {
	  private Button button, button1;
	  Intent intent1;
	  String ktore_zawody = "OBSERW";
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_obser);
	        final Context context = this;
			button = (Button) findViewById(R.id.buttonAlert);
			button1 = (Button) findViewById(R.id.button2);

		   intent1 = new Intent(ObserverActivity.this, CompList.class);
			button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					ObserverActivity.this.finish();
				}
			});
			  button1.setOnClickListener(new OnClickListener() {
				  @Override
				  public void onClick(View arg0) {
					  intent1.putExtra("ktore", ktore_zawody);
					  startActivity(intent1);
				  }
			  });
    }
    

}