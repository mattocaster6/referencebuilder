package reference;

/**
 * Represents an E-Book reference
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class EBook extends Book {

    // Reference attributes are declared here
    protected String source;
    protected String url;
    protected String accessedDate;


    /**
     * Constructs new E-Book object and sets format placeholder
     */
    public EBook() {
        format = "Author, Initials., Year, Title of book. [e-book] Place of publication: Publisher. Followed by Available through: ARU Library website &lt;https://library.aru.ac.uk&gt; [Accessed date].";
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
                title = "<em>" + value + ".</em> [e-book] ";
                break;
            case "placeOfPublication":
                placeOfPublication = value + ": ";
                break;
            case "publisher":
                publisher = value + ". ";
                break;
            case "source":
                source = "Available at: " + value + " ";
                break;
            case "url":
                url = "&lt;" + value + "&gt; ";
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

        if(placeOfPublication == null) {
            placeOfPublication = "";
        }

        if(initials == null) {
            initials = "";
        }

        if(author == null || year == null || title == null || publisher == null || source == null || url == null || accessedDate == null) {
            formattedReference = "INCOMPLETE";
        } else {
            formattedReference = author + initials + year + title + placeOfPublication + publisher + source + url + accessedDate;
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
                name = "placeOfPublication";
                break;
            case 5:
                name = "publisher";
                break;
            case 6:
                name = "source";
                break;
            case 7:
                name = "url";
                break;
            case 8:
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
                name = "Place Of Publication";
                break;
            case 5:
                name = "Publisher";
                break;
            case 6:
                name = "Source";
                break;
            case 7:
                name = "Url";
                break;
            case 8:
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
        return 9;
    }
}
