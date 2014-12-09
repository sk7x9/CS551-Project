package umkc.edu.challange2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Resume extends Activity {
	
	private EditText  email=null;
	private EditText  firstname=null;
	private EditText  middlename=null;
	private EditText  lastname=null;
	private EditText  gender=null;
	private EditText  city=null;
	private EditText  birthdate=null;
	private EditText  phone=null;
	private EditText  country=null;
	private EditText  employed=null;
	private EditText  exp=null;
	private EditText  resumetext=null;
	private EditText  education=null;
	private Button create=null;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resume);
		email = (EditText)findViewById(R.id.email);
		firstname = (EditText)findViewById(R.id.firstname);
		middlename = (EditText)findViewById(R.id.middlename);
		lastname = (EditText)findViewById(R.id.lastname);
		gender = (EditText)findViewById(R.id.gender);
		city = (EditText)findViewById(R.id.city);
		birthdate = (EditText)findViewById(R.id.birthdate);
		phone = (EditText)findViewById(R.id.phone);
		country = (EditText)findViewById(R.id.country);
		employed = (EditText)findViewById(R.id.employed);
		exp = (EditText)findViewById(R.id.exp);
		resumetext = (EditText)findViewById(R.id.resumetext);
		education = (EditText)findViewById(R.id.education);
	    
	    create = (Button)findViewById(R.id.resumesubmit);
		    
	   
	    create.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        	
	        	if(email.getText().toString().equals("") || firstname.getText().toString().equals("") || middlename.getText().toString().equals("") || lastname.getText().toString().equals("") || gender.getText().toString().equals("") || city.getText().toString().equals("") || birthdate.getText().toString().equals("") || phone.getText().toString().equals("") || country.getText().toString().equals("") || employed.getText().toString().equals("") || exp.getText().toString().equals("") || resumetext.getText().toString().equals("") || education.getText().toString().equals("")) {
	        		Toast.makeText(getApplicationContext(), "Please Enter your details !!", 
				      		Toast.LENGTH_SHORT).show();
	        	}else 	
	        		new ResumeCreate(getApplicationContext()).execute(email.getText().toString(),firstname.getText().toString(),middlename.getText().toString(),lastname.getText().toString(),gender.getText().toString(),city.getText().toString(),birthdate.getText().toString(),phone.getText().toString(),country.getText().toString(),employed.getText().toString(),exp.getText().toString(),resumetext.getText().toString(),education.getText().toString());
	        	Intent i =new Intent(getApplicationContext(), EndActivity.class);
				Resume.this.startActivity(i);
			
	        }
	    
	    });
	    
	}
}