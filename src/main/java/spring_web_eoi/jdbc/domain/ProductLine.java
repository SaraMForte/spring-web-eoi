package spring_web_eoi.jdbc.domain;

public class ProductLine {
    private String line;
    private String textDescription;
    private String htmlDescription;
    private String image;

    public String line() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String textDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String htmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String image() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
