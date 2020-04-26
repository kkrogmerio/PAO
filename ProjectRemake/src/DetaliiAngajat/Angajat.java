package DetaliiAngajat;

public class Angajat extends Company implements Comparable<Angajat>{
 private Nume name;
 private Domiciliu adress;
 private ReviewAngajat review;
 private Date data;

    @Override
    public int compareTo(Angajat o) {
        return this.getReview().getSalariu()-o.getReview().getSalariu();
    }

    @Override
   public void getinfo() {
       System.out.println("This class it's made to create an employee identity by structuring the base class 'DetaliiAngajat.Angajat' with" +
               "classes 'DetaliiAngajat.Nume' , 'DetaliiAngajat.Domiciliu','DetaliiAngajat.ReviewAngajat','DetaliiAngajat.Date' which contain informations about the worker");
   }

    @Override
    public String toString() {
        return "Angajat{" +
                "name=" + name.toString() +
                ", adress=" + adress.toString() +
                ", review=" + review.toString() +
                ", data=" + data.toString() +
                '}';
    }

    @Override
   public int getid() {
      return hashCode();
   }

    public Nume getName() {
        return name;
    }

    public void setName(Nume name) {
        this.name = name;
    }

    public Domiciliu getAdress() {
        return adress;
    }

    public void setAdress(Domiciliu adress) {
        this.adress = adress;
    }

    public ReviewAngajat getReview() {
        return review;
    }

    public void setReview(ReviewAngajat review) {
        this.review = review;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Angajat(Nume name, Domiciliu adress, ReviewAngajat review, Date data) {
      this.name = name;
      this.adress = adress;
      this.review = review;
      this.data = data;
      this.data.experience();
   }
}
