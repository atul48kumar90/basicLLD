package OnlineExamSystem;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private final String examId;
    private final String title;
    private final List<Question> question = new ArrayList<>();

    public Exam(String exampid, String title){
        this.examId = exampid;
        this.title = title;
    }

    public String getExamId(){ return examId;}
    
    public String getTitle(){return title;}

    public List<Question> getQuestions(){return question;}

    public void addQuestion(Question q){ question.add(q);}
}
