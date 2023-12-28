package DAO;

import Entities.Doctor;
import Entities.Visitor;
import Entities.Volunteer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VolunteerDAO {
   void addVolunteer(Volunteer volunteer) throws SQLException;
   void deleteVolunteer(int id_volunteer)throws SQLException;
   void deletePersonalDetails(int id_Personal)throws SQLException;
   void updateVolunteer(Volunteer volunteer)throws SQLException;
   ArrayList<Volunteer> getAllVolunteer()throws SQLException;
   Volunteer getOneVolunteer(int id_volunteer)throws SQLException;
   ArrayList<Visitor> getAllVisitor()throws SQLException;
   ArrayList<Doctor> getAllDoctor()throws SQLException;
   ArrayList<Volunteer> getVolunteerAge(double age)throws SQLException;
   ArrayList<Volunteer> getAllVolunteerBonus()throws SQLException;

}
