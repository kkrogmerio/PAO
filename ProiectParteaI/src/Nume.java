public class Nume implements Company{
    String nume,prenume,seria;
    private long CNP;
    @Override
    public int getid(){return (int)CNP%1000;}
    @Override
    public void getinfo(){
        System.out.println("Name identifier");
    }

    public Nume(String nume, String prenume, long CNP, String seria) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.seria = seria;
    }

    boolean director(){
        if (CNP%1000==570 && nume=="Andreescu" && prenume=="Mihai")
            return true;
        return false;
    }
    long getCNP(){return CNP;}
    public String getSeria(){String val=new String(seria);
        return val;}
    void specific(){
        if (this.getSeria()=="IZ")
            System.out.println("Are domiciliul aproape de HQ");
    }

}
