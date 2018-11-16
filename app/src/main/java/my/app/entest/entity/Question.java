package my.app.entest.entity;

public class Question {

    private long _id;
    private String question;
    private String trueAnswer;
    private String falseAnswerA;
    private String falseAnswerB;
    private String falseAnswerC;
    private String falseAnswerD;

    public Question() {}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getFalseAnswerA() {
        return falseAnswerA;
    }

    public void setFalseAnswerA(String falseAnswerA) {
        this.falseAnswerA = falseAnswerA;
    }

    public String getFalseAnswerB() {
        return falseAnswerB;
    }

    public void setFalseAnswerB(String falseAnswerB) {
        this.falseAnswerB = falseAnswerB;
    }

    public String getFalseAnswerC() {
        return falseAnswerC;
    }

    public void setFalseAnswerC(String falseAnswerC) {
        this.falseAnswerC = falseAnswerC;
    }

    public String getFalseAnswerD() {
        return falseAnswerD;
    }

    public void setFalseAnswerD(String falseAnswerD) {
        this.falseAnswerD = falseAnswerD;
    }

}