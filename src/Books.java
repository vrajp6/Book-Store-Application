public class Books {

    private String title;
    private String author;
    private String pages;
    private String publisher;
    private String year;
    private String copies;
    private String category;

    public Books (String title, String author, String pages, String publisher, String year, String copies, String category) {

        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publisher = publisher;
        this.year = year;
        this.copies = copies;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCopies() {
        return copies;
    }

    public void setCopies(String copies) {
        this.copies = copies;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return " Title: " + title + "  Author: " + author + "   Pages: " + pages + "   Publisher: " + publisher + "   Year: " + year + "   Copies: " + copies + "   Category: " + category + "\n";
    }
}
