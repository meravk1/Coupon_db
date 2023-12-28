package lesson6;

import java.util.Base64;

public class Visitor extends Volunteer{
    public  enum States{
        single,
        married,
        widower
    }
    private  States state;

    public Visitor(States state) {
        this.state = state;
    }

    public Visitor(PersonalDetails p, boolean catches, int basisBonus, Days day, States state) {
        super(p, catches, basisBonus, day);
        this.state = state;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  super.toString()+ "Visitor{" +
                "state=" + state +
                '}';
    }

    @Override
    public int calcBonus() {
        if(state==States.single)
            return 7;
        else if(state==States.married)
            return 13;
        else
            return 22;
    }
}
