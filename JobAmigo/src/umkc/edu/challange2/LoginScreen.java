

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

public class LoginScreen extends Activity implements OnInitListener{
	private SharedPreferences pref;
	private EditText password;
	private TextToSpeech tts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		pref=this.getSharedPreferences("edu.umkc.lee", 0);	
tts=new TextToSpeech(getApplicationContext(),this);
		EditText username=(EditText)findViewById(R.id.username);
		password=(EditText)findViewById(R.id.password);
		Button signin=(Button) findViewById(R.id.signin);
		signin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String pass=pref.getString("password", "abcd");
				//				Toast.makeText(getApplicationContext(), pass, 5000).show();
				if(password.getText().toString().equals(pass))
				{
					tts.speak("you are successfully Authenticated", TextToSpeech.QUEUE_FLUSH, null);
					Toast.makeText(getApplicationContext(), "Successfully authenticated", 5000).show();
					Intent i =new Intent(getApplicationContext(), MainActivity.class);
					startActivity(i);
				}
				else
					Toast.makeText(getApplicationContext(), "wrong password please register", 5000).show();
				
			}
		});
		Button regButton=(Button) findViewById(R.id.register);
		regButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tts.speak("Enter details ", TextToSpeech.QUEUE_FLUSH, null);
				
				Intent i = new Intent(LoginScreen.this,RegisterScreeen.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_screen, menu);
		return true;
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		
	}
}
