import java.util.Random;
public class NormalJob extends Jobs {
int amount;

    public NormalJob() {
        Random rand = new Random();
        this.amount = rand.nextInt(900) + 100;
    }

    @Override
    public void getinfo() {
        System.out.println("This class it's used to create a job for a healthy person");
    }

    @Override
    public int getid() {
        return hashCode();
    }
    @Override
    void getcalcul(Angajat x)
{
    String val= x.data.lvl;
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
}
}
