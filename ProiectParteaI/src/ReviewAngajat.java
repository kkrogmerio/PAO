public class ReviewAngajat  {
    String job;
    int bs,wovertime,special,salariu; //Bs0-Undergraduate/Bs1-Graduated/Bs2-Ms (master in CS) /wovertime-Numarul de ore suplimentare muncite pe luna pentru a dobandi experienta
    float review=1.0f,reward=1.0f;
    String position;

    public ReviewAngajat(String job, int wovertime,int bs) {
        this.job = job;
        this.wovertime = wovertime;
        this.bs=bs;

        //Departament.update(this);
    }
    void setPosition(String position)
    {
        this.position=position;
    }
    void specific(){
        if(review/reward>1.0)
            System.out.println("Undervalued employee");
        else if (review/reward==1.0)
            System.out.println("Correct valued employee");
        else
            System.out.println("Overvalued employee");
    }

}
