import java.util.Random;

public class SpecialJob extends Jobs{
    int workcond,disability,amount;
    public int getid(){
    return 0;
    }
    public SpecialJob(int workcond, int disability) {
        this.workcond = workcond;
        this.disability = disability;
        Random rand = new Random();
        this.amount = rand.nextInt(900)+100;
    }
    @Override
    public void getinfo(){
        System.out.println("This is a class to create jobs for ppl with disabilities");
    }
    void getcalcul(Angajat x)
    {
        String val=x.data.lvl;
        if(val=="junior")
            x.review.salariu+=3000;
        else if(val=="middle")
            x.review.salariu+=5000;
        else if(val=="Senior")
            x.review.salariu+=8000;
        x.review.salariu+=x.review.salariu*(x.data.exp*5)/10;
        if(x.review.bs==1) {
            x.review.salariu *= 1.10;
            x.review.reward += 0.10;
        }
        if((x.review.bs==2)){
            x.review.salariu *= 1.20;
            x.review.reward += 0.20;
        }
        x.review.salariu+=amount;
        x.review.reward+=this.amount/100;
        x.review.salariu+=disability;
        x.review.salariu+=workcond;
    }
}
