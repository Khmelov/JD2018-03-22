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
            this.command = new CmdSignUp();

        }
    }, ERROR {
        {
            this.command = new CmdError();
        }
    }, ADDCAR {
        {
            this.command = new CmdAddCar();
        }
    }, CHOOSECAR {
        {
            this.command = new CmdChooseCar();
        }
    }, DELETE {
        {
            this.command = new CmdEditUsers();
        }
    },PROFILE{
        {
            this.command = new CmdProfile();
        }

    };
AbstractCmd command;
}
