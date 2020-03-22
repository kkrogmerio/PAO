import java.util.Objects;

public class Heidi extends CandyBox {int l;
    public Heidi() {
    }
    double getVolume(){return Math.pow(l,3);}
    int yeah(){
        return 5;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Heidi heidi = (Heidi) o;
        return getVolume()==((Heidi) o).getVolume();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), l);
    }

    public Heidi(int l, String flav, String origin) {
        super(flav,origin);
        this.l = l;
    }
}
