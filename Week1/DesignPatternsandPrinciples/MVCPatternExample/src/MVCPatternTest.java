public class MVCPatternTest {
    public static void main(String[] args) {
        // Create the model
        Student model = new Student("Aviral Mathur", 123, "A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(model, view);

        // Update the view
        controller.updateView();

        // Change student details
        controller.setStudentName("Anusha Agarwal");
        controller.setStudentGrade("O");

        // Update the view again
        controller.updateView();
    }
}
