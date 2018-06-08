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
    EDITINFO {
        {
            this.command = new CmdEditInfo();
        }
    },
    SEARCH {
        {
            this.command = new CmdSearch();
        }
    };

    //todo убрать строку 72
    String jsp = "/error.jsp";
    Cmd command;

}
