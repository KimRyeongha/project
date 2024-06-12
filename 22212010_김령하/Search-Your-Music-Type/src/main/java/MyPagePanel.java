import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPagePanel extends JPanel {
    private MusicApp app;

    public MyPagePanel(MusicApp app, CardLayout cardLayout, JPanel mainPanel) {
        this.app = app;

        setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel(new GridLayout(3, 2));
        JTextField nicknameField = new JTextField(app.getLoggedInUser().getNickname());
        infoPanel.add(new JLabel("Nickname:"));
        infoPanel.add(nicknameField);

        JButton updateButton = new JButton("Update");
        infoPanel.add(updateButton);

        add(infoPanel, BorderLayout.NORTH);

        JTextArea musicArea = new JTextArea();
        add(new JScrollPane(musicArea), BorderLayout.CENTER);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newNickname = nicknameField.getText();
                app.getLoggedInUser().setNickname(newNickname);
                JOptionPane.showMessageDialog(MyPagePanel.this, "Nickname Updated!");
            }
        });

        JButton backButton = new JButton("Back");
        infoPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "mainMenu");
            }
        });
    }
}
