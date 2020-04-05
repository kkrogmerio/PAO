import java.util.List;

public class Angajat implements Company, Comparable<Angajat>{
 Nume name;
 Domiciliu adress;
 ReviewAngajat review;
 Date data;

    @Override
    public int compareTo(Angajat o) {
        return this.review.salariu-o.review.salariu;
    }

    @Override
   public void getinfo() {
       System.out.println("This class it's made to create an employee identity by structuring the base class 'Angajat' with" +
               "classes 'Nume' , 'Domiciliu','ReviewAngajat','Date' which contain informations about the worker");
   }

   @Override
   public int getid() {
      return hashCode();
   }

   public Angajat(Nume name, Domiciliu adress, ReviewAngajat review, Date data) {
      this.name = name;
      this.adress = adress;
      this.review = review;
      this.data = data;
      this.data.experience();
   }
}
