import Entities.Days;
import Entities.Degree;
import Entities.Doctor;
import Entities.PersonalDetails;

import java.sql.*;

public class DB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String DOMAIN_STRING = "localhost";//127.0.0.1
        final String DB_NAME = "volunteer_db";
        final String USER_NAME = "root";
        final String PASSWORD = "123456";
        final String CONNECTION_STRING = "jdbc:mysql://" + DOMAIN_STRING + "/"
                + DB_NAME + "?user=" + USER_NAME + "&password=" + PASSWORD;
        System.out.println(CONNECTION_STRING);

        // יוצרת מופע של הדרייבר המתאים לחיבור למסד נתונים
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connection to database: " + CONNECTION_STRING + " done successfully");
        // אובייקט שמתאר התקשרות למסד הנתונים
        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        System.out.println("....");
        System.out.println("Connected to database " + DB_NAME);
        //עם אובייקט זה מפעילים פעולות של SQL
        Statement statement = connection.createStatement();
        //statement.execute("insert into eday  values (1,'Sunday')");
        //statement.execute("insert into edegree  values (1,'first')");
        //statement.execute("insert into eday  values (2,'first')");
        //statement.execute("delete from eday where id=2");

        PersonalDetails p = new PersonalDetails(12345678, 50, "Shira", "Choen");
        Doctor d = new Doctor(p, false, 0, Days.Sunday, Degree.doctorate);
//        String sql="insert into eday   values (" + Days.Tuesday.ordinal() + ",'"+ Days.Tuesday.name() + "')";
//        //   statement.execute(sql);
//        System.out.println(sql);
        PreparedStatement statement1 = connection.prepareStatement("insert into volunteer values (?,?,?,?)");
        statement1.setInt(1,d.getP().getId());
        //statement1.setInt(1,Integer.parseInt(d.getP().getId()));//במידה והת.ז. במחרוזת אז צריך להמיר
        statement1.setBoolean(2,d.isCatches());
        statement1.setInt(3,d.getBasisBonus());
        statement1.setString(4,d.getP().getFamily());

        statement1.execute();
        ResultSet rs = statement.executeQuery("select * from eday");
        while (rs.next())
        {
            System.out.printf(rs.getString("id")+" "+rs.getString("day"));
        }
        statement.close();
        connection.close();

    }
}
