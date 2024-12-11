class Book {
    private String code;
    private String name;
    private int pages;
    private Gender gender;
    private int years;
    private Author author;
    private String editor;
    private boolean availability;

    public Book(String name, int pages, Gender gender, int years, Author author, String editor, boolean availability) {
        this.code = generateRandomCode(10);
        this.name = name;
        this.pages = pages;
        this.gender = gender;
        this.years = years;
        this.author = author;
        this.editor = editor;
        this.availability = availability;
    }

    private String generateRandomCode(int length) {
        String characters = "#"+"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (characters.length() * Math.random());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                ", gender=" + gender.getName() +
                ", years=" + years +
                ", author=" + author.getFirstName() + " " + author.getLastName() +
                ", editor='" + editor + '\'' +
                ", availability=" + availability +
                '}';
    }
}