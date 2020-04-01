import java.sql.SQLOutput;
import java.util.*;
public class Main {
    static Vector<Departament[]> depart=new Vector<Departament[]>();
    static Vector<Jobs> jobs=new Vector<Jobs>();
    static Vector<Angajat> employees=new Vector<Angajat>();
    static void init_depart(){
   department_it department_it[]={new department_it("IT HelpDesk"),new department_it("IT Support"),new department_it("IT Apps Development"),new department_it("IT Bigdata-Center And Research")};
   department_admin department_admin[]={new department_admin("Administration")};
   department_hr department_hr[]={new department_hr("Labor Relations")};
   department_ship department_ship[]={new department_ship("Shipping")};
    depart.add((department_it));
    depart.add(department_admin);
    depart.add(department_hr);
    depart.add(department_ship);
    }
    static void init_jobs(){
        jobs.add(new NormalJob());
        jobs.add(new SpecialJob(150,200));
        jobs.add(new SpecialJob(300,400));
    }
    static void init_employee(){
        Random rand = new Random();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Implement Date(an,luna,zi)");
        Date date=new Date(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        System.out.println("Implement Domiciliu(adresa,numar)");
        Domiciliu domiciliu=new Domiciliu(new String(scanner.next()),scanner.nextInt());
        System.out.println("Implement Nume(nume,prenume,CNP,seria)");
        Nume nume=new Nume(new String(scanner.next()), new String(scanner.next()),scanner.nextLong(),scanner.next());
        System.out.println("Implement Review(Job,Work Overtime,Study)");
        ReviewAngajat review=new ReviewAngajat(new String(scanner.next()),scanner.nextInt(),scanner.nextInt());
        Angajat employee=new Angajat(nume,domiciliu,review,date);
        update(employee);
        jobs.get(rand.nextInt(jobs.size())).getcalcul(employee);
        employees.add(employee);

    }
    static void update(Angajat x){
    if(x.review.position==null)
    {
        if(x.review.bs==0 && x.review.job=="Software_engineer") {
            x.review.setPosition(depart.get(0)[0].getNume());
        }
        else if(x.review.bs==1&&x.review.job=="Software_engineer")
            x.review.setPosition(depart.get(0)[1].getNume());
        else if(x.review.bs==1&&x.review.job=="Administrator")
            x.review.setPosition(depart.get(1)[0].getNume());
        else if(x.review.bs==1&&x.review.job=="Recruiter")
            x.review.setPosition(depart.get(2)[0].getNume());
        else if(x.review.bs==1&&x.review.job=="Deliver")
            x.review.setPosition(depart.get(3)[0].getNume());
        x.review.review+=1.0;
    }
    else if(x.review.position==depart.get(0)[0].getNume())
    {
        if(x.review.bs==0 && x.review.job=="Software_engineer") //Redundant sa zici job==Software engineer , avand in vdr upgrade de la o fct pe it
            x.review.setPosition(depart.get(0)[1].getNume());
        else if(x.review.bs==1&&x.review.job=="Software_engineer")
            x.review.setPosition(depart.get(0)[2].getNume());
        x.review.review+=2.0;
    }
    else if(x.review.position==depart.get(0)[1].getNume())
    {
        if(x.review.bs==1 && x.review.job=="Software_engineer") //Redundant sa zici job==Software engineer , avand in vdr upgrade de la o fct pe it
            x.review.setPosition(depart.get(0)[2].getNume());
        else if(x.review.bs==2&&x.review.job=="Software_engineer")
            x.review.setPosition(depart.get(0)[3].getNume());
        x.review.review+=3.0;
    }
    x.review.review+=x.review.wovertime;
    }
    static void test(){
        for(int i=0;i<employees.size();++i){
            System.out.println(employees.get(i).review.review+" "+employees.get(i).review.reward);
            if(employees.get(i).review.review>2.3)
                System.out.println("Good employee "+employees.get(i).name.nume+" "+employees.get(i).name.prenume);
        }
    }
    public static void main(String[] args) {
        init_jobs();
        init_depart();
        init_employee();
        init_employee();
        test();
    }

}
