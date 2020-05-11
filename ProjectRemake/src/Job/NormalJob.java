package Job;

import DetaliiAngajat.Angajat;

import java.util.Random;
public class NormalJob extends Jobs {
int amount;

    public NormalJob() {
        super("normal");
        Random rand = new Random();
        this.amount = rand.nextInt(900) + 100;

    }

    @Override
    public String toString() {
        return "NormalJob{" +
                "amount=" + amount +
                ", myId=" + myId +
                '}';
    }

    @Override
    public void getinfo() {
        System.out.println("This class it's used to create a job for a healthy person");
    }
    @Override
    public int getid() {
        return myId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void getcalcul(Angajat x)
{
    x.getReview().setJobType("Normal");
    String val= x.getData().getLvl();
    System.out.println(val);
    if(val.equals("Junior"))
        x.getReview().setSalariu(x.getReview().getSalariu()+3000);
    else if(val.equals("Middle"))
        x.getReview().setSalariu(x.getReview().getSalariu()+5000);
    else if(val.equals("Senior"))
        x.getReview().setSalariu(x.getReview().getSalariu()+8000);
    x.getReview().setSalariu((int)(x.getReview().getSalariu()*(1+(float)x.getData().getExp()/10)));
    if(x.getReview().getBs()==1) {
        x.getReview().setSalariu((int) (x.getReview().getSalariu()*1.10));
        x.getReview().setReward((float) (x.getReview().getReward()+1.10));
    }
    if((x.getReview().getBs()==2)){
        x.getReview().setSalariu((int) (x.getReview().getSalariu()*1.20));
        x.getReview().setReward((float) (x.getReview().getReward()+1.20));
    }
    x.getReview().setSalariu(x.getReview().getSalariu()+amount);
    x.getReview().setReward(x.getReview().getReward()+this.amount/100);
}
}
