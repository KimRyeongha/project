import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    public LoginPanel(MusicApp app, CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridLayout(3, 2));

        JTextField idField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Join");

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                User user = app.login(id, password);

                if (user != null) {
                    cardLayout.show(mainPanel, "mainMenu");
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid ID or Password");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "register");
            }
        });
    }
}
