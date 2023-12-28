package lesson6;

import Entities.*;

public class Main {
    public static void main(String[] args) {


        PersonalDetails p1 = new PersonalDetails(123, 50, "dfgd", "ggd");
        Doctor d1 = new Doctor(p1, false, 0, Days.Sunday, Degree.doctorate);
        PersonalDetails p2 = new PersonalDetails(12345, 55, "dfg", "gd");
        Doctor d2 = new Doctor(p2, true, 3, Days.Sunday, Degree.first);
        System.out.println(d1.toString());
        Visitor v1=new Visitor(new PersonalDetails(453,45,"Dan","Levi"),true,34,Days.Friday, Visitor.States.married);
        Visitor v2=new Visitor(p1,true,5,Days.Monday, Visitor.States.married);
        System.out.println(v2.calcBonus());
       Visitor.States[] status= Visitor.States.values();
        for (int i = 0; i < status.length; i++) {
            System.out.println(status[i].name()+" "+status[i].ordinal());
        }
         Volunteer arrayV[]=new Volunteer[4];
         arrayV[0]=d1;
         arrayV[1]=v1;
        arrayV[2]=d2;
        arrayV[3]=v2;

        // פולימורפיזים
        for (Volunteer  vol: arrayV) {
            System.out.print(vol+"  ");
            System.out.println(vol.calcBonus());

        }


//        VolColletion volColletion=new VolColletion();
//        volColletion.AddVolunteer(d1);
//        volColletion.AddVolunteer(d2);
//        volColletion.AddVolunteer(v1);
//        volColletion.AddVolunteer(v2);
//
//
//        Volunteer volunteerFind = volColletion.Search(1, 20, Days.Friday);
//
//        System.out.println(volunteerFind!=null?volunteerFind:"no find");
//
//        Volunteer volunteerFind1 = volColletion.Search(1, 20, Days.Friday);
//
//        System.out.println(volunteerFind1!=null?volunteerFind1:"no find");
//
//        System.out.println( v1.compareTo(v2)>0?"v1 is big":v1.compareTo(v2)==0 ?"v1 equals to v2":"v2 is big" );
//
//         volColletion.PrintSort();

    }
}
