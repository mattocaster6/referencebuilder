package reference;

/**
 * Represents a reference to a website.
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class Website extends Item {

    // Reference attributes are declared here
    protected String source;
    protected String title;
    protected String typeOfMedium;
    protected String availableAt;
    protected String accessedDate;

    /**
     * Constructs new Website object and sets format placeholder
     */
    public Website() {
        format = "Authorship or Source, Year. Title of web document or web page. [type of medium] (date of update if available) Available at: include web address/URL * [Accessed date].";
    }

    /**
     * Sets attribute of reference and adds necessary formatting to attributes
     * @param attribute name of attribute to set
     * @param value value to set attribute to
     */
    @Override
    public void setAttribute(String attribute, String value) {
        switch(attribute) {
            case "source":
                source = value + ", ";
                break;
            case "title":
                title = "<em>" + value + ".</em> ";
                break;
            case "typeOfMedium":
                typeOfMedium = "[" + value + "] ";
                break;
            case "year":
                year = value + ". ";
                break;
            case "availableAt":
                availableAt = "Available at: &lt;" + value + "&gt; ";
                break;
            case "accessedDate":
                accessedDate = "[Accessed " + value + "].";
        }
    }

    /**
     * Adds attributes together to create formatted reference and stores in public format field.
     * @return formatted reference String
     */
    @Override
    public String getReference() {

        if(source == null || year == null || title == null || typeOfMedium == null || availableAt == null || accessedDate == null) {
            formattedReference = "INCOMPLETE";
        } else {
            formattedReference = source + year + title + typeOfMedium + availableAt + accessedDate;
        }

        return formattedReference;
    }

    /**
     * Gets the name of attribute at specified index
     * @param index index of attribute
     * @return name of attribute
     */
    @Override
    public String getAttributeName(int index) {
        String name = "";

        switch(index) {
            case 0:
                name = "source";
                break;
            case 1:
                name = "year";
                break;
            case 2:
                name = "title";
                break;
            case 3:
                name = "typeOfMedium";
                break;
            case 4:
                name = "availableAt";
                break;
            case 5:
                name = "accessedDate";
        }

        return name;
    }

    /**
     * Gets version of attribute name to be outputted at specified index
     * @param index index of attribute
     * @return attribute name suitable for output
     */
    @Override
    public String getAttributeNameFormatted(int index) {
        String name = "";

        switch(index) {
            case 0:
                name = "Source";
                break;
            case 1:
                name = "Year";
                break;
            case 2:
                name = "Title";
                break;
            case 3:
                name = "Type of Medium";
                break;
            case 4:
                name = "Available At";
                break;
            case 5:
                name = "Accessed Date";
        }

        return name;
    }

    /**
     * Retrieves number of attributes associated with reference
     * @return number of attributes for reference
     */
    @Override
    public int getNumAttributes() {
        return 6;
    }
}
