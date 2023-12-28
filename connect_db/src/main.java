import lesson6.Days;
import lesson6.Degree;
import lesson6.Doctor;
import lesson6.PersonalDetails;

import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final String DOMAIN_STRING="localhost";//127.0.0.1
        final String DB_NAME="volunteer_db";
        final String USER_NAME="root";
        final String PASSWORD="123456";
        final String CONNECTION_STRING="jdbc:mysql://" + DOMAIN_STRING + "/"
                + DB_NAME + "?user=" + USER_NAME + "&password=" + PASSWORD;
        System.out.println(CONNECTION_STRING);
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println ("Connection to database: " + CONNECTION_STRING+" done successfully");
        // אובייקט שמתאר את ההתקשרות למסד נתונים
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        System.out.println("....");
        System.out.println("Connected to database " + DB_NAME);

        Statement statement=connection.createStatement();
        statement.execute("insert into eday values (3,'Monday')");
        ResultSet rs=statement.executeQuery("select * from eday");
        while (rs.next())
        {
            System.out.println(rs.getString("id")+" "+rs.getString("day"));
        }

        PersonalDetails p = new PersonalDetails(1234, 20, "dfgd", "ggd");
        Doctor d = new Doctor(p, false, 0, Days.Sunday, Degree.doctorate);
        String sql="insert into eday   values (" + Days.Monday.ordinal() + ",'"+ Days.Monday.name() + "')";
        System.out.println(sql);
        // מכין שאילתא לביצוע
//        PreparedStatement statement1 = connection.prepareStatement("insert into volunteer values (?,?,?,?)");
//        statement1.setInt(1,Integer.parseInt(d1.getP().getId()));
//        statement1.setBoolean(2,d1.isCatches());
//        statement1.setInt(3,d1.getBasisBonus());
//        statement1.setString(4,d1.getP().getFamily());
//
//        ResultSet rs = statement.executeQuery("select * from eday");
//        statement1.execute();
//        statement.close();
//        connection.close();
    }
}
