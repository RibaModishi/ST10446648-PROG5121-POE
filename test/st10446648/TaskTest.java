import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testCheckUserName() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        assertTrue(task.checkUserName("user_"), "Username should be valid");
        assertFalse(task.checkUserName("username"), "Username should be invalid without underscore");
        assertFalse(task.checkUserName("user_name_too_long"), "Username should be invalid if longer than 5 characters");
    }

    @Test
    public void testCheckPasswordComplexity() {
        Task task = new Task(); // Initialize Task object with size 5 for testing
        assertTrue(task.checkPasswordComplexity("Password1@"), "Password should be valid");
        assertFalse(task.checkPasswordComplexity("password"), "Password should be invalid without uppercase, number, and special character");
        assertFalse(task.checkPasswordComplexity("Password"), "Password should be invalid without number and special character");
        assertFalse(task.checkPasswordComplexity("Password1"), "Password should be invalid without special character");
    }

    @Test
    public void testLoginUser() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        task.setUsername_Reg("user_");
        task.setPassword_Reg("Password1@");
        task.setUsername_Login("user_");
        task.setPassword_Login("Password1@");
        assertTrue(task.loginUser(), "Login should be successful with correct credentials");

        task.setPassword_Login("WrongPassword");
        assertFalse(task.loginUser(), "Login should fail with incorrect password");

        task.setUsername_Login("wrong_user");
        assertFalse(task.loginUser(), "Login should fail with incorrect username");
    }

    @Test
    public void testReturnLoginStatus() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        task.setUsername_Reg("user_");
        task.setPassword_Reg("Password1@");
        task.setUsername_Login("user_");
        task.setPassword_Login("Password1@");
        assertTrue(task.returnLoginStatus(), "Login status should be true with correct credentials");

        task.setPassword_Login("WrongPassword");
        assertFalse(task.returnLoginStatus(), "Login status should be false with incorrect password");

        task.setUsername_Login("wrong_user");
        assertFalse(task.returnLoginStatus(), "Login status should be false with incorrect username");
    }

    @Test
    public void testCheckTaskDescription() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        assertTrue(task.checkTaskDescription("This is a valid task description"), "Description should be valid");
        assertFalse(task.checkTaskDescription(""), "Description should be invalid if empty");
        assertFalse(task.checkTaskDescription("This description is way too long and exceeds the fifty character limit imposed by the method"), "Description should be invalid if longer than 50 characters");
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        String[] taskNames = {"Task1", "Task2"};
        String[] developerNames = {"DevOne", "DevTwo"};
        task.setTask_Name(taskNames);
        task.setDeveloper_Name(developerNames);
        task.setCount_(0);
        assertEquals("TA:0:ONE", task.createTaskID(), "Task ID should be correctly formatted");

        task.setCount_(1);
        assertEquals("TA:1:TWO", task.createTaskID(), "Task ID should be correctly formatted");
    }

    @Test
    public void testPrintTaskDetails() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        String[] taskNames = {"Task1"};
        String[] developerNames = {"DevOne"};
        String[] taskDescs = {"Description"};
        String[] taskDurations = {"5"};
        int[] statuses = {1};

        task.setTask_Name(taskNames);
        task.setDeveloper_Name(developerNames);
        task.setTask_Desc(taskDescs);
        task.setTask_Duration(taskDurations);
        task.setStatus_(statuses);
        task.setCount_(0);

        String expectedDetails = "Status: Done\nDeveloper: DevOne\nTask Number: 0\nTask Name: Task1\nDescription: Description\nTask ID: TA:0:ONE\nDuration: 5 hours";
        assertEquals(expectedDetails, task.printTaskDetails(), "Task details should be correctly formatted");
    }

    @Test
    public void testReturnTotalHours() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        task.setTotal_(10);
        assertEquals(10, task.returnTotalHours(), "Total hours should be correctly returned");
    }

    @Test
    public void testVerifyChoice() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        task.setChoice("1");
        assertEquals("1", task.verifyChoice(), "Choice should be valid");

        task.setChoice("8");
        assertNotEquals("8", task.verifyChoice(), "Choice should be invalid");
    }

    @Test
    public void testVerifyTaskName() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        String[] taskNames = {null, "T"};
        task.setTask_Name(taskNames);
        task.setCount_(0);
        assertNull(task.verifyTaskName(), "Task name should be invalid if null");

        task.setCount_(1);
        assertNull(task.verifyTaskName(), "Task name should be invalid if less than 2 characters");
    }

    @Test
    public void testVerifyDeveloperName() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        String[] developerNames = {null, "De"};
        task.setDeveloper_Name(developerNames);
        task.setCount_(0);
        assertNull(task.verifyDeveloperName(), "Developer name should be invalid if null");

        task.setCount_(1);
        assertNull(task.verifyDeveloperName(), "Developer name should be invalid if less than 3 characters");
    }

    @Test
    public void testVerifyTaskDuration() {
        Task task = new Task(5); // Initialize Task object with size 5 for testing
        String[] taskDurations = {"5", "abc"};
        task.setTask_Duration(taskDurations);
        task.setCount_(0);
        assertEquals("5", task.verifyTaskDuration(), "Task duration should be valid if numeric");

        task.setCount_(1);
        assertNull(task.verifyTaskDuration(), "Task duration should be invalid if not numeric");
    }
}
