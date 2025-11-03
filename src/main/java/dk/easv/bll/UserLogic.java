package dk.easv.bll;

import dk.easv.be.UserItem;
import dk.easv.dal.UserDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserLogic
{
    private List<UserItem> UsersList;
    private UserDAO userData = new UserDAO();

    public UserLogic() throws IOException {
        UsersList = new ArrayList<>();
    }

    public List<UserItem> getAllUsers() throws Exception
    {
        UsersList = userData.getAllUsers();
        return UsersList;
    }
}
