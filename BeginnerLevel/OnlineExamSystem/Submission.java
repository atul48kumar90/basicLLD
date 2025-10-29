package OnlineExamSystem;

import java.util.HashMap;
import java.util.Map;

public class Submission {
    private final String studentId;
    private final String examId;
    private final Map<String, Integer> answerKey = new HashMap<>();
    private boolean isSubmitted = false;
    private int score = 0;

    public Submission(String studentId, String examId){
        this.studentId = studentId;
        this.examId = examId;
    }

    public void answerQuestion(String questionid, int chosenOption){
        if(isSubmitted){
            System.out.println(" already submitted");
            return;
        }
        answerKey.put(questionid, chosenOption);
    }

    public void submit(Exam exam){
        if(isSubmitted){
            System.out.println(" exam already submitted");
            return;
        }
        int correct = 0;
        for(Question q : exam.getQuestions()){
            Integer chosen = answerKey.get(q.getId());
            if(chosen != null && q.isCorrect(chosen)){
                correct++;
            }
        }

        this.score = correct;
        this.isSubmitted = true;
        System.out.println(" score is : " + score);
    }

    public int getScore(){ return score;}
    public boolean isSubmitted() { return isSubmitted;}
}
