package my.app.entest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import my.app.entest.database.Database;
import my.app.entest.R;
import my.app.entest.database.DatabaseHelper;
import my.app.entest.database.Names;
import my.app.entest.entity.Question;

public class TestController extends Activity {

	private List<Question> questions;

	private Database db;

	private Button btnFalseButtonA;
	private Button btnFalseButtonB;
	private Button btnFalseButtonC;
	private Button btnFalseButtonD;
	private Button btnExitButton;
	private TextView textQuestion;
	private TextView numberQuestion;

	private Random random;
	private int position = 0;
	private int rightAnswer = 0;
	private int allAnswer = 1;
	private int iTrueAnswer;
	private int numberOfQuestion = 1;
	private boolean isTrue = true;

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		db = new Database(this, Names.DB_TEST_ENGLISH);

		questions = getQuestionList();

		random = new Random();
		iTrueAnswer = random.nextInt(3);

		numberQuestion = findViewById(R.id.numberQuestion);
		textQuestion = findViewById(R.id.textQuestion);
		textQuestion.setText(questions.get(position).getQuestion());
		numberQuestion.setText(numberOfQuestion + " з 12");
		numberOfQuestion++;

		btnFalseButtonA = findViewById(R.id.falseButtonA);
		setRandomAnswers(btnFalseButtonA, 0, questions.get(position).getFalseAnswerA());
		btnFalseButtonA.setOnClickListener((v) -> {
			check(0);
		});

		btnFalseButtonB = findViewById(R.id.falseButtonB);
		setRandomAnswers(btnFalseButtonB, 1, questions.get(position).getFalseAnswerB());
		btnFalseButtonB.setOnClickListener((v) -> {
			check(1);
		});

		btnFalseButtonC = findViewById(R.id.falseButtonC);
		setRandomAnswers(btnFalseButtonC, 2, questions.get(position).getFalseAnswerC());
		btnFalseButtonC.setOnClickListener((v) -> {
			check(2);
		});

		btnFalseButtonD = findViewById(R.id.falseButtonD);
		setRandomAnswers(btnFalseButtonD, 3, questions.get(position).getFalseAnswerD());
		btnFalseButtonD.setOnClickListener((v) -> {
			check(3);
		});

		btnExitButton = findViewById(R.id.exitButton);
		btnExitButton.setOnClickListener((v) -> {
			showExitDialog();
		});
	}

	private void showExitDialog() {
		AlertDialog.Builder exitDialog = new AlertDialog.Builder(TestController.this);
		exitDialog.setTitle("Вийти?");
		exitDialog.setMessage("Всі результати буде втрачено");
		exitDialog.setCancelable(true);
		exitDialog.setNegativeButton("Так", (dialog, which) -> {
			dialog.cancel();
			endQuestions();
			finish();
		});
		exitDialog.setPositiveButton("Ні", (dialog, which) -> {
			dialog.cancel();
		});
		exitDialog.show();
	}

	private void showEndDialog() {
		AlertDialog.Builder endDialog = new AlertDialog.Builder(TestController.this);
		endDialog.setTitle("Результат");
		endDialog.setMessage("правильних відповідей " + rightAnswer + " з " + allAnswer);
		endDialog.setCancelable(true);
		endDialog.setPositiveButton("Повернутись", (dialog, which) -> {
			dialog.cancel();
			endQuestions();
			finish();
		});
		endDialog.show();
	}

	public void showAnswerToast(String answer) {
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.activity_toast, findViewById(R.id.toast));
		ImageView image = layout.findViewById(R.id.image);
		TextView text = layout.findViewById(R.id.text_toast);
		if(answer.compareTo("true") == 0) {
			image.setImageResource(R.drawable.image_true);
			text.setText(R.string.right);
			text.setTextColor(Color.rgb(154,205,50));
		} else {
			image.setImageResource(R.drawable.image_false);
			text.setText(R.string.wrong);
			text.setTextColor(Color.rgb(255,99,71));
		}
		final Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
		Handler handler = new Handler();
		handler.postDelayed(() -> {
			toast.cancel();
		}, 1000);
	}

	public void updateQuestions() {
		position++;
		allAnswer++;
		textQuestion.setText(questions.get(position).getQuestion());
		setRandomAnswers(btnFalseButtonA, 0, questions.get(position).getFalseAnswerA());
		setRandomAnswers(btnFalseButtonB, 1, questions.get(position).getFalseAnswerB());
		setRandomAnswers(btnFalseButtonC, 2, questions.get(position).getFalseAnswerC());
		setRandomAnswers(btnFalseButtonD, 3, questions.get(position).getFalseAnswerD());
	}

	public void endQuestions() {
//		allAnswer = 1;
//		rightAnswer = 0;
//		position = 0;
		questions.clear();
		questions = null;
	}

	public void clickTrue() {
		if(allAnswer == 12) {
			//что бы не защитать правильный ответ после ошибки
			if(isTrue == false) {
				isTrue = true;
			} else {
				rightAnswer++;
			}
			showAnswerToast("true");
			Handler handler = new Handler();
			handler.postDelayed(() -> {
				showEndDialog();
			}, 1500);
		} else {
			if(isTrue == false) {
				isTrue = true;
			} else {
				rightAnswer++;
			}
			showAnswerToast("true");
			Handler handler = new Handler();
			handler.postDelayed(() -> {
				updateQuestions();
				numberQuestion.setText(allAnswer + " з " + 12);
			}, 1500);
		}
	}

	@Override
	public void onBackPressed() {
		showExitDialog();
	}

	private void check(int num) {
		if (iTrueAnswer == num) {
			clickTrue();
			iTrueAnswer = random.nextInt(3);
		} else {
			showAnswerToast("false");
			isTrue = false;
		}
	}

	private void setRandomAnswers(Button btn, int num, String text){
		if(iTrueAnswer == num) {
			btn.setText(questions.get(position).getTrueAnswer());
		} else {
			btn.setText(text);
		}
	}

	private List<Question> getQuestionList(){
		switch (MenuTestController.btnSelected) {
			case "startTestArticles":
				return db.getAllQuestions(Names.TABLE_ARTICLES);
			case "startTestPrepositions":
				return db.getAllQuestions(Names.TABLE_PREPOSITIONS_AND_PARTICLES);
			case "startTestSupplyReduction":
				return db.getAllQuestions(Names.TABLE_SUPPLY_REDUCTION);
			case "startTestGeneral":
				return db.getAllQuestions(Names.TABLE_GENERAL_VOCABULARY);
			case "startTestCorrectFormb":
				return db.getAllQuestions(Names.TABLE_CORRECT_FORM_OF_VERB);
			case "startTestSomeAnyNoEvery":
				return db.getAllQuestions(Names.TABLE_SOME_ANY_NO_EVERY);

				default: return null;
		}
	}

}

