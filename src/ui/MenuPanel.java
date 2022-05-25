package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Panel within GUI that handles navigation between different areas of reference builder
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class MenuPanel extends JPanel {

    // Declares class fields
    private final UIPanel ui;

    /**
     * Constructs and initializes menu JPanel
     * @param ui UIPanel parent class
     */
    public MenuPanel(UIPanel ui) {
        this.ui = ui;

        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        JLabel title = new JLabel("Reference Builder");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(title);

        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 20));
        buttonPanel.setPreferredSize(new Dimension(400, 400));
        buttonPanel.setBorder(new EmptyBorder(130, 0, 0, 0));

        JButton addReferenceButton = new JButton("Add Reference");
        addReferenceButton.setFont(new Font("Arial", Font.BOLD, 25));
        addReferenceButton.addActionListener(e -> ui.switchToCard(UIPanel.ADD_REFERENCE));
        buttonPanel.add(addReferenceButton);


        JButton generateReferenceListButton = new JButton("Reference List");
        generateReferenceListButton.setFont(new Font("Arial", Font.BOLD, 25));
        generateReferenceListButton.addActionListener(e -> {
            ui.generateReferenceListPanel.generateReferenceList();
            ui.switchToCard(UIPanel.GENERATE_REFERENCE_LIST);
        });
        buttonPanel.add(generateReferenceListButton);

        JButton resetReferenceListButton = new JButton("Reset Reference List");
        resetReferenceListButton.setFont(new Font("Arial", Font.BOLD, 25));
        resetReferenceListButton.addActionListener(e -> {
            ui.getReferenceBuilder().resetReferences();
            JOptionPane.showMessageDialog(this, "Reference List has been reset");
        });
        buttonPanel.add(resetReferenceListButton);

        centerPanel.add(buttonPanel);

        add(centerPanel, BorderLayout.CENTER);
    }
}
