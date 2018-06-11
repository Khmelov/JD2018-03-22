package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;
import by.it.danilevich.project.java.dao.connect.ConnectionCreator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CmdInitBase extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
         Dao.deleteDateBase();
         Dao.createDateBase();

        return Actions.LOGIN.command;
    }

}
