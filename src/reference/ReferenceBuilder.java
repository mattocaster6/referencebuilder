package reference;

import java.util.ArrayList;

/**
 * Represents the overall reference builder, handles storing and retrieving references from list.
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class ReferenceBuilder {

    private final ArrayList<Item> referenceList;

    /**
     * Constructs reference list as array list
     */
    public ReferenceBuilder() {
        referenceList = new ArrayList<>();
    }

    /**
     * Adds a new reference to list
     * @param reference reference to add
     */
    public void addReference(Item reference) {
        referenceList.add(reference);
    }

    /**
     * Resets the reference list by clearing it out
     */
    public void resetReferences() {
        referenceList.clear();
    }

    /**
     * Gets the reference list
     * @return reference list
     */
    public ArrayList<Item> getReferenceList() {
        return referenceList;
    }
}
