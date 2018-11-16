package my.app.entest.controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import my.app.entest.R;
import my.app.entest.database.Database;
import my.app.entest.database.Names;
import my.app.entest.entity.Info;

public class InfoController extends Activity {
	
	private TextView textInfo;

	private Database db;

	private List<Info> infos;
	
	protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        db = new Database(this, Names.DB_INFO);
        infos = getInfoList();

        textInfo = findViewById(R.id.referenceText);
        textInfo.setText(infos.get(0).getInfo());
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}

	private List<Info> getInfoList(){
		switch (MenuTestController.btnSelected) {
			case "helpArticles":
				return db.getAllInfo(Names.TABLE_ARTICLES);
			case "helpPrepositions":
				return db.getAllInfo(Names.TABLE_PREPOSITIONS_AND_PARTICLES);
			case "helpSupplyReduction":
				return db.getAllInfo(Names.TABLE_SUPPLY_REDUCTION);
			case "helpGeneral":
				return db.getAllInfo(Names.TABLE_GENERAL_VOCABULARY);
			case "helpCorrectForm":
				return db.getAllInfo(Names.TABLE_CORRECT_FORM_OF_VERB);
			case "helpSomeAnyNoEvery":
				return db.getAllInfo(Names.TABLE_SOME_ANY_NO_EVERY);

			default: return null;
		}
	}

}
