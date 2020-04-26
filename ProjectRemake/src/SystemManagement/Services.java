package SystemManagement;

import CsvFiles.ReadWrite;
import Departament.Departament;
import Departament.DepartamentHr;
import Departament.DepartamentIt;
import Departament.DepartamentShip;
import Departament.DepartamentAdmin;
import DetaliiAngajat.*;
import DetaliiAngajat.Date;
import Job.Jobs;
import Job.NormalJob;
import Job.SpecialJob;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class Services {static Vector<Departament[]> depart=new Vector<Departament[]>();
    static Vector<Jobs> jobs=new Vector<Jobs>();
    static Vector<Angajat> employees=new Vector<Angajat>();
    private DepartamentIt departament_it[]=new DepartamentIt[]{};
    private DepartamentAdmin department_admin[]=new DepartamentAdmin[]{};
    private DepartamentHr department_hr[]=new DepartamentHr[]{};
    private DepartamentShip department_ship[]=new DepartamentShip[]{};
    public static Vector<Departament[]> getDepart() {
        return depart;
    }

    public static void setDepart(Vector<Departament[]> depart) {
        Services.depart = depart;
    }

    public static Vector<Jobs> getJobs() {
        return jobs;
    }

    public static void setJobs(Vector<Jobs> jobs) {
        Services.jobs = jobs;
    }

    public static Vector<Angajat> getEmployees() {
        return employees;
    }

    public static void setEmployees(Vector<Angajat> employees) {
        Services.employees = employees;
    }

    static void init_depart(){
        DepartamentIt department_it[]={new DepartamentIt("IT HelpDesk"),new DepartamentIt("IT Support"),new DepartamentIt("IT Apps Development"),new DepartamentIt("IT Bigdata-Center And Research")};
        DepartamentAdmin department_admin[]={new DepartamentAdmin("Administration")};
        DepartamentHr department_hr[]={new DepartamentHr("Labor Relations")};
        DepartamentShip department_ship[]={new DepartamentShip("Shipping")};
        depart.add((department_it));
        depart.add(department_admin);
        depart.add(department_hr);
        depart.add(department_ship);
        try {
            FileWriter fileWriter = new FileWriter("./src/FileResources/History.csv", true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileWriter.append("Initializing departments");
            fileWriter.append(",");
            fileWriter.append(String.valueOf(timestamp));
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    static void init_jobs(){
        jobs.add(new NormalJob());
        jobs.add(new SpecialJob(150,200));
        jobs.add(new SpecialJob(300,400));
        try {
            FileWriter fileWriter = new FileWriter("./src/FileResources/History.csv", true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileWriter.append("Initializing jobs");
            fileWriter.append(",");
            fileWriter.append(String.valueOf(timestamp));
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    static void init_employee(){
        Scanner scanner = new Scanner(System.in);
        int raspuns=1;
        while(raspuns!=0) {

            Random rand = new Random();
            Angajat employee = null;
            try {

                System.out.println("Implement Date(an,luna,zi)");
                Date date = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                System.out.println("Implement Domiciliu(adresa,numar)");
                Domiciliu domiciliu = new Domiciliu(new String(scanner.next()), scanner.nextInt());
                System.out.println("Implement Nume(nume,prenume,CNP)");
                Nume nume = new Nume(new String(scanner.next()), new String(scanner.next()), scanner.nextLong());
                System.out.println("Implement ReviewAngajat(Job,Work Overtime,Study(0-Graduate 1-MsD 2-PhD))");
                System.out.println("<<<<<<<<<INFOS>>>>>>>>>");
                System.out.println("JOBS: Software_engineer,Deliver,Administrator,Recruiter");
                System.out.println("THE COMPANY LOOKS FORWARD EMPLOYEES WITH THIS STUDIES:");
                System.out.println("Software_engineer:0 or 1");
                System.out.println("Administrator:1");
                System.out.println("Recruiter:1");
                System.out.println("Deliver:0");
                ReviewAngajat review = new ReviewAngajat(new String(scanner.next()), scanner.nextInt(), scanner.nextInt());
                employee = new Angajat(nume, domiciliu, review, date);

                update(employee);
                jobs.get(rand.nextInt(jobs.size())).getcalcul(employee);
                employees.add(employee);
                Collections.sort(employees);
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Eroare in introducerea datelor de intrare");
                e.printStackTrace();
            } finally {
                assert employee != null;
                System.out.println("A-ti introdus urmatoarele date:  " + employee.toString());
            }
            System.out.println("Do you want to add another employee? 1-Yes 0-No");
            raspuns=scanner.nextInt();
        }
        try {
            FileWriter fileWriter = new FileWriter("./src/FileResources/History.csv", true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileWriter.append("Initializing new employees");
            fileWriter.append(",");
            fileWriter.append(String.valueOf(timestamp));
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private static void well(){
        System.out.println("The informations inside the tabels: ");
        for(Angajat x:employees){
            System.out.println(x.toString());
        }
    }
    static void extractFileData(List<List<String>>angaj,List<List<String>>depar,List<List<String>>jobul)
    {   List<List<String>>ang=new ArrayList<>(angaj);
        List<List<String>>dep=new ArrayList<>(depar);
        List<List<String>>job=new ArrayList<>(jobul);
        ang.remove(0);
        dep.remove(0);
        job.remove(0);
        for(int i=0;i<ang.size();++i){
          //  System.out.println(ang.size());
           List<String> newObjectAng=ang.get(i);
            String[]adresa=newObjectAng.get(3).split(" ");
          //  System.out.println(adresa[0]+" "+adresa[1]);
           String[]data=newObjectAng.get(4).split("/");
           // System.out.println(data[0]+" "+data[1]+" "+data[2]);
            List<String> newObjectDep=dep.get(i);
            List<String> newObjectJob=job.get(i);
            Date date=new Date(Integer.valueOf(data[2]),Integer.valueOf(data[1]),Integer.valueOf(data[0]));
            Domiciliu domiciliu=new Domiciliu(adresa[0],Integer.valueOf(adresa[1]));
            Nume nume=new Nume(newObjectAng.get(1),newObjectAng.get(2),Long.valueOf(newObjectAng.get(0)));
            ReviewAngajat reviewAngajat=new ReviewAngajat(newObjectJob.get(0),Integer.valueOf(newObjectAng.get(7)),Integer.valueOf(newObjectAng.get(8)));
            Angajat employee=new Angajat(nume, domiciliu, reviewAngajat, date);
            employee.getReview().setSalariu(Integer.valueOf(newObjectAng.get(9)));
            System.out.println(employee.toString());
            update(employee);
            employees.add(employee);
            Collections.sort(employees);

        }
        well();
    }
    static void application(ReadWrite<List<String>> readWrite)
    {
        init_jobs();
        init_depart();

        Scanner scanner=new Scanner(System.in);
        int x=1;
        while(x!=0) {
            System.out.println("Introduce command:1-Initialization of an employee 2-Introduce data in file,3-Extract data from file to program,4-Show productive employees,5-Promote Someone(Only for software engineers),0-Exit");

            x=scanner.nextInt();
            if(x==1)
                init_employee();
            if(x==2)
                introduceData(readWrite);
            if(x==3)
                extractFileData(readWrite.getValuesAng(), readWrite.getValuesDep(), readWrite.getValuesJobs());
            if(x==4)
                goodEmployees();
            if(x==5)
            {
                System.out.println("Introduce an employee ID to raise in hierarchy: ");
                int val=scanner.nextInt();
                Angajat ang = employees.stream().filter(obj -> obj.getName().getid() == val).findFirst().orElse(null);
                String beforeUpgrade=ang.getReview().getPosition();
                update(ang);
                System.out.println("The employee changed subdepartment from "+beforeUpgrade+" to    "+ang.getReview().getPosition());
            }

        }
        scanner.close();
    }
    static void introduceData(ReadWrite<List<String>> readWrite){
        List<List<String>> angajati=new ArrayList<>();
        List<List<String>> departments=new ArrayList<>();
        List<List<String>> jobs=new ArrayList<>();

        String whichDepart=null;
        String departCateg=null;
        int id=0;
        int okey=1;
        Scanner scanner = new Scanner(System.in);
        while(okey==1) {
            System.out.println("Introduce Employee id to insert the data in tabels:\n");

            id=scanner.nextInt();

            int finalId = id;
            Angajat ang = employees.stream().filter(obj -> obj.getName().getid() == finalId).findFirst().orElse(null);
            if (ang == null)
                System.out.println("The element which you want to introduce is invalid\n");
            else {
                //We want to find category of our subdepartment
                whichDepart = ang.getReview().getPosition();
                System.out.println(ang.toString());
                DepartamentIt d = (DepartamentIt) depart.get(0)[0];
                System.out.println(d.getNume()+" "+whichDepart);
                for (Departament ds : depart.get(0)) {
                    if (ds.getNume().equals(whichDepart)) {
                        departCateg = ds.getClass().getName();
                       // System.out.println(departCateg);
                    }
                }
                for (Departament ds : depart.get(1)) {
                    if (ds.getNume().equals(whichDepart)) {
                        departCateg = ds.getClass().getName();
                       // System.out.println(departCateg);
                    }
                }
                for (Departament ds : depart.get(2)) {
                    if (ds.getNume().equals(whichDepart)) {
                        departCateg = ds.getClass().getName();
                        //System.out.println(departCateg);
                    }
                }
                for (Departament ds : depart.get(3)) {
                    if (ds.getNume().equals(whichDepart)) {
                        departCateg = ds.getClass().getName();
                       // System.out.println(departCateg);
                    }
                }
                List<String> listAng = Arrays.asList(String.valueOf(ang.getName().getid()), ang.getName().getNume(), ang.getName().getPrenume(),
                        ang.getAdress().getAdresa() +" "+ String.valueOf(ang.getAdress().getNumar()), ang.getData().showDate(),
                        String.valueOf(ang.getData().getExp()), ang.getData().getLvl(),String.valueOf(ang.getReview().getWovertime()),String.valueOf(ang.getReview().getBs()),String.valueOf(ang.getReview().getSalariu()));
                List<String> listDep = Arrays.asList(departCateg, whichDepart);
                List<String> listJob = Arrays.asList(ang.getReview().getJob(), ang.getReview().getJobType());
                angajati.add(listAng);
                departments.add(listDep);
                jobs.add(listJob);
                System.out.println("Do you want to insert more data into tables? 1-YES 0-NO \n");
                okey=scanner.nextInt();
            }
        }




        readWrite.write(angajati,departments,jobs);


    }
    static void update(Angajat x){          //This function is for initializing new employees , or promoting the existing ones
        if(x.getReview().getPosition()==null)
        {

            if(x.getReview().getBs()==0 && x.getReview().getJob().equals("Software_engineer")){

                x.getReview().setPosition(depart.get(0)[0].getNume());
            }
            else if(x.getReview().getBs()==1&&x.getReview().getJob().equals("Software_engineer"))
                x.getReview().setPosition(depart.get(0)[1].getNume());
            else if(x.getReview().getBs()==1&&x.getReview().getJob().equals("Administrator"))
                x.getReview().setPosition(depart.get(1)[0].getNume());
            else if(x.getReview().getBs()==1&&x.getReview().getJob().equals("Recruiter"))
                x.getReview().setPosition(depart.get(2)[0].getNume());
            else if(x.getReview().getBs()==0&&x.getReview().getJob().equals("Deliver"))
                x.getReview().setPosition(depart.get(3)[0].getNume());
            x.getReview().setReview((float) (x.getReview().getReview()+1.0));
        }
        //Pentru a lucra in alte departamente , trebuie sa fii lucrat deja in una dintre ele (pozitia!=null)
        else if(x.getReview().getPosition()==depart.get(0)[0].getNume())
        {
            if(x.getReview().getBs()==0 && x.getReview().getJob().equals("Software_engineer")) //Redundant sa zici getJob().equals()Software engineer , avand in vdr upgrade de la o fct pe it
                x.getReview().setPosition(depart.get(0)[1].getNume());
            else if(x.getReview().getBs()==1&&x.getReview().getJob().equals("Software_engineer"))
                x.getReview().setPosition(depart.get(0)[2].getNume());
            x.getReview().setReview((float) (x.getReview().getReview()+2.0));
        }
        else if(x.getReview().getPosition()==depart.get(0)[1].getNume())
        {
            if(x.getReview().getBs()==1 && x.getReview().getJob().equals("Software_engineer")) //Redundant sa zici getJob().equals()Software engineer , avand in vdr upgrade de la o fct pe it
                x.getReview().setPosition(depart.get(0)[2].getNume());
            else if(x.getReview().getBs()==2&&x.getReview().getJob().equals("Software_engineer")) {
                System.out.println(depart.get(0)[3].getNume());
                x.getReview().setPosition(depart.get(0)[3].getNume());
            }
            x.getReview().setReview((float) (x.getReview().getReview()+3.0));
        }
        x.getReview().setReview( (x.getReview().getReview()+x.getReview().getWovertime()));
    }
    static void goodEmployees()  {
        System.out.println("Employees with high points of productivity (Review>15)");
        for(int i=0;i<employees.size();++i){

            if(employees.get(i).getReview().getReview()>15.0)
                System.out.println(employees.get(i).getName().getNume()+" "+employees.get(i).getName().getPrenume()+" review: "+employees.get(i).getReview().getReview());
        }
        try {
            FileWriter fileWriter = new FileWriter("./src/FileResources/History.csv", true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileWriter.append("Check Employees");
            fileWriter.append(",");
            fileWriter.append(String.valueOf(timestamp));
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
