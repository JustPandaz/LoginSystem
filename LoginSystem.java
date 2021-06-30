import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class LoginSystem {

    JFrame frame;
    JButton  btnLogin, btnRegister, btnReset;
    JLabel usernameLabel, passwordLabel, mainLabel;
    JTextField usernameField;
    JPasswordField passwordField;

    String username, password;

    int result;

    HashMap<String, String> loginDetails = new HashMap<>();

    LoginSystem() {

        frame = new JFrame("Login System");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 315);
        frame.setLayout(null);

        loginDetails.put("hi", "hi");

        UIBuilder();
        loginInfo();

        frame.setVisible(true);
    }

    void UIBuilder() {

        btnLogin = new JButton("Login");
        btnLogin.setBounds(15,200,100,25);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(140,200,100,25);

        btnReset = new JButton("Reset");
        btnReset.setBounds(265,200,100,25);

        mainLabel = new JLabel("Please enter your login details.");
        mainLabel.setBounds(50, 50, 250, 25);
        mainLabel.setFont(new Font(null, Font.BOLD, 15));

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50,100,75,25);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50,150,75,25);

        usernameField = new JTextField();
        usernameField.setBounds(125,100,200,25);

        passwordField = new JPasswordField();
        passwordField.setBounds(125,150,200,25);

        btnFunctions();

        frame.add(passwordField);
        frame.add(passwordLabel);
        frame.add(usernameField);
        frame.add(usernameLabel);
        frame.add(mainLabel);
        frame.add(btnLogin);
        frame.add(btnRegister);
        frame.add(btnReset);
    }

    void btnFunctions() {

        btnLogin.addActionListener(e1 -> {

            username = usernameField.getText();
            password = String.valueOf(passwordField.getPassword());

            if(loginDetails.containsKey(username)) {
                if(loginDetails.get(username).equals(password)) {

                    result = JOptionPane.showConfirmDialog(frame, "You have logged in successfully.", "Login System",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                } else {

                    result = JOptionPane.showConfirmDialog(frame, "Incorrect Password.", "Login System",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
                }
            } else {

                result = JOptionPane.showConfirmDialog(frame, "Username not found.", "Login System",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            }
        });

        btnReset.addActionListener(e1 -> {

            usernameField.setText("");
            passwordField.setText("");
        });

        btnRegister.addActionListener(e1 -> {

            result = JOptionPane.showConfirmDialog(frame, "Registration complete", "Login System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);

            loginDetails.put(username, password);
        });
    }

    void loginInfo() {

        loginDetails.put("Ahmad", "Ahmad");
        loginDetails.put("Panda" , "Panda2004");
        loginDetails.put("Admin", "Password");
        loginDetails.put("", "");
    }
}
