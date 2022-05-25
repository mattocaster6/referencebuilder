package ui;

import reference.ReferenceBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * Primary GUI JPanel using CardLayout that handles the cards and contains Reference Builder object
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class UIPanel extends JPanel {

    // Declares class fields
    public static final String MENU = "menu";
    public static final String ADD_REFERENCE = "add_reference";
    public static final String GENERATE_REFERENCE_LIST = "generate_reference_list";

    protected MenuPanel menuPanel;
    protected AddReferencePanel addReferencePanel;
    protected GenerateReferenceListPanel generateReferenceListPanel;

    private final ReferenceBuilder referenceBuilder;

    /**
     * Constructs and initializes UIPanel
     */
    public UIPanel() {

        referenceBuilder = new ReferenceBuilder();

        setLayout(new CardLayout());

        menuPanel = new MenuPanel(this);
        addReferencePanel = new AddReferencePanel(this);
        generateReferenceListPanel = new GenerateReferenceListPanel(this);

        add(menuPanel, MENU);
        add(addReferencePanel, ADD_REFERENCE);
        add(generateReferenceListPanel, GENERATE_REFERENCE_LIST);

        switchToCard(MENU);
    }

    /**
     * Switches to new card within CardLayout
     * @param card name of card to switch to
     */
    public void switchToCard(String card) {
        CardLayout cl = (CardLayout)getLayout();
        cl.show(this, card);
    }

    /**
     * Gets the reference builder object
     * @return the reference builder object
     */
    public ReferenceBuilder getReferenceBuilder() {
        return referenceBuilder;
    }
}
