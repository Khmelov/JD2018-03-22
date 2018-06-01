package by.it.danilevich.jd03_03.dao;

import by.it.danilevich.jd03_03.beans.KindOfWorkBean;
import by.it.danilevich.jd03_03.beans.OrderBean;
import by.it.danilevich.jd03_03.beans.RoleBean;
import by.it.danilevich.jd03_03.beans.UserBean;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getInstance();
        System.out.println(dao.roleDao.getAll(""));
        System.out.println(dao.userDao.getAll(""));
        System.out.println(dao.kindOfWorkDao.getAll(""));
        System.out.println(dao.orderDao.getAll(""));

        System.out.println(dao.roleDao.read(1));
        System.out.println(dao.userDao.read(1));
        System.out.println(dao.kindOfWorkDao.read(1));
        System.out.println(dao.orderDao.read(1));


        String nameRole = "guest2";
        UserBean userBean = new UserBean(-1,"Guest",1,"Poland Warsaw","09-789-78","guest","111");
        KindOfWorkBean kindOfWorkBean = new KindOfWorkBean(-1,"Change bath",12.5,3.5,"Water pipes","thing") ;
        OrderBean orderBean =  new OrderBean(-1,3200,1,5,4,6,3200,3200,3200,1,8,5,"ready");

        //in role unique name, check it
        RoleBean roleBean;
        List<RoleBean> roleBeans = dao.roleDao.getAll("where `name`= '"+nameRole+"'");
        if (roleBeans.size()>0){
            roleBean = roleBeans.get(0);
        }
        else {
            roleBean = new RoleBean(-1,nameRole);

        }
        System.out.println(dao.roleDao.create(roleBean));
        System.out.println(dao.userDao.create(userBean));
        System.out.println(dao.kindOfWorkDao.create(kindOfWorkBean));
        System.out.println(dao.orderDao.create(orderBean));

        roleBean.setName("director");
        dao.roleDao.update(roleBean);
        System.out.println(roleBean);
        System.out.println(dao.roleDao.getAll(""));

        userBean.setName("Mister X");
        dao.userDao.update(userBean);
        System.out.println(userBean);
        System.out.println(dao.userDao.getAll(""));

        kindOfWorkBean.setPrice(1000);
        dao.kindOfWorkDao.update(kindOfWorkBean);
        System.out.println(dao.kindOfWorkDao.getAll(""));

        orderBean.setStatus("waiting");
        dao.orderDao.update(orderBean);
        System.out.println(orderBean);
        System.out.println(dao.orderDao.getAll(""));

        dao.roleDao.delete(roleBean);
        dao.userDao.delete(userBean);
        dao.kindOfWorkDao.delete(kindOfWorkBean);
        dao.orderDao.delete(orderBean);

        System.out.println(dao.roleDao.getAll(""));
        System.out.println(dao.userDao.getAll(""));
        System.out.println(dao.kindOfWorkDao.getAll(""));
        System.out.println(dao.orderDao.getAll(""));


    }
}
