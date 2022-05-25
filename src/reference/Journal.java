package reference;

/**
 * Represents a journal reference
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class Journal extends Item {

    // Reference attributes are declared here
    protected String initials;
    protected String articleTitle;
    protected String journalTitle;
    protected String volume;
    protected String pages;

    /**
     * Constructs new Journal object and sets format placeholder
     */
    public Journal() {
        format = "Author, Initials., Year. Title of article. Full Title of Journal, Volume number (Issue/Part number), Page number(s).";
    }

    /**
     * Sets attribute of reference and adds necessary formatting to attributes
     * @param attribute name of attribute to set
     * @param value value to set attribute to
     */
    @Override
    public void setAttribute(String attribute, String value) {
        switch(attribute) {
            case "author":
                author = value + ", ";
                break;
            case "year":
                year = value + ". ";
                break;
            case "initials":
                initials = value + ", ";
                break;
            case "articleTitle":
                articleTitle = value + ". ";
                break;
            case "journalTitle":
                journalTitle = "<em>" + value + ",</em> ";
                break;
            case "volume":
                volume = value + ", ";
                break;
            case "pages":
                pages = "pp." + value + ".";
        }
    }

    /**
     * Adds attributes together to create formatted reference and stores in public format field.
     * @return formatted reference String
     */
    @Override
    public String getReference() {

        if(initials == null) {
            initials = "";
        }

        if(author == null || year == null || articleTitle == null | journalTitle == null || volume == null || pages == null) {
            formattedReference = "INCOMPLETE";
        } else {
            formattedReference = author + initials + year + articleTitle + journalTitle + volume + pages;
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
                name = "author";
                break;
            case 1:
                name = "initials";
                break;
            case 2:
                name = "year";
                break;
            case 3:
                name = "articleTitle";
                break;
            case 4:
                name = "journalTitle";
                break;
            case 5:
                name = "volume";
                break;
            case 6:
                name = "pages";
                break;
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
                name = "Author";
                break;
            case 1:
                name = "Initials";
                break;
            case 2:
                name = "Year";
                break;
            case 3:
                name = "Article Title";
                break;
            case 4:
                name = "Journal Title";
                break;
            case 5:
                name = "Volume";
                break;
            case 6:
                name = "Pages";
                break;
        }

        return name;
    }

    /**
     * Retrieves number of attributes associated with reference
     * @return number of attributes for reference
     */
    @Override
    public int getNumAttributes() {
        return 7;
    }
}
