package my.app.entest.controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import my.app.entest.R;

public class AboutBoxController extends Activity{
	
	private Button btnExitButton;
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_about_box);
        
        btnExitButton = findViewById(R.id.about_box);
        btnExitButton.setOnClickListener((v) -> {
				finish();
		});
        
	}
	
	
	

}
