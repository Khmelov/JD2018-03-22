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
    EDITINFO {
        {
            this.command = new CmdEditInfo();
        }
    },
    RESERVATIONS {
        {
            this.command = new CmdReservations();
        }
    },
    SEARCH {
        {
            this.command = new CmdSearch();
        }
    };

    String jsp = "/error.jsp";
    CmdAbstract command;

}
