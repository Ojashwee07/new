class Book1 {
    String title;
    String author;
  public Book1(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public static void main(String[] args) {
        Book1 myBook = new Book1("To Kill a Mockingbird", "Harper Lee");
        System.out.println("Title: " + myBook.getTitle());
        System.out.println("Author: " + myBook.getAuthor());
    }
}