package my.app.entest.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import my.app.entest.R;

public class EntestController extends Activity {
	
	private Button btnStart;
	private Button btnAbout;
	private Button btnExit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entest);

		btnStart = findViewById(R.id.start);
		btnStart.setOnClickListener((v) -> {
			Intent intent = new Intent(EntestController.this, MenuTestController.class);
			startActivity(intent);
		});
		
		btnAbout = findViewById(R.id.about);
		btnAbout.setOnClickListener((v) -> {
			Intent intent = new Intent(EntestController.this, AboutBoxController.class);
			startActivity(intent);
		});
		
		btnExit = findViewById(R.id.exit);
		btnExit.setOnClickListener((v) -> {
			exit();
		});
	}

	private void exit() {
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(1);
	}

	@Override
	public void onBackPressed() {
	    exit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
