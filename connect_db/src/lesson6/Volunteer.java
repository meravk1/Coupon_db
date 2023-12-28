package lesson6;

import jdk.jshell.Snippet;

public abstract class Volunteer implements  Comparable<Volunteer> {
   private   PersonalDetails p;
   private boolean catches;
   private int basisBonus;
   private  Days day;

    @Override
    public String toString() {
        return "Volunteer{" +
                "p=" + p +
                ", catches=" + catches +
                ", basisBonus=" + basisBonus +
                ", day=" + day +
                '}';
    }

    public Volunteer() {
    }

    public Volunteer(PersonalDetails p, boolean catches, int basisBonus, Days day) {
        this.p = p;
        this.catches = catches;
        this.basisBonus = basisBonus;
        this.day = day;
    }

    public PersonalDetails getP() {
        return p;
    }

    public void setP(PersonalDetails p) {
        this.p = p;
    }

    public boolean isCatches() {
        return catches;
    }

    public void setCatches(boolean catches) {
        this.catches = catches;
    }

    public int getBasisBonus() {
        return basisBonus;
    }

    public void setBasisBonus(int basisBonus) {
        this.basisBonus = basisBonus;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }
    public abstract int calcBonus();

    @Override
    public int compareTo(Volunteer v) {
        return (int) (this.getP().getAge() - v.getP().getAge());
    }
}
