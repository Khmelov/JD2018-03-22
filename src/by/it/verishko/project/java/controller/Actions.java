package by.it.verishko.project.java.controller;

public enum Actions {
    RESETDB {
        {
            this.command = new ResetDB();
        }
    },
    EDITUSERS {
        {
            this.command = new CmdEditUsers();
        }
    },
    EDITPRODUCT {
        {
            this.command = new CmdEditProduct();
        }
    },
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
    CREATEPRODUCT {
        {
            this.command = new CmdCreateProduct();
        }
    },
    ERROR {
        {
            this.command = new CmdError();
        }
    };
    Cmd command;
}

