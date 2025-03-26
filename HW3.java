
/**
 * HW3
 *
 * This class provides five automated tests for the provided CRUD code.
 * Each test checks a specific functionality of the Questions and Answers classes.
 * 
 * To run:
 * 1. Ensure all the provided classes (Answer, Answers, Question, Questions, HW2) are in the same project.
 * 2. Place this HW3.java file in the same package/folder.
 * 3. Right-click HW3.java in Eclipse and select "Run As → Java Application".
 */
public class HW3 {

    /**
     * main method that runs all five tests and displays results.
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        int passed = 0;
        int total = 5;

        System.out.println("Running HW3 Automated Tests...\n");

        if (testAddValidQuestion()) {
            System.out.println("testAddValidQuestion PASSED");
            passed++;
        } else {
            System.out.println("testAddValidQuestion FAILED");
        }
        System.out.println();

        if (testAddDuplicateQuestion()) {
            System.out.println("testAddDuplicateQuestion PASSED");
            passed++;
        } else {
            System.out.println("testAddDuplicateQuestion FAILED");
        }
        System.out.println();

        if (testAddValidAnswer()) {
            System.out.println("testAddValidAnswer PASSED");
            passed++;
        } else {
            System.out.println("testAddValidAnswer FAILED");
        }
        System.out.println();

        if (testUpdateAnswer()) {
            System.out.println("testUpdateAnswer PASSED");
            passed++;
        } else {
            System.out.println("testUpdateAnswer FAILED");
        }
        System.out.println();

        if (testRemoveAnswer()) {
            System.out.println("testRemoveAnswer PASSED");
            passed++;
        } else {
            System.out.println("testRemoveAnswer FAILED");
        }
        System.out.println();

        System.out.println("Total Tests Passed: " + passed + " / " + total);
    }

    /**
     * testAddValidQuestion
     * 
     * Verifies that adding a valid Question (with non-empty text) succeeds.
     * @return true if the test passes, false otherwise.
     */
    public static boolean testAddValidQuestion() {
        Questions questions = new Questions();
        Question q = new Question("What is Java?", "Programming");
        boolean result = questions.addQuestion(q);

        
        if (!result) {
            return false;
        }
        
        if (questions.getAllQuestions().size() != 1) {
            return false;
        }
        
        Question stored = questions.getAllQuestions().get(0);
        if (!stored.getText().equals("What is Java?")) {
            return false;
        }
        return true;
    }

    /**
     * testAddDuplicateQuestion
     * 
     * Verifies that adding a duplicate question (same text) fails.
     * @return true if the test passes, false otherwise.
     */
    public static boolean testAddDuplicateQuestion() {
        Questions questions = new Questions();

        
        Question q1 = new Question("What is Java?", "Programming");
        boolean firstAdd = questions.addQuestion(q1);
        if (!firstAdd) {
            return false; 
        }

        
        Question q2 = new Question("What is Java?", "Programming");
        boolean secondAdd = questions.addQuestion(q2);
        if (secondAdd) {
            return false; 
        }

       
        if (questions.getAllQuestions().size() != 1) {
            return false;
        }
        return true;
    }

    /**
     * testAddValidAnswer
     * 
     * Verifies that adding a valid Answer (non-empty text, valid questionId) succeeds.
     * @return true if the test passes, false otherwise.
     */
    public static boolean testAddValidAnswer() {
        
        Questions questions = new Questions();
        Question q = new Question("Explain polymorphism.", "OOP");
        questions.addQuestion(q);

       
        Answers answers = new Answers();
        Answer a = new Answer(q.getId(), "Polymorphism is the ability of an object to take on many forms.");
        boolean result = answers.addAnswer(a);

       
        if (!result) {
            return false;
        }
       
        if (answers.getAllAnswers().size() != 1) {
            return false;
        }
      
        Answer stored = answers.getAllAnswers().get(0);
        if (!stored.getText().contains("Polymorphism")) {
            return false;
        }
        return true;
    }

    /**
     * testUpdateAnswer
     * 
     * Verifies that updating an existing answer's text is successful
     * when given a non-empty string.
     * @return true if the test passes, false otherwise.
     */
    public static boolean testUpdateAnswer() {
       
        Questions questions = new Questions();
        Question q = new Question("Explain inheritance.", "OOP");
        questions.addQuestion(q);

        
        Answers answers = new Answers();
        Answer a = new Answer(q.getId(), "Inheritance allows classes to derive from others.");
        answers.addAnswer(a);

        
        boolean updateResult = answers.updateAnswer(a.getId(), "Inheritance enables code reuse among classes.");
        if (!updateResult) {
            return false; 
        }

        
        Answer updated = answers.getAllAnswers().get(0);
        if (!updated.getText().equals("Inheritance enables code reuse among classes.")) {
            return false;
        }
        return true;
    }

    /**
     * testRemoveAnswer
     * 
     * Verifies that removing an existing answer by ID succeeds.
     * @return true if the test passes, false otherwise.
     */
    public static boolean testRemoveAnswer() {
        
        Questions questions = new Questions();
        Question q = new Question("What is encapsulation?", "OOP");
        questions.addQuestion(q);

       
        Answers answers = new Answers();
        Answer a = new Answer(q.getId(), "Encapsulation is about bundling data and methods.");
        answers.addAnswer(a);

        
        boolean removeResult = answers.removeAnswer(a.getId());
        if (!removeResult) {
            return false; 
        }

        
        if (answers.getAllAnswers().size() != 0) {
            return false;
        }
        return true;
    }
}
