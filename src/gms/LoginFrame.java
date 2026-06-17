package gms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class LoginFrame extends JFrame {


private ArrayList<Admin> admins;

private JTextField usernameField;
private JPasswordField passwordField;

public LoginFrame() {

    admins = FileManager.loadAdmins();

    setTitle("Hospital Queue Management System");
    setSize(450, 320);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);

    initUI();

    setVisible(true);
}

private void initUI() {

    Color primary = new Color(41, 128, 185);
    Color background = new Color(245, 247, 250);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBackground(background);
    mainPanel.setBorder(new EmptyBorder(20,20,20,20));

    JLabel title =
            new JLabel(
                    "Hospital Queue Management System",
                    SwingConstants.CENTER);

    title.setFont(
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    20));

    title.setForeground(primary);

    mainPanel.add(title,
            BorderLayout.NORTH);

    JPanel center =
            new JPanel(
                    new GridLayout(4,2,10,10));

    center.setBackground(background);

    usernameField =
            new JTextField();

    passwordField =
            new JPasswordField();

    center.add(new JLabel("Username"));
    center.add(usernameField);

    center.add(new JLabel("Password"));
    center.add(passwordField);

    JButton loginBtn =
            new JButton("Login");

    JButton signupBtn =
            new JButton("Sign Up");

    loginBtn.setBackground(primary);
   

    signupBtn.setBackground(
            new Color(39,174,96));



    center.add(loginBtn);
    center.add(signupBtn);

    mainPanel.add(center,
            BorderLayout.CENTER);

    add(mainPanel);

    loginBtn.addActionListener(
            e -> login());

    signupBtn.addActionListener(
            e -> signup());
}

private void login() {

    admins = FileManager.loadAdmins(); // 🔥 reload every time

    String user =
            usernameField.getText().trim();

    String pass =
            String.valueOf(passwordField.getPassword());

    for (Admin a : admins) {

        if (a.login(user, pass)) {

            dispose();

            SwingUtilities.invokeLater(
                    HospitalQueueSystem::new);

            return;
        }
    }

    JOptionPane.showMessageDialog(
            this,
            "Invalid Username or Password");
}

private void signup() {

    admins = FileManager.loadAdmins(); // 🔥 always sync with file

    String user =
            JOptionPane.showInputDialog(
                    this,
                    "Enter Username");

    if (user == null || user.trim().isEmpty())
        return;

    for (Admin a : admins) {

        if (a.getUsername().equalsIgnoreCase(user)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Username already exists");

            return;
        }
    }

    String pass =
            JOptionPane.showInputDialog(
                    this,
                    "Enter Password");

    if (pass == null || pass.trim().isEmpty())
        return;

    admins.add(new Admin(user, pass));

    FileManager.saveAdmins(admins); // save immediately

    JOptionPane.showMessageDialog(
            this,
            "Account Created Successfully");
}


}
