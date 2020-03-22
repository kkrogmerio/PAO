import java.util.Arrays;

public class Indexare {
    Book books[];
    private final int nrCarti;
    private int index;
    public Indexare(int nrCarti) {
        this.nrCarti = nrCarti;
        this.books=new Book[nrCarti];
    }
    void add(Book carte){
        if(index<nrCarti){
            books[index]=carte;
            System.out.println("A fost introdusa cartea la indexuL: "+index++);
        }
        else{
            System.out.println("overflow");
        }
    }
    void downcast(Book Harry){
        if(Arrays.asList(this.books).contains(Harry))
            System.out.println("continuam");
        else
            return;
        try{
            Harry=(Actiune)Harry;
            System.out.println("Actiune");

        }
        catch (Exception e){
            System.out.println("Comedie");
        }
    }


}
