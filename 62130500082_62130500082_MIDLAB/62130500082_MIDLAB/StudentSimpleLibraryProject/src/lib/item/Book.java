package lib.item;
public class Book  extends Item{
    
    private String ISBN;
    private String publisher;

    public Book(String ISBN, String publisher, String barcode, String title) {
        super(barcode, title);
        this.ISBN = ISBN;
        this.publisher = publisher;
    }

    
}
