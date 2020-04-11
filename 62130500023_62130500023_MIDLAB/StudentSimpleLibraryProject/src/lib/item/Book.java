package lib.item;
public class Book extends Item {
    private String ISBN, publisher;
    
    public Book(String barcode, String title, String ISBN, String publisher){
        super(barcode, title);
        this.ISBN = ISBN;
        this.publisher = publisher;
    }
}