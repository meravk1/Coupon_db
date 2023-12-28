package Facade;

import DAO.VolunteerDAO;
import DAO.VolunteerDBDAO;

import java.sql.SQLException;

public abstract class ClientFacade {

    protected VolunteerDAO volunteerDAO = new VolunteerDBDAO();

    protected ClientFacade() throws SQLException, ClassNotFoundException {
    }
    public abstract boolean login(String username, String password) throws SQLException;
}
