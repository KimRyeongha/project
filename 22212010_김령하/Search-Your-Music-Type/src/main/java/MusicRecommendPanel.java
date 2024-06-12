import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MusicRecommendPanel extends JPanel {
    private MusicApp app;

    public MusicRecommendPanel(MusicApp app, CardLayout cardLayout, JPanel mainPanel) {
        this.app = app;

        setLayout(new BorderLayout());

        JComboBox<String> genreBox = new JComboBox<>(new String[]{"Ballad", "Acoustic", "POP", "R&B", "Dance", "Hip-hop"});
        JComboBox<String> moodBox = new JComboBox<>(new String[]{"Party", "Calm", "Sad", "Dark", "Funky", "Groovy"});
        JButton recommendButton = new JButton("Recommend");
        JButton backButton = new JButton("Back");

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Genre"));
        filterPanel.add(genreBox);
        filterPanel.add(new JLabel("Mood"));
        filterPanel.add(moodBox);
        filterPanel.add(recommendButton);
        filterPanel.add(backButton);

        add(filterPanel, BorderLayout.NORTH);

        // 추천 결과 표시 
        String[] columnNames = {"Title", "Artist"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable resultTable = new JTable(model);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genre = (String) genreBox.getSelectedItem();
                String mood = (String) moodBox.getSelectedItem();

                List<Music> musicList = app.getMusicList();
                model.setRowCount(0);  
                for (Music music : musicList) {
                    if (music.getGenre().equals(genre) && music.getMood().equals(mood)) {
                        Object[] row = {music.getTitle(), music.getArtist()};
                        model.addRow(row);
                    }
                }
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
