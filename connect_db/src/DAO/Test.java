package DAO;

import Entities.*;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args)throws SQLException,ClassNotFoundException {
       VolunteerDAO demo=new VolunteerDBDAO();
       PersonalDetails p1=new PersonalDetails(1452,30,"m","cohen");
       // Volunteer v1=new Visitor(p1,true,5, Days.Monday, Visitor.States.married);
       // Doctor d1=new Doctor(p1,true,4,Days.Monday,Degree.second);
       // demo.addVolunteer(v1);
        // DegreeDAO demo1=new DegreeDBDAO();
      //  demo.deleteVolunteer(5464);
       // demo.deletePersonalDetails(1457);
      //demo.updateVolunteer(v1);
    }
}
