package my.app.entest.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import my.app.entest.R;

public class MenuTestController extends Activity{

	public static String btnSelected;
	
	private Button btnInfoArticles;
	private Button btnTestArticles;
	private Button btnInfoPrepositionsAndParticles;
	private Button btnTestPrepositionsAndParticles;
	private Button btnInfoSupplyReduction;
	private Button btnTestSupplyReduction;
	private Button btnInfoGeneralVocabulary;
	private Button btnTestGeneralVocabulary;
	private Button btnInfoCorrectFormOfVerb;
	private Button btnTestCorrectFormOfVerb;
	private Button btnInfoSomeAnyNoEvery;
	private Button btnTestSomeAnyNoEvery;

	protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);

        btnTestArticles = findViewById(R.id.startTestArticles);
        btnTestArticles.setOnClickListener((v) -> {
			btnSelected = "startTestArticles";
        	Intent intent = new Intent(MenuTestController.this, TestController.class);
        	startActivity(intent);
		});
        
        btnInfoArticles = findViewById(R.id.helpArticles);
		btnInfoArticles.setOnClickListener((v) -> {
			btnSelected = "helpArticles";
        	Intent intent = new Intent(MenuTestController.this, InfoController.class);
        	startActivity(intent);
		});
        
        btnTestPrepositionsAndParticles = findViewById(R.id.startTestPrepositions);
        btnTestPrepositionsAndParticles.setOnClickListener((v) -> {
			btnSelected = "startTestPrepositions";
			Intent intent = new Intent(MenuTestController.this, TestController.class);
			startActivity(intent);
		});
        
        btnInfoPrepositionsAndParticles = findViewById(R.id.helpPrepositions);
        btnInfoPrepositionsAndParticles.setOnClickListener((v) -> {
			btnSelected = "helpPrepositions";
			Intent intent = new Intent(MenuTestController.this, InfoController.class);
			startActivity(intent);
		});
        
        btnTestSupplyReduction = findViewById(R.id.startTestSupplyReduction);
        btnTestSupplyReduction.setOnClickListener((v) -> {
			btnSelected = "startTestSupplyReduction";
			Intent intent = new Intent(MenuTestController.this, TestController.class);
			startActivity(intent);
		});
        
        btnInfoSupplyReduction = findViewById(R.id.helpSupplyReduction);
        btnInfoSupplyReduction.setOnClickListener((v) -> {
			btnSelected = "helpSupplyReduction";
			Intent intent = new Intent(MenuTestController.this, InfoController.class);
			startActivity(intent);
		});
        
        btnTestGeneralVocabulary = findViewById(R.id.startTestGeneral);
        btnTestGeneralVocabulary.setOnClickListener((v) -> {
			btnSelected = "startTestGeneral";
			Intent intent = new Intent(MenuTestController.this, TestController.class);
			startActivity(intent);
		});
        
        btnInfoGeneralVocabulary = findViewById(R.id.helpGeneral);
        btnInfoGeneralVocabulary.setOnClickListener((v) -> {
			btnSelected = "helpGeneral";
			Intent intent = new Intent(MenuTestController.this, InfoController.class);
			startActivity(intent);
		});
        
        btnTestCorrectFormOfVerb = findViewById(R.id.startTestCorrectForm);
        btnTestCorrectFormOfVerb.setOnClickListener((v) -> {
			btnSelected = "startTestCorrectForm";
			Intent intent = new Intent(MenuTestController.this, TestController.class);
			startActivity(intent);
		});
        
        btnInfoCorrectFormOfVerb = findViewById(R.id.helpCorrectForm);
        btnInfoCorrectFormOfVerb.setOnClickListener((v) -> {
			btnSelected = "helpCorrectForm";
			Intent intent = new Intent(MenuTestController.this, InfoController.class);
			startActivity(intent);
		});

		btnTestSomeAnyNoEvery = findViewById(R.id.startTestSomeAnyNoEvery);
		btnTestSomeAnyNoEvery.setOnClickListener((v) -> {
			btnSelected = "startTestSomeAnyNoEvery";
			Intent intent = new Intent(MenuTestController.this, TestController.class);
			startActivity(intent);
		});

		btnInfoSomeAnyNoEvery = findViewById(R.id.helpSomeAnyNoEvery);
		btnInfoSomeAnyNoEvery.setOnClickListener((v) -> {
			btnSelected = "helpSomeAnyNoEvery";
			Intent intent = new Intent(MenuTestController.this, InfoController.class);
			startActivity(intent);
		});
	}

}
