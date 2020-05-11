package Departament;

public abstract class Departament{
    protected String nume;
    static int id;
    protected int myId;
    public Departament(String administration) {
        id+=1;
        myId=id;
        nume=administration;

    }

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public abstract String getNume();
    public abstract void setNume(String val);
}
