package DAO;

import Entities.Doctor;
import Entities.PersonalDetails;
import Entities.Visitor;
import Entities.Volunteer;
import dbManager.ConnectionPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VolunteerDBDAO implements VolunteerDAO{


    ConnectionPool cp = ConnectionPool.getInstance();

    public VolunteerDBDAO() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void addVolunteer(Volunteer volunteer) throws SQLException {          //V
        String sqlPersonal= "INSERT INTO personal_details (id,name,age)"+"VALUES"+
                "("+volunteer.getP().getId()+
                ", '"+volunteer.getP().getName()+
                "', "+volunteer.getP().getAge()+")";
        int newId = this.cp.runInsertQuery(sqlPersonal);
        String sql =null;
        if (volunteer instanceof  Doctor) {
             sql = "INSERT INTO volunteer (id,is_free,basis_Bonus,day,status,experience_year,degree,d_type)" + "VALUES" +
                    "(" + newId +
                   // "'," + volunteer.getP()+
                    ", " + volunteer.isCatches() +
                    ", " + volunteer.getBasisBonus() +
                     " ,"+ (volunteer.getDay().ordinal()+1) +
                    ", " + (((Doctor)volunteer).getD().ordinal()+1)+
                     ", "+((Doctor) volunteer).getExperience()+
                     ", "+(((Doctor)volunteer).getD().ordinal()+1)+
            ", 'DOCTOR')   ";
        }
        else {
            sql = "INSERT INTO volunteer (id,is_free,basis_bonus,day,status,d_type)" + "VALUES" +
                    "(" + newId +
                    ", " + volunteer.isCatches() +
                    ", " + volunteer.getBasisBonus() +
                    ", " + (volunteer.getDay().ordinal()+1) +
                    ", " + (((Visitor)volunteer).getState().ordinal()+1) +
                    ", 'VISITOR')";
        }
         this.cp.runInsertQuery(sql);
    }


    @Override
    public void deleteVolunteer(int id_volunteer) throws SQLException {       //V
        cp.runDeleteQuerry("delete from volunteer where id="+id_volunteer);
    }
    @Override
    public void deletePersonalDetails(int id_Personal) throws SQLException {       //V
        cp.runDeleteQuerry("delete from personal_details where id="+id_Personal);
    }
    @Override
    public void updateVolunteer(Volunteer volunteer) throws SQLException {
    cp.runUpdateQuerry("update volunteer set id_personal="+volunteer.getP().getId()+",free="+volunteer.isCatches()+",bonus="+volunteer.getBasisBonus()+",day"+volunteer.getDay());
    }

    @Override
    public ArrayList<Volunteer> getAllVolunteer() throws SQLException {
        ArrayList<Volunteer> arr=new ArrayList<>();
        ResultSet resultSet=cp.runGetQuery("select * from volunteer");
        while (resultSet.next())
        {
            Volunteer vol=null;
            String d_type=resultSet.getString("d_type");
            if(d_type.equals("Visitor"))
                vol=new Visitor();
            else
                vol=new Doctor();
            PersonalDetails p=new PersonalDetails();
            p.setId(resultSet.getInt(4));
            vol.setP(p);
            vol.setCatches(resultSet.getBoolean(2));
            vol.setBasisBonus(resultSet.getInt((3)));
          //  vol.setDay(resultSet.getInt(2));
            arr.add(vol);
        }
        return arr;
    }

    @Override
    public Volunteer getOneVolunteer(int id_volunteer) throws SQLException {
        String sql = "select* from volunteer where id=" +id_volunteer;
        Volunteer volunteer=null;// = new Volunteer() ;
        ResultSet resultSet = this.cp.runGetQuery(sql);
        //יש פונקציה אבסטרקטית במחלקת מתנדב
        while (resultSet.next()) {
            String type = resultSet.getString("type");
            if(type.equals("Doctor"))
            volunteer= new Doctor();

            System.out.println("///");
           // volunteer = getOneVolunteer(resultSet);
        }
        return volunteer;
    }

    @Override
    public ArrayList<Visitor> getAllVisitor() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Doctor> getAllDoctor() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Volunteer> getVolunteerAge(double age) throws SQLException {
        String sql = "select* from volunteer where age>" +age;
      //  Volunteer volunteer = new Volunteer() ;
        ResultSet resultSet = this.cp.runGetQuery(sql);
        while (resultSet.next())
        {

        }
        return null;
    }

    @Override
    public ArrayList<Volunteer> getAllVolunteerBonus() throws SQLException {
        return null;
    }
}