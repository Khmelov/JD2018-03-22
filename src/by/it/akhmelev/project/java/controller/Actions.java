package by.it.akhmelev.project.java.controller;

enum Actions {
    RESETDB {
        {
            this.command = new ResetDB();
        }
    },
    CREATEAD {
        {
            this.command = new CmdCreateAd();
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
