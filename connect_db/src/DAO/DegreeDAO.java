package DAO;

import Entities.Degree;
import Entities.Person;
import Entities.Volunteer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DegreeDAO {
    void addDegree(String degree) throws SQLException;
    void  deleteDegree(int id) throws SQLException;
    //void  updatevolunteer(VolunteerDAO v) throws SQLException;
    ArrayList<Degree> getAllVolunteer()throws SQLException;
    Degree getDegreeChar(char c)throws SQLException;
}
