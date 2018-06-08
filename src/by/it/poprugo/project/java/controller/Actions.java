package by.it.poprugo.project.java.controller;

enum Actions {
    LISTAD {
        {
            this.command = new CmdListAd();
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
