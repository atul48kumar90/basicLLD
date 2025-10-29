package OnlineExamSystem;

import java.util.List;

public class Question {
    private final String id;
    private final String text;
    private final List<String> options;
    private final int correctOption;

    public Question(String id, String text, List<String> option, int correctOption){
        this.id = id;
        this.text = text;
        this.options = option;
        this.correctOption = correctOption;
    }

    public String getId(){
        return id;
    }

    public boolean isCorrect(int selectedOption){
        return correctOption == selectedOption;
    }

    public void display(){
        System.out.println(text);
        for(int i=0; i<options.size(); i++)
        {
            System.out.println((i+1) + ". " + options.get(i));
        }
    }
}
