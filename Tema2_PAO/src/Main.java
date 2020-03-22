import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);

        String ras=scan.next();
        String author=scan.next();
        String publier=scan.next();
        String title=scan.next();
        int pageCount=scan.nextInt();
        if(pageCount<=0)
            System.out.println("nui bn coae");
        Comedie book=new Comedie(ras,author,publier,title,pageCount);

        String atac=scan.next();
        author=scan.next();
        publier=scan.next();
        title=scan.next();
        pageCount=scan.nextInt();
        if(pageCount<=0)
            System.out.println("nui bn coae");
        Actiune book2=new Actiune(atac,author,publier,title,pageCount);
        System.out.println(BookStoreCheck.dubluEx(book.author,book2.author,book.publier,book2.publier));
        System.out.println(BookStoreCheck.grosime(book.pageCount,book2.pageCount));
        Indexare index=new Indexare(4);
        index.add(book);
        index.add(book2);
        index.downcast(book2);
    }
}
