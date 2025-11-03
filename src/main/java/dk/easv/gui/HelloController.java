package dk.easv.gui;

import dk.easv.bll.ToDoLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ComboBox cbbUsers;

    @FXML
    private ListView lstToDos;

    private ToDoLogic toDoLogic = new ToDoLogic();

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

    }
}
