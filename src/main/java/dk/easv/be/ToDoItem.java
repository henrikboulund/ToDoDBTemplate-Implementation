package dk.easv.be;

public class ToDoItem
{
    private int Id;
    private String Title;
    private String Content;

    public ToDoItem(int id, String title, String content) {
        Id = id;
        Title = title;
        Content = content;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString()
    {
        return Title +"("+ Id +")";
    }
}
