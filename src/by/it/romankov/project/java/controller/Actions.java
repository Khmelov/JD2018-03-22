package by.it.romankov.project.java.controller;


import by.it.romankov.project.java.beans.Tours;

public enum Actions {
    LISTTOURS {
        {
            this.command = new CmdListTours();
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
