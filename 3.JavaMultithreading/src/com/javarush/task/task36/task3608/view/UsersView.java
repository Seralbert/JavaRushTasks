package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Zver on 31.08.2017.
 */
public class UsersView implements View {
    private Controller controller;


    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        boolean isDeleted = modelData.isDisplayDeletedUserList();
        if(!isDeleted)
            System.out.println("All users:");
        else System.out.println("All deleted users:");

        for (User u : modelData.getUsers()) {
             System.out.println("\t" + u.toString());
        }
        System.out.println("===================================================");


    }
    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
