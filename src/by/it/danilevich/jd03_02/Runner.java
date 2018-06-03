package by.it.danilevich.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        TaskC.deleteDateBase();
        TaskC.createDateBase();
        TaskA.printRole("after create dataBase");
        //проверим CRUD для бина Role
        RoleBean roleBean = new RoleBean(-1,"Guest");
        RoleCRUD.create(roleBean);
        TaskA.printRole("after create");
        System.out.println(roleBean+"\n");
        roleBean.setName("testUserForDelete");
        RoleCRUD.update(roleBean);
        TaskA.printRole("after change");
        RoleCRUD.delete(roleBean);
        TaskA.printRole("after delete");
        System.out.println(RoleCRUD.read(1));

        //test User
        UserBean userBean = new UserBean(-1,"Guest",1,"Poland Warsaw","09-789-78","guest","111");
        UserCRUD.create(userBean);
        TaskA.printUser("after create");
        System.out.println(userBean+"\n");
        userBean.setName("testUserForDelete");
        UserCRUD.update(userBean);
        TaskA.printUser("after update");
        UserCRUD.delete(userBean);
        TaskA.printUser("after delete");
        System.out.println(UserCRUD.read(2));
        //test KindOfWork
        KindOfWorkBean kindOfWorkBean = new KindOfWorkBean(-1,"Change bath",12.5,3.5,"Water pipes","thing");
        KindOfWorkCRUD.create(kindOfWorkBean);
        TaskA.printKindOfWork("after create");
        System.out.println(kindOfWorkBean+"\n");
        kindOfWorkBean.setName("tesForDelete");
        KindOfWorkCRUD.update(kindOfWorkBean);
        TaskA.printKindOfWork("after update");
        KindOfWorkCRUD.delete(kindOfWorkBean);
        TaskA.printKindOfWork("after delete");
        System.out.println(KindOfWorkCRUD.read(3));
        //test Order
        OrderBean orderBean = new OrderBean(-1,3200,1,5,4,6,3200,3200,3200,1,8,5,"ready");
        OrderCRUD.create(orderBean);
        TaskA.printOrder("after create");
        System.out.println(orderBean+"\n");
        orderBean.setStatus("tesForDelete");
        OrderCRUD.update(orderBean);
        TaskA.printOrder("after update");
        OrderCRUD.delete(orderBean);
        TaskA.printOrder("after delete");
        System.out.println(OrderCRUD.read(1));


    }
}
