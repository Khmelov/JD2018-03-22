package by.it.kirova.project.java.controller;


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
    SIGNUP {
        {
            this.command = new CmdSignup();

        }
    },
    ERROR {
        {
            this.command = new CmdError();

        }
    },
    MYACCOUNT {
        {
            this.command = new CmdMyAccount();
        }
    },
    MYRESERVATIONS {
        {
            this.command = new CmdMyReservations();
        }
    },
    MYPROPERTY {
        {
            this.command = new CmdMyProperty();
        }
    },
    EDITMYPROPERTY {
        {
            this.command = new CmdEditMyProperty();
        }
    },
    SEARCH {
        {
            this.command = new CmdSearch();
        }
    },
    ADMIN {
        {
            this.command = new CmdAdmin();
        }
    };

    Cmd command;

}
