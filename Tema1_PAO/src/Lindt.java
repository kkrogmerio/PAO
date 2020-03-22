public class Lindt extends CandyBox{int L,l,h;
    public Lindt() {
    }
    double getVolume(){
        return L*l*h;
    }

    public Lindt(int l, int l1, int h,String flav,String origin) {
        super(flav,origin);
        L = l;
        this.l = l1;
        this.h = h;
    }
    @Override
    public String toString(){
        super.toString();
        return " has volume of "+this.getVolume();
    }
}
