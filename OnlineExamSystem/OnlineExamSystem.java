package OnlineExamSystem;

import java.util.List;

public class OnlineExamSystem {
    public static void main(String[] args) {
        ExamSystem system = new ExamSystem();

        // Create exam
        system.createExam("E1", "Java Basics");

        // Add questions
        system.addQuestion("E1", new Question("Q1", "What is JVM?",
                List.of("Java Virtual Machine", "Just Very Mad", "Java Visual Model"), 0));
        system.addQuestion("E1", new Question("Q2", "Which keyword creates an object?",
                List.of("class", "new", "create"), 1));

        // Student starts exam
        system.startExam("S1", "E1");
        system.answer("S1", "E1", "Q1", 0);
        system.answer("S1", "E1", "Q2", 1);

        // Submit and view result
        system.submitExam("S1", "E1");
        system.showResult("S1", "E1");

        // Trying to change answer after submission
        system.answer("S1", "E1", "Q2", 2);
    }
}
