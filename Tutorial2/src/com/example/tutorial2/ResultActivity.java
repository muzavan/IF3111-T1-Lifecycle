package com.example.tutorial2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_result);
		Bundle receivedBundle = this.getIntent().getExtras();
		String message = receivedBundle.getString("Message");
		TextView text = (TextView) findViewById(R.id.displayintentextra);
		text.setText(message);
	}
	
	@Override
	public void finish() {
	  Intent intent = new Intent();
	  EditText editText = (EditText) findViewById(R.id.returnValue);
	  String returnValue = editText.getText().toString();
	  intent.putExtra("MessageBack", returnValue);
	  setResult(RESULT_OK, intent);
	  super.finish();
	}
}