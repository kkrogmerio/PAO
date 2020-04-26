package Departament;

public abstract class Departament{
    protected String nume;

    public Departament(String administration) {
        nume=administration;
    }

    public abstract String getNume();
    public abstract void setNume(String val);
}
