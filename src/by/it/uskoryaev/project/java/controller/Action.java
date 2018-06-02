package by.it.uskoryaev.project.java.controller;


public enum Action {
    INDEX {
        {
            this.command = new CmdIndex();
        }
    }, LOGIN {
        {
            this.command = new CmdLogin();
        }
    }, LOGOUT {
        {
            this.command = new CmdLogout();
        }
    }, SIGNUP {
        {
            this.command = new CmdSingUp();
        }
    }, ERROR {
        {
            this.command = new CmdError();
        }
    };
    AbstractCmd command;
}
