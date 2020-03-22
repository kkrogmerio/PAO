import java.util.Objects;

public class Milka extends  CandyBox{int r,h;
    public Milka() {
    }
    double getVolume(){
        return r*r*3.14*h;
    }

    public Milka(int r, int h,String flav,String origin) {
        super(flav,origin);
        this.r = r;
        this.h = h;
    }
    int yem(){return 5;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Heidi milka = (Heidi) o;
        return yem()==((Heidi) o).yeah();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), r, h);
    }

    @Override
    public String toString(){

        return " has volume of "+this.getVolume()+super.toString();

    }
}
