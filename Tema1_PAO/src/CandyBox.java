import java.util.Objects;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }




    public int hashCode() {
        return Objects.hash(flavor, origin);
    }

    public CandyBox() {
    }
    double getVolume(){
        return 0;
    }

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavor='" + flavor + '\'' +
                ", origin='" + origin + '\'' +
                "  ";
    }
}
