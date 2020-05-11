package Job;

import DetaliiAngajat.Angajat;
import DetaliiAngajat.Company;

public abstract class Jobs extends Company {
    int myId=0;
    static int id;
    public String identify;
    public abstract void getcalcul(Angajat x);
    public Jobs(String identity){
        identify=identity;
        id+=1;
        myId=id;
    }

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }


}
