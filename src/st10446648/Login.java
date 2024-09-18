/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package st10446648;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

/**
 *
 * @author Ore
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static String userName;
    public static String passWord;
    
    public static void main(String[] args) {
      
        JDialog window = new JDialog();
        
        // PART 1:
        
        // 1. Create an account by entering username, password, first name and last name
        
        Scanner input = new Scanner(System.in); // creating the scanner which is called "input"
        // Declaring variables
        String registerUser; // Declaring our variables and we are using strings because we are going to be using characters
        String registerPassword; // Declaring our variables and we are using strings because we are going to be using characters
        String firstName; // Declaration of first name
        String lastName; // Declaration of last name
        
        // output on console:
        System.out.print("Enter your first name: "); // prompt the user to enter their first name
        firstName = input.nextLine(); // reads the next line of the user
        Task taskObj = new Task(0); // Initialize Task object with size 0 initially
        taskObj.setName_(firstName); // Storing the first name in the setName for tasks in part 2
        
        System.out.print("Enter your last name: "); // prompt the user to enter their last name
        lastName = input.nextLine(); // reads the next line of the user in the scanner class
        taskObj.setSurname_(lastName); // Storing the last name in the setSurname for tasks in part 2
        
        System.out.print("Enter your username: "); // prompt the user to enter their username
        registerUser = input.nextLine();
        taskObj.setUsername_Reg(registerUser); // Storing the register username in the setUsername_Reg for tasks in part 2
        
        taskObj.registerUser(); // calling to validate username
        
        System.out.print("Enter your password: "); // prompt the user to enter their password
        registerPassword = input.nextLine(); 
        taskObj.setPassword_Reg(registerPassword);
        
        taskObj.registerUser();
        
        // 2. Now this is for the login
       
        boolean loginUser = false;

        while (!loginUser) {
            System.out.println("Log in to your registered account:");
            
            System.out.print("Enter username: "); // prompt user to enter their username
            userName = input.nextLine();
            taskObj.setUsername_Login(userName);
       
            System.out.print("Enter password: "); // prompt user to enter their password
            passWord = input.nextLine();
            taskObj.setPassword_Login(passWord);
       
            loginUser = taskObj.returnLoginStatus(); // Set loginUser to the returned value
        }
        // End of PART 1
        // PART 2 and 3
        
        window.setAlwaysOnTop(true);
        
        // Declarations
        // has to be declared and initialized here else if statements wont have access to them.
        String choice;
        String[] taskName = null;
        String[] taskDesc = null;
        String[] developerName = null;
        String[] taskDur = null;
        int[] status = null;
        String[] taskID = null;
        int size = 0;
        int total = 0;

        // Initial choice input
        choice = JOptionPane.showInputDialog(null,
                "Please select an action to proceed with:\n" +
                        "1. Add tasks\n" +
                        "2. Show report\n" +
                        "3. View all completed tasks\n" +
                        "4. Display task with the longest duration\n" +
                        "5. Search for task\n" +
                        "6. Search tasks by developer\n" +
                        "7. Delete a task\n\n" +
                        "0. Quit",
                "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);

        taskObj.setChoice(choice); // Setting choice in Task object
        choice = taskObj.verifyChoice(); // Verify choice

        while (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
                || choice.equals("5") || choice.equals("6") || choice.equals("7")) {

            if (choice.equals("1")) {
                size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of tasks you want to create: ",
                        null, JOptionPane.PLAIN_MESSAGE));
                taskObj = new Task(size); // Reinitialize Task object with the specified size
                taskObj.setSize_(size);

                // Initialize arrays after size is known
                taskName = new String[size];
                taskDesc = new String[size];
                developerName = new String[size];
                taskDur = new String[size];
                status = new int[size];
                taskID = new String[size];

                for (int count = 0; count < size; count++) {
                    taskObj.setCount_(count);

                    taskName[count] = JOptionPane.showInputDialog(null, "Enter a name for Task " + count,
                            "Task Name", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setTask_Name(taskName);
                    taskName[count] = taskObj.verifyTaskName();

                    taskDesc[count] = JOptionPane.showInputDialog(null, "Enter a description for Task " + count,
                            "Task Description", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setTask_Desc(taskDesc);
                    while (!taskObj.checkTaskDescription(taskDesc[count])) {
                        taskDesc[count] = JOptionPane.showInputDialog(null, "Please enter a task description of 50 characters or less",
                                "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
                        taskObj.setTask_Desc(taskDesc);
                    }
                    if (taskObj.checkTaskDescription(taskDesc[count])) {
                        JOptionPane.showMessageDialog(null, "Task successfully captured.");
                    }

                    developerName[count] = JOptionPane.showInputDialog(null, "Enter the developer's name for Task " + count,
                            "Developer Name", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setDeveloper_Name(developerName);
                    developerName[count] = taskObj.verifyDeveloperName();

                    taskDur[count] = JOptionPane.showInputDialog(null, "Enter the duration in hours for Task " + count,
                            "Task Duration", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setTask_Duration(taskDur);
                    taskDur[count] = taskObj.verifyTaskDuration();

                    total += Integer.parseInt(taskDur[count]);
                    taskObj.setTotal_(total);

                    status[count] = JOptionPane.showOptionDialog(null, "Please specify the status of Task " + count,
                            "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, taskObj.getOptions(), null);
                    taskObj.setStatus_(status);

                    JOptionPane.showMessageDialog(null, taskObj.printTaskDetails(), "Task Details", JOptionPane.PLAIN_MESSAGE);

                    taskID[count] = taskObj.createTaskID();
                }
            }

            if (choice.equals("2")) {
                if (size == 0) {
                    JOptionPane.showMessageDialog(null, "Please add tasks to view a report", "No tasks to display", JOptionPane.PLAIN_MESSAGE);
                } else {
                    StringBuilder report = new StringBuilder();

                    for (int i = 0; i < size; i++) {
                        if (taskName[i] != null) { // Check if taskName is not null
                            report.append("Task Name: ").append(taskName[i])
                                  .append("\nDeveloper: ").append(developerName[i])
                                  .append("\nDuration: ").append(taskDur[i] + " hours")
                                  .append("\nTask ID: ").append(taskID[i])
                                  .append("\nStatus: ").append(taskObj.getOptions()[status[i]]).append("\n\n");
                        }
                    }

                    JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.PLAIN_MESSAGE);
                }
            }


            if (choice.equals("3")) {
                StringBuilder completedTasks = new StringBuilder();
                int found = 0;

                if (status != null && developerName != null && taskName != null && taskDur != null) {
                    for (int i = 0; i < size; i++) {
                        if (status[i] == 1) {
                            completedTasks.append("Task Name: ").append(taskName[i])
                                    .append("\nDeveloper: ").append(developerName[i])
                                    .append("\nTask duration: ").append(taskDur[i]).append(" hours\n\n");
                            found++;
                        }
                    }
                }

                if (found > 0) {
                    JOptionPane.showMessageDialog(null, completedTasks.toString(), "Completed tasks", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No tasks have been completed yet.", "Completed Tasks", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (choice.equals("4")) {
                if (size == 0) {
                    JOptionPane.showMessageDialog(null, "Please add tasks to proceed with this action.",
                            "No task to display", JOptionPane.PLAIN_MESSAGE);
                } else {
                    int longestDur = 0;
                    String longestDurDeveloper = null;

                    for (int i = 0; i < size; i++) {
                        if (Integer.parseInt(taskDur[i]) > longestDur) {
                            longestDur = Integer.parseInt(taskDur[i]);
                            longestDurDeveloper = developerName[i];
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Developer: " + longestDurDeveloper
                            + "\nDuration: " + longestDur + " hours", "Task with longest duration", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (choice.equals("5")) {
                String search = "";
                boolean matchFound = false;

                search = JOptionPane.showInputDialog(null, "Enter a task name", "Search by name", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < size; i++) {
                    if (taskName[i] != null && search.equalsIgnoreCase(taskName[i])) {
                        JOptionPane.showMessageDialog(null, "Task Name: " + taskName[i]
                                + "\nDeveloper: " + developerName[i]
                                + "\nStatus: " + taskObj.getOptions()[status[i]], "Task found", JOptionPane.PLAIN_MESSAGE);
                        matchFound = true;
                    }
                }

                if (!matchFound) {
                    JOptionPane.showMessageDialog(null, "Sorry, that task does not exist.", "No match found", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (choice.equals("6")) {
                String search = "";
                boolean matchFound = false;
                StringBuilder searchFound = new StringBuilder();

                search = JOptionPane.showInputDialog(null, "Enter developer's name", "Search by developer", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < size; i++) {
                    if (developerName[i] != null && search.equalsIgnoreCase(developerName[i])) {
                        searchFound.append("Name: ").append(taskName[i])
                                .append("\nStatus: ").append(taskObj.getOptions()[status[i]]).append("\n\n");
                        matchFound = true;
                    }
                }

                if (matchFound) {
                    JOptionPane.showMessageDialog(null, searchFound.toString(), "Tasks assigned to " + search, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "That developer is not assigned to any tasks.", "No match found", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (choice.equals("7")) {
                String delete = "";
                boolean taskDeleted = false;
                int confirm;

                delete = JOptionPane.showInputDialog(null, "Enter a task name. \n*All tasks with this name will be deleted",
                        "Delete tasks", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < size; i++) {
                    if (taskName[i] != null && delete.equalsIgnoreCase(taskName[i])) {
                        confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to delete tasks of the name " + delete + " ?",
                                "Confirm task deletion", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE,
                                null, taskObj.getOptions(), null);

                        if (confirm == 0) {
                            total -= Integer.parseInt(taskDur[i]);
                            taskObj.setTotal_(total);
                            taskName[i] = null;
                            developerName[i] = null;
                            taskDesc[i] = null;
                            taskDur[i] = null;
                            status[i] = -1;
                            taskID[i] = null;
                            taskDeleted = true;
                        }
                    }
                }

                if (taskDeleted) {
                    JOptionPane.showMessageDialog(null, "The task was successfully deleted", "Task deleted", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No tasks were found", "Task not found", JOptionPane.PLAIN_MESSAGE);
                }
            }

            // Reprompt for choice
            choice = JOptionPane.showInputDialog(null,
                    "Please select an action to proceed with:\n" +
                            "1. Add tasks\n" +
                            "2. Show report\n" +
                            "3. View all completed tasks\n" +
                            "4. Display task with the longest duration\n" +
                            "5. Search for task\n" +
                            "6. Search tasks by developer\n" +
                            "7. Delete a task\n\n" +
                            "0. Quit",
                    "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);

            taskObj.setChoice(choice); // Setting choice in Task object
            choice = taskObj.verifyChoice(); // Verify choice
        }

        // Outside the loop, handle choice "0"
        if (choice.equals("0")) {
            JOptionPane.showMessageDialog(null, "Your tasks will take a total of " + taskObj.returnTotalHours() + " hours.", "Total duration", JOptionPane.PLAIN_MESSAGE);
        }

        input.close(); // Close the scanner to avoid resource leaks
    }
}
