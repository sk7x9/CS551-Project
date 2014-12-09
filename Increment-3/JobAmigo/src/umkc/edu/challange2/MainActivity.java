package umkc.edu.challange2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnInitListener{

	private Button searchbycountry;
	private Button routefinder;
	private Button weatherfinder;
	private Button apis;
	private TextToSpeech tts;
	private Button resumewriter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tts= new TextToSpeech(getApplicationContext(), this);
		searchbycountry=(Button)findViewById(R.id.searchbycountry);
		routefinder=(Button)findViewById(R.id.routefinder);
		weatherfinder=(Button)findViewById(R.id.weatherfinder);
		resumewriter=(Button)findViewById(R.id.resumewriter);

		apis=(Button)findViewById(R.id.apis);
		resumewriter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tts.speak("resume writer", TextToSpeech.QUEUE_FLUSH, null);
				Intent i = new Intent(getApplicationContext(), Resume.class);
				startActivity(i);
			
			}
		});
		apis.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				tts.speak("QR and Instagram API", TextToSpeech.QUEUE_FLUSH, null);
				Intent i = new Intent(getApplicationContext(), GenerateQRCode.class);
				startActivity(i);
			}
		});

		routefinder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				tts.speak("route Finder", TextToSpeech.QUEUE_FLUSH, null);

				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, MapView.class);
				startActivity(i);
			}
		});
		weatherfinder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts.speak("Weather Finder", TextToSpeech.QUEUE_FLUSH, null);

				Intent i = new Intent(MainActivity.this, WeatherDetail.class);
				startActivity(i);
			}
		});
		searchbycountry.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tts.speak("Search by Country code", TextToSpeech.QUEUE_FLUSH, null);
				Intent i = new Intent(MainActivity.this, JobsList.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

	}

}
