package reference;

/**
 * Abstract representation of a reference
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public abstract class Item {

    // Reference attributes are declared here
    protected String author;
    protected String year;
    public String format;
    public String formattedReference;

    /**
     * Sets attribute of reference and adds necessary formatting to attributes
     * @param attribute name of attribute to set
     * @param value value to set attribute to
     */
    public abstract void setAttribute(String attribute, String value);

    /**
     * Adds attributes together to create formatted reference and stores in public format field.
     * @return formatted reference String
     */
    public abstract String getReference();

    /**
     * Gets the name of attribute at specified index
     * @param index index of attribute
     * @return name of attribute
     */
    public abstract String getAttributeName(int index);

    /**
     * Gets version of attribute name to be outputted at specified index
     * @param index index of attribute
     * @return attribute name suitable for output
     */
    public abstract String getAttributeNameFormatted(int index);

    /**
     * Retrieves number of attributes associated with reference
     * @return number of attributes for reference
     */
    public abstract int getNumAttributes();

}
