package my.app.entest.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import my.app.entest.entity.Info;
import my.app.entest.entity.Question;

public class Database {

    private static final String _ID = "_id";
    private static final String NAME = "question";
    private static final String TRUE = "trueAnswer";
    private static final String FALSE_A = "falseAnswerA";
    private static final String FALSE_B = "falseAnswerB";
    private static final String FALSE_C = "falseAnswerC";
    private static final String FALSE_D = "falseAnswerD";

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public Database(Context context, String databaseName){
        dbHelper = new DatabaseHelper(context, databaseName);
        try {
            dbHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
    }



    public List<Question> getAllQuestions(String tableName){
        List<Question> questions = new ArrayList<>();
        Cursor cursor = db./*query(tableName, new String[] {_ID, NAME, TRUE, FALSE_A, FALSE_B, FALSE_C, FALSE_D}, null, null, null,null, _ID); //.*/rawQuery("SELECT * FROM " + tableName, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Question question = new Question();
            question.setQuestion(cursor.getString(1));
            question.setTrueAnswer(cursor.getString(2));
            question.setFalseAnswerA(cursor.getString(3));
            question.setFalseAnswerB(cursor.getString(4));
            question.setFalseAnswerC(cursor.getString(5));
            question.setFalseAnswerD(cursor.getString(6));
            questions.add(question);
            cursor.moveToNext();
        }
        cursor.close();
        return questions;
    }

    public List<Info> getAllInfo(String tableName){
        List<Info> infos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Info info = new Info();
            info.setInfo(cursor.getString(1));
            infos.add(info);
            cursor.moveToNext();
        }
        cursor.close();
        return infos;
    }

}
