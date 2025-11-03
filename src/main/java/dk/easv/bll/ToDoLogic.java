package dk.easv.bll;

import dk.easv.be.ToDoItem;
import dk.easv.dal.ToDoDAO;

import java.io.IOException;
import java.util.List;

public class ToDoLogic
{
    private ToDoDAO toDoData = new ToDoDAO();

    public ToDoLogic() throws IOException {
    }

    public List<ToDoItem> getToDoItems() throws Exception
    {
        return toDoData.getAllToDos();
    }

    public List<ToDoItem> getListOfTodosByUser(int userId) throws Exception
    {
        return toDoData.getToDoListByUser(userId);
    }
}
