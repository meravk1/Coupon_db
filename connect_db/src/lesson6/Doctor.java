package lesson6;

public class Doctor extends Volunteer{
    private Degree d;
    private int experience;
    public Doctor(PersonalDetails p, boolean catches, int basisBonus, Days day, Degree d) {
        super(p, catches, basisBonus, day);
        this.d = d;
    }
    @Override
    public String toString() {
        return super.toString()+"Doctor{" +
                "d=" + d +
                ", experience=" + experience +
                '}';
    }
    @Override
    public int calcBonus() {
        if(d==Degree.first)
        {
            if(experience>5)
                return 15000;
            else
                return 10000;
        }
        else if(d==Degree.second)
        {
            if(experience>5)
                return 20000;
            else
                return 15000;
        }
        else {
            if(experience>5)
                return 25000;
            else
                return 20000;
        }
    }

    public Degree getD() {
        return d;
    }

    public void setD(Degree d) {
        this.d = d;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
