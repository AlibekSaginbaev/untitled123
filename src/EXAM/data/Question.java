package EXAM.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private Long id;
    private String question;
    private String rightAnswer;
    private ArrayList<String> answers;
    private boolean answeredRight;

    public Question(Long id, String question, String rightAnswer, ArrayList<String> answers) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers = answers;
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

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }


}
