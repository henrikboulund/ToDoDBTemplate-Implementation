package dk.easv.dal;

import dk.easv.be.ToDoItem;

import java.io.IOException;
import java.sql.*;
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
            String sql = "SELECT * FROM dbo.ToDos";
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
            throw new Exception("Could not get todos from database", ex);
        }
    }

    public ToDoItem getToDoById(int todoId)
    {
        try(Connection conn = dbConnector.getConnection())
        {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ToDos WHERE Id = ?");
            ps.setInt(1, todoId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                return new ToDoItem(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return null;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<ToDoItem> getToDoListByUser(int userId) throws Exception {
        ArrayList<ToDoItem> todos = new ArrayList<>();

        // try-with-resources
        try (Connection conn = dbConnector.getConnection())
        {
            PreparedStatement myStmt;
            myStmt = conn.prepareStatement("SELECT ToDoId FROM UserTodos WHERE UserId = ?");
            myStmt.setInt(1, userId);
            ResultSet rs = myStmt.executeQuery();

            // Loop through rows from the database result set
            while (rs.next())
            {
                ToDoItem todo = getToDoById(rs.getInt(1));
                todos.add(todo);
            }
            return todos;

        }
        catch (SQLException ex)
        {

            ex.printStackTrace();
            throw new Exception("Could not get todos from database", ex);
        }
    }
}
