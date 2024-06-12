import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicApp app = new MusicApp();
            JFrame frame = new JFrame("Search Your Music Type !");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            CardLayout cardLayout = new CardLayout();
            JPanel mainPanel = new JPanel(cardLayout);

            LoginPanel loginPanel = new LoginPanel(app, cardLayout, mainPanel);
            RegisterPanel registerPanel = new RegisterPanel(app, cardLayout, mainPanel);
            MainMenuPanel mainMenuPanel = new MainMenuPanel(app, cardLayout, mainPanel);

            mainPanel.add(loginPanel, "login");
            mainPanel.add(registerPanel, "register");
            mainPanel.add(mainMenuPanel, "mainMenu");

            frame.add(mainPanel);
            frame.setVisible(true);

            cardLayout.show(mainPanel, "login");
        });
    }
}
