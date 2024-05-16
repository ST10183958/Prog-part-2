/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login.system.part.pkg2;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
import javax.swing.table.DefaultTableModel;



public class LoginSystem extends JPanel{ 

    public static void main(String[] args) { 
        MenuPage();
       // ShowTable(); 
        //MenuPage();
        //SignUpSuccessful("W_t","@Awsome1415");
        //WelcomeMethod();
        //MainKanbanBoard();
    }
    
    
    public static void MenuPage() {
        JFrame f=new JFrame();
        
        // Variables for storing account that has been created //
        boolean Accountexists = false;
        String AccountUsername = "";
        String AccountPassword = "";
        
        
        JTextField AccountName;
        
        JLabel MainText;
        MainText = new JLabel("Enter Details");
        MainText.setBounds(150,1,500,30);
        f.add(MainText);
        

        
        // Username //
        JLabel AccountNameLabel = new JLabel("Username:");
        AccountNameLabel.setBounds(10,100, 200,30); 
        f.add(AccountNameLabel);
        
        
        AccountName = new JTextField( 16);
        AccountName.setBounds(100,100, 200,30); 
        f.add(AccountName);
        // Username //
        
        // Password //
        JLabel PasswordLabel = new JLabel("Password:");
        PasswordLabel.setBounds(10,150, 200,30); 
        f.add(PasswordLabel);
        
        JTextField Password;
        Password = new JTextField( 16);
        Password.setBounds(100,150, 200,30); 
        f.add(Password);
        // Username //
        
        // Buttons //
        JButton SignInButton=new JButton("Sign In");
        SignInButton.setBounds(20,200,100, 40);
        f.add(SignInButton);
        
        JButton SignUpButton=new JButton("Sign Up");
        SignUpButton.setBounds(120,200,100, 40);
        f.add(SignUpButton);
        // Buttons //
        
        // Sign in Event //
        SignInButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               
                // Username //
                String AccountInput1 = AccountName.getText();
                boolean AccountInput2 = UsernameVerification(AccountInput1);
                
                // Password //
                String PasswordInput1 = Password.getText();
                boolean PasswordInput2 = PasswordVerification(PasswordInput1);
                
                if(AccountInput2==true && PasswordInput2==true) {
                    LoginSuccessful();          
            }
            }  
        });  
        // Sign in Event //
        
        // Sign up Event //
        SignUpButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               
                // Username //
                String AccountInput1 = AccountName.getText();
                boolean AccountInput2 = UsernameVerification(AccountInput1);
                
                // Password //
                String PasswordInput1 = Password.getText();
                boolean PasswordInput2 = PasswordVerification(PasswordInput1);
                
                if(AccountInput2==true && PasswordInput2==true) {
                    SignUpSuccessful(AccountInput1,PasswordInput1);
                    MainText.setText(AccountUsername);
                    f.dispose();
                    
                }
            }  
        });  
        // Sign up Event //
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    
    // Verifying if requirements for username are met //
     public static boolean UsernameVerification(String AccountInput) {
         boolean SizeMet = false;
         boolean UnderscoreMet = false;
         boolean finalOutput = false;
         
         if(AccountInput.length() > 5) {
             SizeMet = false;
         } else{
             SizeMet = true;
         }
         
         if(AccountInput.contains("_")) {
             UnderscoreMet = true;
         } else {
             UnderscoreMet = false;
         }
         
         if(SizeMet == true && UnderscoreMet==true) {
             finalOutput = true;
         } 
         if(SizeMet == false && UnderscoreMet == false){
             finalOutput = false;
             UsernameConditionsAlert(SizeMet,UnderscoreMet);
         }else {
             
         }
          //UsernameConditionsAlert();
         return finalOutput;
     }
     // Verifying if requirements for username are met //

     // Verifying if requirements for username are met //
     public static boolean PasswordVerification(String PasswordInput) {
        boolean PasswordCondition = false;
        boolean PasswordSize = false;
        boolean CapitalLetter = false;
        boolean HasNumber = false;
        boolean HasSpecialCharacter = false;
        boolean AllConditionsMet = false;
        
        boolean[] expected = { false, false, false, false, false };
        
        // Password length //
        if(PasswordInput.length() > 8) {
            PasswordSize = true;
        }if(PasswordInput.length() < 8) {
            PasswordSize = false;           
        }
        
        if(PasswordSize == true) {
           // PasswordCondition = "Password accepted";
        }if(PasswordSize == false) {
           // PasswordCondition = "Password Denied";
        }
        // Password length //
  
        
       // Contains a capital letter //
       CapitalLetter = hasCapitalLetter(PasswordInput);
       
       if(CapitalLetter == true) {
          // PasswordCondition = "Password has capital letter";
       }if(CapitalLetter == false) {
          // PasswordCondition = "Password does not have capital letter";
       }
       
       // Contains a capital letter //
       
       // Function to detect if password has an integer // 
        for (char c : PasswordInput.toCharArray()) {
            if (Character.isDigit(c)) {
                HasNumber = true;
                break;
            }
        }
       
       // Function to detect if password has an integer // 
       
       
       // Function to detect if password has a special character // 
        if (PasswordInput.matches(".*[^a-zA-Z0-9 ].*")) {
            HasSpecialCharacter = true;
        } else {
            HasSpecialCharacter = false;
        }
       // Function to detect if password has a special character // 
     
       if(PasswordSize==true && CapitalLetter==true && HasNumber==true && HasSpecialCharacter==true) {
           PasswordCondition = true;
       }else{
           PasswordCondition = false;
           PasswordConditionsAlert(PasswordSize,CapitalLetter,HasNumber,HasSpecialCharacter);
       }
       
        
        return PasswordCondition;
     }
     
     
    // Method to loop through String to detect if there is a capital letter // 
    public static boolean hasCapitalLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    // Method to loop through String to detect if there is a capital letter // 

     // Verifying if requirements for username are met //
    
    // Username Alert box //
    public static void UsernameConditionsAlert(boolean SizeMet, boolean UnderscoreMet) {
        JFrame f=new JFrame();
        
        JLabel Title;
        JLabel  SizeMetLabel;
        JLabel UnderscoreMetLabel;

        Title = new JLabel("Username conditions not met");
        Title.setBounds(10,80, 500,30);
        Title.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(Title);
        
        SizeMetLabel = new JLabel("Username is longer than 5 characters");
        SizeMetLabel.setBounds(10,200, 500,30);
        SizeMetLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(SizeMetLabel);
        
        UnderscoreMetLabel = new JLabel("The Username does not contain an underscore");
        UnderscoreMetLabel.setBounds(10,220, 500,30);
        UnderscoreMetLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(UnderscoreMetLabel);
        
        
        JButton CloseButton=new JButton("Close");  
        CloseButton.setBounds(100,340,95,30);  
        f.add(CloseButton);  
        
        CloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               f.dispose();
            }
        });

        if(SizeMet == true) {
            SizeMetLabel.setText("Username size is accepted");
        }
        if(UnderscoreMet == true) {
            SizeMetLabel.setText("Username contains an underscore");
        }
 
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    // Username Alert box //
    
    // Password alert box //
    public static void PasswordConditionsAlert(boolean PasswordSize,boolean CapitalLetter, boolean HasNumber, boolean HasSpecialCharacter) {
        JFrame f=new JFrame();
        
        JLabel Title;
        JLabel PasswordSizeLabel;
        JLabel CapitalLetterLabel;
        JLabel HasNumberLabel;
        JLabel HasSpecialCharacterLabel;
        Title = new JLabel("Password conditions not met");
        Title.setBounds(10,80, 500,30);
        Title.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(Title);
        
        PasswordSizeLabel = new JLabel("Password size is to small");
        PasswordSizeLabel.setBounds(10,200, 500,30);
        PasswordSizeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(PasswordSizeLabel);
        
        CapitalLetterLabel = new JLabel("Password does not have a capital letter");
        CapitalLetterLabel.setBounds(10,220, 500,30);
        CapitalLetterLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(CapitalLetterLabel);
        
        HasNumberLabel = new JLabel("Password Does not have an integer");
        HasNumberLabel.setBounds(10,240, 500,30);
        HasNumberLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(HasNumberLabel);
        
        HasSpecialCharacterLabel = new JLabel("Password doess not have a special character");
        HasSpecialCharacterLabel.setBounds(10,260, 500,30);
        HasSpecialCharacterLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(HasSpecialCharacterLabel);
        
        
        JButton CloseButton=new JButton("Close");  
        CloseButton.setBounds(100,340,95,30);  
        f.add(CloseButton); 
        
        CloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               f.dispose();
            }
        });
        

        if(PasswordSize == true) {
            PasswordSizeLabel.setText("Password Size is accepted");
        }
        
        if(CapitalLetter == true) {
            CapitalLetterLabel.setText("Password has Capital letter");
        }
                
        if(HasNumber == true) {
            HasNumberLabel.setText("Password has an integer");
        }
                        
         if(HasSpecialCharacter == true) {
            HasSpecialCharacterLabel.setText("Password has a special character");
        }
        
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    // Password alert box //
    
    
    // Display login in successful menu //
    public static void LoginSuccessful() {
        JFrame f=new JFrame();
        
        JLabel Msg;  
        Msg=new JLabel("you have been signed in");  
        Msg.setBounds(50,50, 500,30); 
        Msg.setFont(new Font("Serif", Font.PLAIN, 20));
        f.add(Msg);
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    public static void SignUpSuccessful(String ValAccountName, String ValPassword) {
        JFrame f=new JFrame();
  
        JLabel MainText;
        MainText = new JLabel("Account created!");
        MainText.setBounds(150,1,500,30);
        f.add(MainText);
        

        
        // Username //
        JLabel AccountNameLabel = new JLabel("Username:");
        AccountNameLabel.setBounds(10,100, 200,30); 
        f.add(AccountNameLabel);
        
        
        JTextField AccountName = new JTextField( 16);
        AccountName.setBounds(100,100, 200,30); 
        f.add(AccountName);
        // Username //
        
        // Password //
        JLabel PasswordLabel = new JLabel("Password:");
        PasswordLabel.setBounds(10,150, 200,30); 
        f.add(PasswordLabel);
        
        JTextField Password;
        Password = new JTextField( 16);
        Password.setBounds(100,150, 200,30); 
        f.add(Password);
        // Username //
        
                
        // Buttons //
        JButton SignInButton=new JButton("Sign In");
        SignInButton.setBounds(20,200,100, 40);
        f.add(SignInButton);
        
        SignInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                boolean AccountMatches = false;
                boolean PasswordMatches = false;
                String AccountInput = AccountName.getText();
                String PasswordInput = Password.getText();
                
                if(AccountInput == null ? ValAccountName == null : AccountInput.equals(ValAccountName)) {
                    AccountMatches = true;
                } else {
                    AccountMatches = false;
                }
                
                if(PasswordInput == null ? ValPassword == null : PasswordInput.equals(ValPassword)) {
                    PasswordMatches = true;
                } else {
                    PasswordMatches = false;
                }
                
                if(AccountMatches == true && PasswordMatches == true) {
                    MainText.setText("Account accepted");
                    WelcomeMethod();
                    f.dispose();
                } else {
                    MainText.setText(String.valueOf("Denied"));
                }
               
               
            }
        });
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    // Welcome board after signing in //
    public static void WelcomeMethod() {
        JFrame WelcomeFrame = new JFrame();
        
        JLabel WelcomeLabel;
        WelcomeLabel = new JLabel("Welcome to EasyKanban");
        WelcomeLabel.setBounds(10,1,500,30);
        WelcomeLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        WelcomeFrame.add(WelcomeLabel);
        
        
        JButton ContinueButton=new JButton("Continue");
        ContinueButton.setBounds(150,150,100, 40);
        WelcomeFrame.add(ContinueButton);
        
        ContinueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               MainKanbanBoard();
               WelcomeFrame.dispose();
            }
        });
        
        WelcomeFrame.setSize(400,300);
        WelcomeFrame.setLayout(null);
        WelcomeFrame.setVisible(true);
    }
    
    // Main method to add tasks //
    public static void MainKanbanBoard() {
        JFrame TaskFrame = new JFrame();
        
        JButton AddTaskButton=new JButton("Add task");
        AddTaskButton.setBounds(50,50,100, 40);
        TaskFrame.add(AddTaskButton);
        
        JButton ShowReportButton=new JButton("Show report");
        ShowReportButton.setBounds(220,50,100, 40);
        TaskFrame.add(ShowReportButton);
        
        JButton QuiteButton=new JButton("Quite");
        QuiteButton.setBounds(390,50,100, 40);
        TaskFrame.add(QuiteButton);
        
        
        AddTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               ShowTable();
            }
        });
        
        // shows the report feature which is still a work in progress //
        ShowReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               ShowReportProgress();
            }
        });
        
        // quite function to close the application //
        QuiteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               TaskFrame.dispose();
            }
        });
        
        TaskFrame.setSize(500,500);
        TaskFrame.setLayout(null);
        TaskFrame.setVisible(true);
    }
    
    // show report method which is still a work in progress
    public static void ShowReportProgress() {
        JFrame WorkInProgress = new JFrame();
        
        JLabel WIPLabel = new JLabel("Coming Soon");
        WIPLabel.setBounds(150,1,500,100);
        WIPLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        WorkInProgress.add(WIPLabel);
        
        JButton CloseButton=new JButton("Close");
        CloseButton.setBounds(200,100,100, 40);
        WorkInProgress.add(CloseButton);
        
        CloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               WorkInProgress.dispose();
            }
        });
        
        WorkInProgress.setSize(500,300);
        WorkInProgress.setLayout(null);
        WorkInProgress.setVisible(true);
    }
    
    public static void AddTask() {
        JFrame AddTaskFrame = new JFrame();
        
               
        AddTaskFrame.setSize(1400,800);
        AddTaskFrame.setLayout(null);
        AddTaskFrame.setVisible(true);
    }
    
    public static void ShowTable() {
        JFrame AddTaskFrame = new JFrame();
    //String TaskStatus, String DeveloperDetail, String TaskName, String TaskDescription, int Duration
      // Table section //
      DefaultTableModel tableModel = new DefaultTableModel();
      JTable table = new JTable(tableModel);
      tableModel.addColumn("Task Name");
      tableModel.addColumn("Task Number");
      tableModel.addColumn("Task Description");
      tableModel.addColumn("Developer Details");
      tableModel.addColumn("Task Duration");
      tableModel.addColumn("Task Task ID");
      tableModel.addColumn("Task Status");    
      // Table section //

      
      
      
              //Task Name //
        JLabel TaskNameLabel = new JLabel("Task Name");
        TaskNameLabel.setBounds(20,65,100,100);
        AddTaskFrame.add(TaskNameLabel);
        
        JTextField TaskNameInput = new JTextField( 16);
        TaskNameInput.setBounds(100,100, 200,30); 
        AddTaskFrame.add(TaskNameInput);
        
        //Task Description //
        JLabel TaskDescriptionLabel = new JLabel("Task Description");
        TaskDescriptionLabel.setBounds(20,115,500,100);
        AddTaskFrame.add(TaskDescriptionLabel);
        
        JTextArea area=new JTextArea();  
        area.setBounds(10,180, 200,200);  
        AddTaskFrame.add(area); 
        
        
        // Developer Name //
        JLabel DeveloperNameLabel = new JLabel("Developer Name");
        DeveloperNameLabel.setBounds(20,360,300,100);
        AddTaskFrame.add(DeveloperNameLabel);
        
        JTextField DeveloperNameInput = new JTextField( 16);
        DeveloperNameInput.setBounds(170,400, 200,30); 
        AddTaskFrame.add(DeveloperNameInput);
        
        // Developer Surname //
        JLabel DeveloperSurnameLabel = new JLabel("Developer Surname");
        DeveloperSurnameLabel.setBounds(20,410,300,100);
        AddTaskFrame.add(DeveloperSurnameLabel);
        
        JTextField DeveloperSurnameInput = new JTextField( 16);
        DeveloperSurnameInput.setBounds(170,450, 200,30); 
        AddTaskFrame.add(DeveloperSurnameInput);
        
        // Task Duration //
        JLabel DurationLabel = new JLabel("Task Duration");
        DurationLabel.setBounds(10,470,300,100);
        AddTaskFrame.add(DurationLabel);
        
        JSpinner DurationSpinner = new JSpinner();
        DurationSpinner.setBounds(110, 500, 50, 40);
        AddTaskFrame.add(DurationSpinner);
        
        
        // Task Statues
         DefaultListModel<String> l1 = new DefaultListModel<>();
          l1.addElement("To do");  
          l1.addElement("Done");  
          l1.addElement("Doing");   
          JList<String> list = new JList<>(l1);  
          list.setBounds(10,570, 150,150);  
          AddTaskFrame.add(list);
          
          
        JButton AddTask=new JButton("Add Task");
        AddTask.setBounds(200,750,100, 40);
        AddTaskFrame.add(AddTask);
        
            
    
            AddTask.addActionListener(new ActionListener() {
            boolean DescriptionStat = false;
            public void actionPerformed(ActionEvent e)
            {
                int count = 0;
                
                 for (int i = 0; i < area.getText().length(); i++) {
                     count++;
                     if(count>50) {
                         DescriptionStat=true;
                     } else {
                     DescriptionStat=false;
                 }

                    
                 }
                 //JOptionPane.showMessageDialog(AddTaskFrame, String.valueOf(DescriptionStat));
                 
                 if(DescriptionStat == false) {
                     // Retrieving  Task Status
                     int TaskStatus = list.getSelectedIndex();
                     String StrTaskStatus = null;
                     switch(TaskStatus) {
                         case 0:
                             StrTaskStatus = "To Do";
                         break;
                         
                        case 1:
                             StrTaskStatus = "To Do";
                         break;
                         
                        case 2:
                             StrTaskStatus = "To Do";
                         break;
                     }
                     // Retreiving all needed input values
                     String TaskName = TaskNameInput.getText();
                     String TaskDescription = area.getText();
                     String NamePart = DeveloperNameInput.getText();
                     String SurnamePart = DeveloperSurnameInput.getText();
                     String DeveloperDetails = NamePart + SurnamePart;
                     int Duration = (int) DurationSpinner.getValue();
                     String DurationAsString = String.valueOf(Duration);
                     int NewTaskNumber = tableModel.getRowCount()+1;
                     //String las = NamePart.substring(Math.max(NamePart.length() - 3, 0));
                     String TaskID = TaskName.substring(0, 2) + ':'+NewTaskNumber+':'+NamePart.substring(Math.max(NamePart.length() - 3, 0)).toUpperCase();
                     
                     
                     tableModel.insertRow(tableModel.getRowCount(), new Object[] { TaskName, String.valueOf(NewTaskNumber), TaskDescription, DeveloperDetails, DurationAsString+"hrs",TaskID,StrTaskStatus});
                     JOptionPane.showMessageDialog(AddTaskFrame, String.valueOf(TaskID));
                     
                 } else{
                     JOptionPane.showMessageDialog(AddTaskFrame, "Please enter a task description of less than 50 characters");
                }
            }
        });
      
      
      
      
      
      
      
      
      
      AddTaskFrame.setSize(1400,800);
      AddTaskFrame.add(new JScrollPane(table));
      AddTaskFrame.setVisible(true);
    }

    private static void JTableExamples() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

