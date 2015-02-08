package com.example.tutorial2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final int REQUEST_CODE = 1;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClick(View view) {
    EditText text = (EditText) findViewById(R.id.inputforintent);
    // used later
    if(text.getText().toString()!=""){
	    String value = text.getText().toString();
	    Intent intent = new Intent(this, ResultActivity.class);
	    intent.putExtra("Message", value);
	    startActivityForResult(intent,REQUEST_CODE);
	}
    else{
    	Toast.makeText(this,"Input Harus Diisi", Toast.LENGTH_SHORT);
    }
  }
  
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
	      if (data.hasExtra("MessageBack")) {
	        String result = data.getExtras().getString("MessageBack");
	        if (result != null && result.length() > 0) {
	          Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	        }
	      }
	    }
  }

} 
