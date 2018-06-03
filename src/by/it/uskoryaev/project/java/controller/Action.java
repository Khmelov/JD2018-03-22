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
<<<<<<< HEAD
            this.command = new CmdSignUp();
=======
            this.command = new CmdSingUp();
>>>>>>> origin/master
        }
    }, ERROR {
        {
            this.command = new CmdError();
        }
<<<<<<< HEAD
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
            this.command = new CmdDelete();
        }
    };

=======
    };
>>>>>>> origin/master
    AbstractCmd command;
}
