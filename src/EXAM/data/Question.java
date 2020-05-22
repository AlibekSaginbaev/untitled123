package EXAM.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private Long id;
    private String question;
    private String rightAnswer;
    private String answ1, answ2, answ3, answ4;
    private boolean answeredRight;

    public Question() {
    }

    public Question(Long id, String question, String rightAnswer, String answ1, String answ2, String answ3, String answ4) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answ1 = answ1;
        this.answ2 = answ2;
        this.answ3 = answ3;
        this.answ4 = answ4;
        answeredRight=false;
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

    public String toString(){
        return question;
    }


}
