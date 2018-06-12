package by.it.poprugo.project.java.controller;

enum Actions {
    RESETDB {
        {
            this.command = new ResetDB();
        }
    },
    CREATEMODEL {
        {
            this.command = new CmdCreateModel();
        }
    },
    INDEX {
        {
            this.command = new CmdIndex();
        }
    },
    EDITUSERS {
        {
            this.command = new CmdEditUsers();
        }
    },
    LOGIN {
        {
            this.command = new CmdLogin();
        }
    },
    PROFILE {
        {
            this.command = new CmdProfile();
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

    Cmd command;

}
