public class Book {
    private String code;
    private String name;
    private int pages;
    private Gender gender;
    private int years;
    private Author author;

    public Book(String code, String name, int pages, Gender gender, int years, Author author, String editor,
            boolean disponibility) {
        this.code = code;
        this.name = name;
        this.pages = pages;
        this.gender = gender;
        this.years = years;
        this.author = author;
        this.editor = editor;
        this.disponibility = disponibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public boolean isDisponibility() {
        return disponibility;
    }

    public void setDisponibility(boolean disponibility) {
        this.disponibility = disponibility;
    }

    private String editor;
    private boolean disponibility;

}
