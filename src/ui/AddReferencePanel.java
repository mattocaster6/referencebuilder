package ui;

import reference.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Panel within GUI that handles adding new references to reference list
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class AddReferencePanel extends JPanel {

    // Declares class fields
    private final JPanel attributesPanel;
    private final JLabel formatLabel;
    private JTextField[] attributeFields;
    private final UIPanel ui;

    /**
     * Constructs and initializes panel to handle adding references to reference list
     * @param ui UIPanel parent class
     */
    public AddReferencePanel(UIPanel ui) {
        this.ui = ui;

        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        JLabel title = new JLabel("Add New Reference");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(title);

        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();

        JPanel referencePanel = new JPanel();
        referencePanel.setPreferredSize(new Dimension(600, 550));

        String[] referenceTypes = {
                "Book",
                "Translated Book",
                "E-Book",
                "Journal",
                "Website"
        };

        JComboBox<String> referenceTypeComboBox = new JComboBox<>(referenceTypes);
        referenceTypeComboBox.setPreferredSize(new Dimension(300, 50));

        referenceTypeComboBox.addActionListener(e -> {
            switchAttributeFields(referenceTypeComboBox);
        });
        referencePanel.add(referenceTypeComboBox);

        centerPanel.add(referencePanel);

        add(centerPanel, BorderLayout.CENTER);

        attributesPanel = new JPanel();
        attributesPanel.setLayout(new BoxLayout(attributesPanel, BoxLayout.Y_AXIS));
        attributesPanel.setBorder(new EmptyBorder(0, 0, 0, 325));
        referencePanel.add(attributesPanel);

        formatLabel = new JLabel("<html>" + new Book().format + "</html>");
        formatLabel.setHorizontalAlignment(SwingConstants.CENTER);

        generateAttributeFields(new Book());

        JButton addReferenceButton = new JButton("Add Reference");
        addReferenceButton.addActionListener(e -> {
            addReference(ui, referenceTypeComboBox);
        });

        referencePanel.add(addReferenceButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> ui.switchToCard(UIPanel.MENU));
        referencePanel.add(backButton);
        add(formatLabel, BorderLayout.SOUTH);
    }

    /**
     * Adds reference to reference list depending on which reference type is selected in combo box
     * @param ui UIPanel object containing reference list
     * @param referenceTypeComboBox Reference type selection combo box
     */
    private void addReference(UIPanel ui, JComboBox<String> referenceTypeComboBox) {
        Item reference;

        switch(String.valueOf(referenceTypeComboBox.getSelectedItem())) {
            case "Book":
                reference = new Book();

                setReferenceAttributes(reference);

                ui.getReferenceBuilder().addReference(reference);
                JOptionPane.showMessageDialog(this, "Reference added.");
                break;
            case "Translated Book":
                reference = new TranslatedBook();

                setReferenceAttributes(reference);

                ui.getReferenceBuilder().addReference(reference);
                JOptionPane.showMessageDialog(this, "Reference added.");
                break;
            case "E-Book":
                reference = new EBook();

                setReferenceAttributes(reference);

                ui.getReferenceBuilder().addReference(reference);
                JOptionPane.showMessageDialog(this, "Reference added.");
                break;
            case "Journal":
                reference = new Journal();

                setReferenceAttributes(reference);

                ui.getReferenceBuilder().addReference(reference);
                JOptionPane.showMessageDialog(this, "Reference added.");
                break;
            case "Website":
                reference = new Website();

                setReferenceAttributes(reference);

                ui.getReferenceBuilder().addReference(reference);
                JOptionPane.showMessageDialog(this, "Reference added.");
        }

        for(JTextField attributeField : attributeFields) {
            attributeField.setText("");
        }
    }

    /**
     * Switches the displays attribute text fields depending on which reference type is selected
     * @param referenceTypeComboBox combo box for reference type selection
     */
    private void switchAttributeFields(JComboBox<String> referenceTypeComboBox) {
        if(String.valueOf(referenceTypeComboBox.getSelectedItem()).equals("Book")) {
            generateAttributeFields(new Book());
            validate();
        } else if (String.valueOf(referenceTypeComboBox.getSelectedItem()).equals("Translated Book")) {
            generateAttributeFields(new TranslatedBook());
            validate();
        } else if (String.valueOf(referenceTypeComboBox.getSelectedItem()).equals("E-Book")) {
           generateAttributeFields(new EBook());
           validate();
        } else if (String.valueOf(referenceTypeComboBox.getSelectedItem()).equals("Journal")) {
            generateAttributeFields(new Journal());
            validate();
        } else if (String.valueOf(referenceTypeComboBox.getSelectedItem()).equals("Website")) {
            generateAttributeFields(new Website());
            validate();
        }
    }

    /**
     * Loops through all attributes of reference and sets according to contents of attribute text fields
     * @param reference reference to set attributes of
     */
    private void setReferenceAttributes(Item reference) {
        for(int i = 0; i < reference.getNumAttributes(); i++) {
            if(!attributeFields[i].getText().equals("")) {
                reference.setAttribute(reference.getAttributeName(i), attributeFields[i].getText());
            }
        }
    }

    /**
     * Generates text fields for reference attributes
     * @param reference reference to set text fields for
     */
    public void generateAttributeFields(Item reference) {
        attributesPanel.removeAll();

        attributeFields = new JTextField[reference.getNumAttributes()];

        for(int i = 0; i < reference.getNumAttributes(); i++) {
            JPanel attributeRow = new JPanel(new GridLayout(1, 2));
            attributeFields[i] = new JTextField();
            attributeFields[i].setPreferredSize(new Dimension(350, 50));
            JLabel attributeLabel = new JLabel(reference.getAttributeNameFormatted(i) + ": ");
            attributeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            attributeRow.add(attributeLabel);
            attributeRow.add(attributeFields[i]);

            attributesPanel.add(attributeRow);
        }

        formatLabel.setText("<html>" + reference.format + "</html>");
    }
}
