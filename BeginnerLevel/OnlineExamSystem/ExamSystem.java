package OnlineExamSystem;

import java.util.HashMap;
import java.util.Map;

public class ExamSystem {
    private final Map<String, Exam> exams = new HashMap<>();
    private final Map<String, Submission> submissions = new HashMap<>();

    public void createExam(String examId, String title){
        exams.put(examId, new Exam(examId, title));
        System.out.println(" Exam created: " + title);
    }

    public void addQuestion(String examId, Question q){
        Exam exam = exams.get(examId);
        if(exam == null){
            System.out.println(" Exam is not created yet");
            return;
        }
        exam.addQuestion(q);
    }

    public void startExam(String studentId, String examId){
        if(!exams.containsKey(examId)){
            System.out.println(" Exam not found");
            return;
        }

        String key = studentId + "_" + examId;
        if (submissions.containsKey(key)) {
            System.out.println("⚠️ You have already started this exam.");
            return;
        }

        submissions.put(key, new Submission(studentId, examId));
        System.out.println("🧑‍💻 Student " + studentId + " started exam: " + exams.get(examId).getTitle());
    }

    public void answer(String studentId, String examId, String questionId, int optionIndex) {
        String key = studentId + "_" + examId;
        Submission sub = submissions.get(key);
        if (sub == null) {
            System.out.println("You must start the exam first.");
            return;
        }
        sub.answerQuestion(questionId, optionIndex);
    }

    public void submitExam(String studentId, String examId) {
        String key = studentId + "_" + examId;
        Submission sub = submissions.get(key);
        Exam exam = exams.get(examId);
        if (sub == null || exam == null) {
            System.out.println("Invalid submission or exam.");
            return;
        }
        sub.submit(exam);
    }

    public void showResult(String studentId, String examId) {
        String key = studentId + "_" + examId;
        Submission sub = submissions.get(key);
        if (sub == null) {
            System.out.println("No submission found.");
            return;
        }
        System.out.println("📊 Result → " + studentId + " scored " + sub.getScore());
    }
}
