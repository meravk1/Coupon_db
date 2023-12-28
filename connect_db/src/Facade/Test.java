package Facade;

import Entities.Days;
import Entities.PersonalDetails;
import Entities.Visitor;
import Entities.Volunteer;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdminFacade adminFacade = new AdminFacade();
        PersonalDetails p1 = new PersonalDetails(10,20,"merav","kugman");
        Volunteer v1 = new Visitor(p1,true,15, Days.Monday, Visitor.States.married,"12","admin@gmail.com");
        //Volunteer v=new Visitor()
        //adminFacade.printBonus();
        //adminFacade.addVolunteer(v1);
        //adminFacade.deleteVolunteer(2);
        //System.out.println(adminFacade.getOneVolunteer(0));
        VolunteerFacade volunteerFacade = new VolunteerFacade();
        volunteerFacade.login("merav","3254");
        volunteerFacade.myBonus();
    }
}
