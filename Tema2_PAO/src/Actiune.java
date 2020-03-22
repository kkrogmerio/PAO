public class Actiune extends Book{String atac;

    @Override
    public String toString() {
        return "Actiune{" +
                "atac='" + atac + '\'' +
                '}';
    }

    public Actiune(String atac,String titlu,String autor,String publi,int pag) {
        super(titlu,autor,publi,pag);
        this.atac = atac;
    }

    public Actiune(String title, String author, String publier, int pageCount) {
        super(title, author, publier, pageCount);
    }

    void getatac(){
        System.out.println("get serious");
    }
}
