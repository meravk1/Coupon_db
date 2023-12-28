package Facade;

import Entities.Volunteer;
import dbManager.ConnectionPool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VolunteerFacade extends ClientFacade{
    // ConnectionPool cp=ConnectionPool.getInstance();
    private int volunteerId;

    protected VolunteerFacade() throws SQLException, ClassNotFoundException {
    }

    public int getVolunteer(){return volunteerId;
    }

    @Override
    public boolean login(String username, String password) throws SQLException {
       // volunteerDAO.
        ResultSet resultSet = cp.runGetQuery("select * from volunteer inner join person_details");
        String name = resultSet.getString("name");
        String pass = resultSet.getString("password");
        while (resultSet.next())
        {
            if(name == username && password == pass)
                return true;
        }
        return false;
    }

    public void update(Volunteer v) throws SQLException {
        volunteerDAO.updateVolunteer(v);
    }

    public void myBonus() throws SQLException {
        ResultSet resultSet = cp.runGetQuery("select * from volunteer");
        while (resultSet.next())
        {
            int id=resultSet.getInt("id_personal");
            if(volunteerId == id)
            {
                System.out.println(resultSet.getInt("basic_bonus"));
                return;
            }
        }
        System.out.println("Not found");
    }
}
