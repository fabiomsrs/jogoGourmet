package br.com.fabiano;

import br.com.fabiano.application.*;

import javax.swing.SwingUtilities;

public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}
