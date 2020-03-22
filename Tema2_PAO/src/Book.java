public class Book {
    String title,author,publier;
    int pageCount;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publier='" + publier + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    public Book(String title, String author, String publier, int pageCount) {
        this.title = title;
        this.author = author;
        this.publier = publier;
        this.pageCount = pageCount;
    }

}
