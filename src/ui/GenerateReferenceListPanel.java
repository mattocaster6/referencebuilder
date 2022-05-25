package ui;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Clipboard;
import reference.Item;

import javax.swing.*;
import java.awt.*;

/**
 * Panel within GUI that displays current reference list.
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class GenerateReferenceListPanel extends JPanel {

    // Declares class fields
    private final JTextPane referenceTextArea;
    private final UIPanel ui;

    /**
     * Constructs and initializes reference list display area
     * @param ui parent UIPanel
     */
    public GenerateReferenceListPanel(UIPanel ui) {
        this.ui = ui;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel title = new JLabel("Reference List");
        title.setFont(new Font("Arial", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        referenceTextArea = new JTextPane();
        referenceTextArea.setContentType("text/html");
        referenceTextArea.setEditable(false);
        add(referenceTextArea, BorderLayout.CENTER);


        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> ui.switchToCard(UIPanel.MENU));
        add(backButton, BorderLayout.SOUTH);
    }

    /**
     * Loops through reference list and appends to text area.
     */
    public void generateReferenceList() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><p style='font-size: 17px;'>");
        for(Item reference : ui.getReferenceBuilder().getReferenceList()) {
            sb.append(reference.getReference()).append("<br>");
        }
        sb.append("</p></html>");
        referenceTextArea.setText(sb.toString());
    }
}
