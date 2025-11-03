package dk.easv.dal;

import dk.easv.be.ToDoItem;
import dk.easv.be.UserItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO
{
    private DBConnector dbConnector = new DBConnector();

    public UserDAO() throws IOException {}

    public List<UserItem> getAllUsers() throws Exception
    {
        ArrayList<UserItem> allUsers = new ArrayList<>();

        // try-with-resources
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement())
        {
            String sql = "SELECT * FROM dbo.Users";
            ResultSet rs = stmt.executeQuery(sql);

            // Loop through rows from the database result set
            while (rs.next()) {

                //Map DB row to Movie object
                int id = rs.getInt("Id");
                String username = rs.getString("Username");
                String gender = rs.getString("Gender");
                String email = rs.getString("Email");

                UserItem user = new UserItem(id, username, gender, email);
                allUsers.add(user);
            }
            return allUsers;

        }


        catch (SQLException ex)
        {

            ex.printStackTrace();
            throw new Exception("Could not get movies from database", ex);
        }
    }
}
