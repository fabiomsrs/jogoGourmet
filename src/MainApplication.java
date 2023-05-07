import application.GameFrame;

import javax.swing.SwingUtilities;

public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}
