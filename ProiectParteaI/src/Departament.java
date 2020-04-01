public abstract class Departament extends Departments{
    /*String department_it[]={"IT HelpDesk","IT Support","IT Apps Development","IT Bigdata-Center And Research"};
    String department_admin[]={"Administration"}
    String department_hr[]={"Labor Relations,"};
    String department_ship[]={"Shipping"}*/
    String nume;
    abstract String getNume();
    @Override
    public void nod_connect(Angajat x) {

    }
    /*static void update(ReviewAngajat x){
        if(x.position==null)
        {
            if(x.bs==0 && x.job=="Software engineer")
                x.setPosition(this.department_it[0]);
            else if(x.bs==1&&x.job=="Software engineer")
                x.setPosition(this.department_it[1]);
            else if(x.bs==1&&x.job=="Administrator")
                x.setPosition(this.department_admin[0]);
            else if(x.bs==1&&x.job=="Recruiter")
                x.setPosition(this.department_hr[0]);
            else if(x.bs==1&&x.job=="Deliver")
                x.setPosition(this.department_ship[0]);
            x.review+=0.1;
        }
        else if(x.position==this.department_it[0])
        {
            if(x.bs==0 && x.job=="Software engineer") //Redundant sa zici job==Software engineer , avand in vdr upgrade de la o fct pe it
                x.setPosition(this.department_it[1]);
            else if(x.bs==1&&x.job=="Software engineer")
                x.setPosition(this.department_it[2]);
            x.review+=0.2;
        }
        else if(x.position==this.department_it[1])
        {
            if(x.bs==1 && x.job=="Software engineer") //Redundant sa zici job==Software engineer , avand in vdr upgrade de la o fct pe it
                x.setPosition(this.department_it[2]);
            else if(x.bs==2&&x.job=="Software engineer")
                x.setPosition(this.department_it[3]);
            x.review+=0.3;
        }
    }*/
}
