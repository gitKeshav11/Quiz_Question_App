import java.util.*;

class Question {
    String questionText;
    String[] options;
    char correctOption;

    // Constructor
    Question(String questionText, String[] options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Display question and options
    void displayQuestion() {
        System.out.println("\n" + questionText);
        char optionChar = 'A';
        for (String option : options) {
            System.out.println(optionChar + ". " + option);
            optionChar++;
        }
    }

    // Check if the answer is correct
    boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(correctOption);
    }
}

public class Quiz_App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?",
                new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 'A'));
        questions.add(new Question("Which language is used for Android development?",
                new String[]{"Swift", "Kotlin", "Python", "C#"}, 'B'));
        questions.add(new Question("What is 2 + 2?",
                new String[]{"3", "4", "5", "6"}, 'B'));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 'B'));
        questions.add(new Question("Who is the author of 'Wings of Fire'?",
                new String[]{"Chetan Bhagat", "Dr. A.P.J. Abdul Kalam", "R.K. Narayan", "Arundhati Roy"}, 'B'));

        int score = 0;

        System.out.println("Welcome to the Quiz App!");
        System.out.println("Type the option letter (A, B, C, D) and press Enter.");

        // Ask questions
        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer: ");
            char userAnswer = scanner.next().charAt(0);

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + q.correctOption);
            }
        }

        // Calculate percentage
        int totalQuestions = questions.size();
        double percentage = (score * 100.0) / totalQuestions;

        // Final result
        System.out.println("\n==========================");
        System.out.println(" Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + totalQuestions);
        System.out.printf(" Percentage: %.2f%%\n", percentage);

        // Feedback
        if (percentage == 100) {
            System.out.println(" Excellent! Full marks!");
        } else if (percentage >= 80) {
            System.out.println(" Great job!");
        } else if (percentage >= 50) {
            System.out.println(" Good effort. Keep practicing.");
        } else {
            System.out.println("Try again and improve.");
        }

        System.out.println("==========================");
        scanner.close();
    }
}
