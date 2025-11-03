package dk.easv.be;

import java.util.List;

public class UserItem
{
    private int Id;
    private String Username;
    private String Gender;
    private String Email;
    private List<ToDoItem> ToDos;

    public UserItem(int id, String username, String gender, String email)
    {
        Id = id;
        Username = username;
        Gender = gender;
        Email = email;
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username)
    {
        Username = username;
    }

    public String getGender()
    {
        return Gender;
    }

    public void setGender(String gender)
    {
        Gender = gender;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email)
    {
        Email = email;
    }

    public List<ToDoItem> getToDos() {
        return ToDos;
    }

    public void setToDos(List<ToDoItem> toDos) {
        ToDos = toDos;
    }

    @Override
    public String toString()
    {
        return Id + ": " + Username;
    }
}
