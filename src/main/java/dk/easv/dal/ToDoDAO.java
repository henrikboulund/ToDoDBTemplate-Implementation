package dk.easv.dal;

import dk.easv.be.ToDoItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO
{
    private DBConnector dbConnector = new DBConnector();

    public ToDoDAO() throws IOException {}

    public List<ToDoItem> getAllToDos() throws Exception
    {
        ArrayList<ToDoItem> allToDos = new ArrayList<>();

        // try-with-resources
        try (Connection conn = dbConnector.getConnection();
             Statement stmt = conn.createStatement())
        {
            String sql = "SELECT * FROM dbo.Movie";
            ResultSet rs = stmt.executeQuery(sql);

            // Loop through rows from the database result set
            while (rs.next()) {

                //Map DB row to Movie object
                int id = rs.getInt("Id");
                String title = rs.getString("Title");
                String content = rs.getString("Content");

                ToDoItem todo = new ToDoItem(id, title, content);
                allToDos.add(todo);
            }
            return allToDos;

        }


        catch (SQLException ex)
        {

            ex.printStackTrace();
            throw new Exception("Could not get movies from database", ex);
        }
    }
}
