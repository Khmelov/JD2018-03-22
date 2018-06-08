package by.it.romankov.project.java.controller;


public enum Actions {
    RESETDB {
        {
            this.command = new ResetDB();
        }
    },
    EDITPEOPLE {
        {
            this.command = new CmdEditPeople();
        }
    },
    LISTTOURS {
        {
            this.command = new ResetDB();
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


    CREATETOUR{
        {
        this.command = new CmdCreateTour();
    }
    },

    PROFILE{{
        this.command = new CmdProfile();
    }};

    CmdAbstract command;

}
