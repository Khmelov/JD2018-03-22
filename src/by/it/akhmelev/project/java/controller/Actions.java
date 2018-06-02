package by.it.akhmelev.project.java.controller;

enum Actions {
    INDEX {
        {
            this.command = new CmdIndex();
        }
    },
    LOGIN {
        {
            this.command = new CmdLogin();
        }
    },
    LOGOUT {
        {
            this.command = new CmdLogout();
        }
    },
    SIGNUP {
        {
            this.command = new CmdSignup();
        }
    },
    ERROR {
        {
            this.command = new CmdError();
        }
    };

    CmdAbstract command;

}
