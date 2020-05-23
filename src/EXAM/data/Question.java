package EXAM.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private Long id;
    private String question;
    private String rightAnswer;
    private ArrayList<String> answers;
    private boolean answeredRight;
    private String answ1,answ2,answ3,answ4;
    private int subjectid;

    public Question() {
    }

    public Question(Long id, String question, String rightAnswer, ArrayList<String> answers) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers = answers;
        answeredRight=false;
    }

    public Question(Long id, String question, String rightAnswer, ArrayList<String> answers, int subjectid) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers = answers;
        this.subjectid = subjectid;
        answeredRight=false;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public boolean isAnsweredRight(){
        return answeredRight;
    }

    public void setAnsweredRight(boolean answeredRight) {
        System.out.println("answered: "+answeredRight);
        this.answeredRight = answeredRight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String toString(){
        return question;
    }


    public String getAnsw1() {
        return answ1;
    }

    public void setAnsw1(String answ1) {
        this.answ1 = answ1;
    }

    public String getAnsw2() {
        return answ2;
    }

    public void setAnsw2(String answ2) {
        this.answ2 = answ2;
    }

    public String getAnsw3() {
        return answ3;
    }

    public void setAnsw3(String answ3) {
        this.answ3 = answ3;
    }

    public String getAnsw4() {
        return answ4;
    }

    public void setAnsw4(String answ4) {
        this.answ4 = answ4;
    }
}
