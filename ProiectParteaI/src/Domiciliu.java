public class Domiciliu implements Company {
    protected String adresa;
    protected int numar;
    @Override
    public int getid() {
        return numar;
    }

    public Domiciliu(String adresa, int numar) {
        this.adresa = adresa;
        this.numar = numar;
    }
    @Override
    public void getinfo() {
        System.out.println("In Clasa domiciliu retinem adresa Angajatului");
    }

    void specific() {
        if (adresa == "Matei Spiru")
            System.out.println("Aproape de locul de munca");
    }
}
