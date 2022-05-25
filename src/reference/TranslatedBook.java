package reference;

/**
 * Represents a reference for a book that has been translated.
 *
 * @author Matthew Ritchie
 * @version 1.0
 */
public class TranslatedBook extends Book {

    // Reference attributes are declared here
    protected String translatedFrom;
    protected String translator;
    protected String translatorInitials;

    /**
     * Constructs new Translated Book object and sets format placeholder
     */
    public TranslatedBook() {
        format = "Author, Initials., Year. Title of book. Translated from (language) by (name of translator, initials first, then surname) Place of publication: Publisher.";
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
                title = "<em>" + value + ".</em> ";
                break;
            case "translatedFrom":
                translatedFrom = "Translated from " + value + " ";
                break;
            case "translator":
                translator = value + ". ";
                break;
            case "translatorInitials":
                translatorInitials = "by " + value + ". ";
                break;
            case "placeOfPublication":
                placeOfPublication = value + ": ";
                break;
            case "publisher":
                publisher = value + ".";
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

        if(translatorInitials == null) {
            translatorInitials = "";
        }

        if(author == null || year == null || title == null || translatedFrom == null || translator == null || placeOfPublication == null || publisher == null) {
            formattedReference = "INCOMPLETE";
        } else {
            formattedReference = author + initials + year + title + translatedFrom + translatorInitials + translator + placeOfPublication + publisher;
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
                name = "translatedFrom";
                break;
            case 5:
                name = "translator";
                break;
            case 6:
                name = "translatorInitials";
                break;
            case 7:
                name = "placeOfPublication";
                break;
            case 8:
                name = "publisher";
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
                name = "Translated From";
                break;
            case 5:
                name = "Translator";
                break;
            case 6:
                name = "Translator Initials";
                break;
            case 7:
                name = "Place of Publication";
                break;
            case 8:
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
        return 9;
    }
}
