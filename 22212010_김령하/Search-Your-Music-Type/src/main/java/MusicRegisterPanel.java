import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicRegisterPanel extends JPanel {
    private MusicApp app;

    public MusicRegisterPanel(MusicApp app, CardLayout cardLayout, JPanel mainPanel) {
        this.app = app;

        setLayout(new GridLayout(6, 2));

        JTextField titleField = new JTextField();
        JTextField artistField = new JTextField();
        JComboBox<String> genreBox = new JComboBox<>(new String[]{"Ballad", "Acoustic", "POP", "R&B", "Dance", "Hip-hop"});
        JComboBox<String> moodBox = new JComboBox<>(new String[]{"Party", "Calm", "Sad", "Dark", "Funky", "Groovy"});

        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Artist:"));
        add(artistField);
        add(new JLabel("Genre:"));
        add(genreBox);
        add(new JLabel("Mood:"));
        add(moodBox);

        JButton registerButton = new JButton("Register");
        add(registerButton);
        JButton backButton = new JButton("Back");
        add(backButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String artist = artistField.getText();
                String genre = (String) genreBox.getSelectedItem();
                String mood = (String) moodBox.getSelectedItem();

                Music music = new Music(title, artist, genre, mood);
                app.addMusic(music);
                JOptionPane.showMessageDialog(MusicRegisterPanel.this, "Music Registered!");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "mainMenu");
            }
        });
    }
}
