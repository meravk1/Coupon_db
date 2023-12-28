package Facade;

import Entities.Volunteer;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminFacade extends ClientFacade{
    //  ConnectionPool cp=ConnectionPool.getInstance();

    protected AdminFacade() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean login(String username, String password) {
        return username.equals("Admin") && password.equals("admin@admin.com");
    }

    void addVolunteer(Volunteer v) throws SQLException {
        ResultSet resultSet=cp.runGetQuery("select password,days from volunteer");
        String newPassword=v.getPassword();
        int newDay= v.getDay().ordinal();
        int cnt=0;
        while (resultSet.next())
        {
            String password=resultSet.getString("password");
            if(newPassword.equalsIgnoreCase(password))
            {
                System.out.println("You exist in the system");
                return;
            }
            int day= resultSet.getInt("days");
            if(day==newDay)
                cnt++;
        }
        if(cnt>10)
        {
            System.out.println("This day is too busy");
            return;
        }
        volunteerDAO.addVolunteer(v);
    }
    //work good
    void deleteVolunteer( int deleteId) throws SQLException {
        ResultSet resultSet=cp.runGetQuery("select id_personal from volunteer");
        while (resultSet.next())
        {
            int id= resultSet.getInt("id_personal");
            if(deleteId==id)
            {
                volunteerDAO.deleteVolunteer(deleteId);
                return;
            }
        }
        System.out.println("Not found");
    }


    //
    Volunteer getOneVolunteer(int id_volunteer) throws SQLException {
        return volunteerDAO.getOneVolunteer(id_volunteer);
    }


    //work good
    void printBonus() throws SQLException {
        ResultSet resultSet=cp.runGetQuery("select *from volunteer");
        while (resultSet.next())
        {
            System.out.println(Integer.parseInt(resultSet.getString("basic_bonus")));
        }
    }
}
