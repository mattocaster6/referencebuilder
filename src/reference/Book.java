package reference;

/**
 * Represents a normal book reference
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class Book extends Item {

    // Reference attributes are declared here
    protected String initials;
    protected String title;
    protected String edition;
    protected String placeOfPublication;
    protected String publisher;

    /**
     * Constructs new Book object and sets format placeholder
     */
    public Book() {
        format = "Author, Initials., Year. Title of book. Edition. (only include this if not the first edition) Place of publication (this must be a town or city, not a country): Publisher.";
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
            case "initials":
                initials = value + "., ";
                break;
            case "year":
                year = value + ". ";
                break;
            case "title":
                title = "<em>" + value + "." + "</em> ";
                break;
            case "edition":
                edition = value + " ed. ";
                break;
            case "placeOfPublication":
                placeOfPublication = value + ": ";
                break;
            case "publisher":
                publisher = value + ".";
                break;
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

        if(edition == null) {
            edition = "";
        }

        if(author == null || year == null || title == null || placeOfPublication == null || publisher == null) {
            formattedReference = "INCOMPLETE";
        } else {
            formattedReference = author + initials + year + title + edition + placeOfPublication + publisher;
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
                name = "title";
                break;
            case 4:
                name = "edition";
                break;
            case 5:
                name = "placeOfPublication";
                break;
            case 6:
                name = "publisher";
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
                name = "Title";
                break;
            case 4:
                name = "Edition";
                break;
            case 5:
                name = "Place of Publication";
                break;
            case 6:
                name = "Publisher";
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
