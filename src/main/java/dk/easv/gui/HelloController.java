package dk.easv.gui;

import dk.easv.be.ToDoItem;
import dk.easv.be.UserItem;
import dk.easv.bll.ToDoLogic;
import dk.easv.bll.UserLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ComboBox cbbUsers;

    @FXML
    private ListView lstToDos;

    private ToDoLogic toDoLogic = new ToDoLogic();
    private UserLogic userLogic = new UserLogic();

    public HelloController() throws IOException {
    }

    public void onAddToDo(ActionEvent actionEvent)
    {

    }

    public void onChangeName(ActionEvent actionEvent) {

    }

    public void onDeleteToDo(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
               List<UserItem> users = null;
        try
        {
            users = userLogic.getAllUsers();
            for(UserItem ui : users)
            {
                cbbUsers.getItems().add(ui);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void onItemChanged(ActionEvent actionEvent)
    {
        lstToDos.getItems().clear();
         try {
             String s = cbbUsers.getSelectionModel().getSelectedItem().toString().split(":")[0];
            List<ToDoItem> items = toDoLogic.getListOfTodosByUser(Integer.parseInt(s));
            for(ToDoItem i : items)
            {
                lstToDos.getItems().add(i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
