package by.it.desykevich.jd03_01;

public class Runner {

    public static void main(String[] args) {
        C_Reset.resetDB();
        C_Init.initDB();
        B_AddRoles.addRoles();
        A_AddUser.addUser();
        A_Add_Data.addData();
        B_ShowUsers.showUsers();
    }
}
