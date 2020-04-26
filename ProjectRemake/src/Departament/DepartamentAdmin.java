package Departament;

public class DepartamentAdmin extends Departament{


    public DepartamentAdmin(String administration) {
        super(administration);
    }

    @Override
    public String getNume() {
        return super.nume;
    }

    @Override
    public void setNume(String val) {
        super.nume=nume;
    }
}
