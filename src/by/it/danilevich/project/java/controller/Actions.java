package by.it.danilevich.project.java.controller;

enum Actions {
    LISTORDER {
        {
            this.command = new CmdListOrder();
        }
    },
    CREATEORDER {
        {
            this.command = new CmdCreateOrder();
        }
    },
    CREATEWORK {
        {
            this.command = new CmdCreateWork();
        }
    },
    LISTWORK {
        {
            this.command = new CmdListWork();
        }
    },
    LISTUSER {
        {
            this.command = new CmdListUser();
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
