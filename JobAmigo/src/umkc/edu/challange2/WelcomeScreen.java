package umkc.edu.challange2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomeScreen extends Activity implements OnInitListener {
	private TextToSpeech tts;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		tts = new TextToSpeech(WelcomeScreen.this, this);
		Button welcome = (Button) findViewById(R.id.welcomenext);
		// TODO Auto-generated method stub
		welcome.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				tts.speak("you are entering in to JobAmigo", TextToSpeech.QUEUE_FLUSH, null);

				Intent i = new Intent(getApplicationContext(),LoginScreen.class);
				startActivity(i);
			}
		});

	}
//	@Override
//	protected void onStart() {
//		// TODO Auto-generated method stub
//		super.onStart();
//
//		tts.speak("Welcome to JobAmigo", TextToSpeech.QUEUE_FLUSH, null);
//	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		tts.speak("Welcome to JobAmigo", TextToSpeech.QUEUE_FLUSH, null);
	}
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

	}

}
