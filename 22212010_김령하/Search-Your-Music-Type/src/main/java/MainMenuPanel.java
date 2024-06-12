import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    public MainMenuPanel(MusicApp app, CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new BorderLayout());

        JButton registerMusicButton = new JButton("Register Music");
        JButton recommendMusicButton = new JButton("Recommend Music");
        JButton myPageButton = new JButton("My Page");
        JButton backButton = new JButton("Logout");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerMusicButton);
        buttonPanel.add(recommendMusicButton);
        buttonPanel.add(myPageButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.NORTH);

        //곡 목록 표시
        String[] columnNames = {"Genre", "Mood", "Title", "Artist"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        for (Music music : app.getMusicList()) {
            Object[] row = {music.getGenre(), music.getMood(), music.getTitle(), music.getArtist()};
            model.addRow(row);
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

        registerMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel registerMusicPanel = new MusicRegisterPanel(app, cardLayout, mainPanel);
                mainPanel.add(registerMusicPanel, "registerMusic");
                cardLayout.show(mainPanel, "registerMusic");
            }
        });

        recommendMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel recommendMusicPanel = new MusicRecommendPanel(app, cardLayout, mainPanel);
                mainPanel.add(recommendMusicPanel, "recommendMusic");
                cardLayout.show(mainPanel, "recommendMusic");
            }
        });

        myPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel myPagePanel = new MyPagePanel(app, cardLayout, mainPanel);
                mainPanel.add(myPagePanel, "myPage");
                cardLayout.show(mainPanel, "myPage");
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
