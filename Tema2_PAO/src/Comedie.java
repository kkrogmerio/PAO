public class Comedie extends Book{String ras;

    @Override
    public String toString() {
        return "Comedie{" +
                "s='" + ras + '\'' +
                '}';
    }

    public Comedie(String title, String author, String publier, int pageCount) {
        super(title, author, publier, pageCount);
    }

    public Comedie(String ras, String titlu, String autor, String publi, int pag) {
        super(titlu,autor,publi,pag);
        this.ras = ras;
    }
    void getras(){
        System.out.println("haha");
    }
}
