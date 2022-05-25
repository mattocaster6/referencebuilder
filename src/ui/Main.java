package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Main class for reference builder, this is where the program is started and represents the main JFrame
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class Main extends JFrame {

    // Declares class fields
    public static final int FRAME_WIDTH = 1000;
    public static final int FRAME_HEIGHT = 800;
    public static final String FRAME_TITLE = "Reference Builder";

    /**
     * Constructs and initializes main JFrame
     */
    public Main() {
        setTitle(FRAME_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        add(new UIPanel());
    }

    /**
     * Program main method, starting point of program
     * @param args arguments to program
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}
