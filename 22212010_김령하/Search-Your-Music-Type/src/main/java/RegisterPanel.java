import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterPanel extends JPanel {
    private JTextField nicknameField = new JTextField(15);
    private JTextField idField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton registerButton = new JButton("Join");
    private JButton backButton = new JButton("Back");

    public RegisterPanel(MusicApp app, CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridLayout(5, 2)); 

        add(new JLabel("Nickname:"));
        add(nicknameField);
        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(registerButton);
        add(backButton); 

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = nicknameField.getText();
                String id = idField.getText();
                String password = new String(passwordField.getPassword());

                if (app.registerUser(nickname, id, password)) {
                    JOptionPane.showMessageDialog(null, "Join Completed");
                    cardLayout.show(mainPanel, "login");
                } else {
                    JOptionPane.showMessageDialog(null, "Join Failed");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "login");
            }
        });
    }
}
