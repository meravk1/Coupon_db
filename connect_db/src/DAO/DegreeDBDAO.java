package DAO;

import Entities.Degree;

import java.sql.SQLException;
import java.util.ArrayList;

public class DegreeDBDAO implements DegreeDAO{
    @Override
    public void addDegree(String degree) throws SQLException {
//        String sql = "INSERT INTO degree (degree)"+ "VALUES"+
//                "('"+ degree.+ "','";
        //degree.(this.cp.runInsertQuerry(sql));???
    }

    @Override
    public void deleteDegree(int id) throws SQLException {
    // cp.runDeleteQuerry("delete from volunteer where id="+id);
    }

    //@Override
    public void updatevolunteer(VolunteerDAO v) throws SQLException {

    }

    @Override
    public ArrayList<Degree> getAllVolunteer() throws SQLException {
        return null;
    }

    @Override
    public Degree getDegreeChar(char c) throws SQLException {
        return null;
    }
}
