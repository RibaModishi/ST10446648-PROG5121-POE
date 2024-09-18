/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10446648;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Ore
 */
public class Task {
    
    private String Name_;
    private String Surname_;
    private String Username_Reg;
    private String Password_Reg;
    private String Username_Login;
    private String Password_Login;
    boolean flag;
    boolean flag1;
    boolean flag2;
    String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
    private final Pattern pattern = Pattern.compile(regex);
    
    Scanner sc = new Scanner (System.in);
    
    public String getName_(){
        return Name_;
    }
    
    public void setName_(String Name_){
        this.Name_ = Name_;
    }
    
    public String getSurname_() {
        return Surname_;
    }
    
    public void setSurname_(String Surname_){
        this.Surname_ = Surname_;
    }
    
    public String getUsername_Reg(){
        return Username_Reg;
    }
    
    public void setUsername_Reg(String Username_Reg) {
        this.Username_Reg = Username_Reg;
    }
    
    public String getPassword_Reg() {
        return Password_Reg;
    }
    
    public void setPassword_Reg(String Password_Reg) {
        this.Password_Reg = Password_Reg;
    }
    
    public String getUsername_Login(){
        return Username_Login;
    }
    
    public void setUsername_Login(String Username_Login){
        this.Username_Login = Username_Login;
    }
    
    public String getPassword_Login() {
        return Password_Login;
    }
    
    public void setPassword_Login(String Password_Login){
        this.Password_Login = Password_Login;
    }
    
    //method 1
    public boolean checkUserName(String Username_Reg){
        
        flag = (Username_Reg.contains("_")) && (Username_Reg.length() < 6);
        
        return flag;
    }
    //end of checkUsername
    
    // method 2
    public boolean checkPasswordComplexity(String Password_Reg) {
        
        Matcher matcher = pattern.matcher(Password_Reg);
        
        flag1 = matcher.matches();
        
        return flag1;
    }
    
    //end of checkPasswordComplexity()
    
    // Method 3
    public void registerUser() {
        boolean continueRegistration = true; // Variable to control loop exit

        label_1: {
            while (continueRegistration && Password_Reg != null) {
                break label_1;
            }

            if (continueRegistration && Username_Reg != null) {
                // Username portion
                while (!checkUserName(Username_Reg)) {
                    System.out.println("Username is not correctly formatted, "
                            + "Please ensure that your username contains an underscore and is no more than 5 characters");
                    Username_Reg = sc.next();
                }//endwhile

                if (checkUserName(Username_Reg)) {
                    System.out.println("Username successfully captured.");
                }
            }
        }

        if (continueRegistration && Password_Reg == null) {
            return;
        }

        // Password portion
        Matcher matcher = pattern.matcher(Password_Reg);

        while (continueRegistration && !checkPasswordComplexity(Password_Reg)) {
            System.out.println("Password is not correctly formatted, "
                    + "please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            Password_Reg = sc.next();
            matcher = pattern.matcher(Password_Reg);
        }//endwhile

        if (continueRegistration && checkPasswordComplexity(Password_Reg)) {
            System.out.println("Password successfully captured");
        }
    }//end of registerUser()

    // method 4
    public boolean loginUser(){
        flag2 = Password_Login.equals(Password_Reg) && Username_Login.equals(Username_Reg);
        return flag2;
    }  
    //end of loginUser()
      
    public boolean loginUser(String username, String password) {
        return password.equals(Password_Reg) && username.equals(Username_Reg);
    }
      
    // Method 5
    public boolean returnLoginStatus() {
        System.out.print("Please enter your username >> ");
        String username = sc.next();
        System.out.print("Please enter your password >> ");
        String password = sc.next();

        if (loginUser(username, password)) {
            System.out.println("\nWelcome " + Name_ + " " + Surname_ + "! It is great to see you again.");
            return true; // Return true if login is successful
        } else {
            System.out.println("\nUsername or password incorrect, please try again.");
            return false; // Return false if login fails
        }
    }
    // End of method 5

    // Part 2: Task Management
    private int Size_;
    private String Task_Desc[] = new String[Size_];
    private String Task_Name[] = new String[Size_];
    private String Developer_Name[] = new String[Size_];
    private String Task_Duration[] = new String[Size_];
    private int Status_[] = new int[Size_];
    private int Total_;
    private int Count_;
    private String[] options = {"To do", "Done", "Doing"};
    private String Choice_;
    
    public Task(int size) {
        this.Size_ = size;
        this.Task_Desc = new String[size];
        this.Task_Name = new String[size];
        this.Developer_Name = new String[size];
        this.Task_Duration = new String[size];
        this.Status_ = new int[size];
    }
    
    // Getters and Setters
    
    
    
    public void setChoice(String choice) {
    this.Choice_ = choice;
}

    public int getSize_() {
        return Size_;
    }

    public void setSize_(int size) {
        this.Size_ = size;
    }

    public String[] getTask_Desc() {
        return Task_Desc;
    }

    public void setTask_Desc(String[] Task_Desc) {
        this.Task_Desc = Task_Desc;
    }

    public String[] getTask_Name() {
        return Task_Name;
    }

    public void setTask_Name(String[] Task_Name) {
        this.Task_Name = Task_Name;
    }

    public String[] getDeveloper_Name() {
        return Developer_Name;
    }

    public void setDeveloper_Name(String[] Developer_Name) {
        this.Developer_Name = Developer_Name;
    }

    public String[] getTask_Duration() {
        return Task_Duration;
    }

    public void setTask_Duration(String[] Task_Duration) {
        this.Task_Duration = Task_Duration;
    }

    public int[] getStatus_() {
        return Status_;
    }

    public void setStatus_(int[] Status_) {
        this.Status_ = Status_;
    }

    public int getTotal_() {
        return Total_;
    }

    public void setTotal_(int Total_) {
        this.Total_ = Total_;
    }

    public int getCount_() {
        return Count_;
    }

    public void setCount_(int Count_) {
        this.Count_ = Count_;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    // Method 1: Check Task Description
    public boolean checkTaskDescription(String desc) {
        return desc.length() < 51 && desc.length() > 0;
    }

    // Method 2: Create Task ID
    public String createTaskID() {
        String a = Character.toString(Task_Name[getCount_()].charAt(0));
        String b = Character.toString(Task_Name[getCount_()].charAt(1));
        String c = Character.toString(Developer_Name[getCount_()].charAt(Developer_Name[getCount_()].length() - 3));
        String d = Character.toString(Developer_Name[getCount_()].charAt(Developer_Name[getCount_()].length() - 2));
        String e = Character.toString(Developer_Name[getCount_()].charAt(Developer_Name[getCount_()].length() - 1));

        String taskID = a.toUpperCase() + b.toUpperCase() + ":" + getCount_() + ":" + c.toUpperCase() + d.toUpperCase() + e.toUpperCase();

        return taskID;
    }

    // Method 3: Print Task Details
    public String printTaskDetails() {
        String taskDet = "Status: " + options[Status_[getCount_()]] +
                "\nDeveloper: " + Developer_Name[getCount_()] +
                "\nTask Number: " + getCount_() +
                "\nTask Name: " + Task_Name[getCount_()] +
                "\nDescription: " + Task_Desc[getCount_()] +
                "\nTask ID: " + createTaskID() +
                "\nDuration: " + Task_Duration[getCount_()] + " hours";

        return taskDet;
    }

    // Method 4: Return Total Hours
    public int returnTotalHours() {
        return Total_;
    }

    // Method for verifying user's choice
    public String verifyChoice() {
        while (Choice_ == null || !(Choice_.equals("1")) && !(Choice_.equals("2")) && !(Choice_.equals("3")) && !(Choice_.equals("4")) && !(Choice_.equals("5")) && !(Choice_.equals("6")) && !(Choice_.equals("7")) && !(Choice_.equals("0"))) {
            Choice_ = JOptionPane.showInputDialog(null, "\nSelect an action to proceed with:\n" +
                    "1. Add tasks\n" +
                    "2. Show report\n" +
                    "3. View all completed tasks\n" +
                    "4. Display task with the longest duration\n" +
                    "5. Search for task\n" +
                    "6. Search tasks by developer\n" +
                    "7. Delete a task\n\n" +
                    "0. Quit\n" +
                    "* Please enter only the number that corresponds to your chosen action", "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
        }
        return Choice_;
    }

    // Method for verifying task name
    public String verifyTaskName() {
        while (Task_Name[getCount_()] == null || Task_Name[getCount_()].length() < 2) {
            Task_Name[getCount_()] = JOptionPane.showInputDialog(null, "Please ensure that your task name is at least 2 characters long",
                    "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
        }
        return Task_Name[getCount_()];
    }

    // Method for verifying developer name
    public String verifyDeveloperName() {
        while (Developer_Name[getCount_()] == null || Developer_Name[getCount_()].length() < 3) {
            Developer_Name[getCount_()] = JOptionPane.showInputDialog(null, "Please ensure that your developer's name is at least 3 characters long",
                    "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
        }
        return Developer_Name[getCount_()];
    }

    // Method for verifying task duration
    public String verifyTaskDuration() {
        while (true) {
            try {
                Integer.parseInt(Task_Duration[getCount_()]);
                break;
            } catch (NumberFormatException e) {
                Task_Duration[getCount_()] = JOptionPane.showInputDialog(null, "Enter the estimated task duration in hours\n" +
                        "Ensure that it is a numeric value",
                        "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
            }
        }
        return Task_Duration[getCount_()];
    }
}
