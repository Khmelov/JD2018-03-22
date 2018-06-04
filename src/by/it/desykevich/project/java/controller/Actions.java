package by.it.desykevich.project.java.controller;



public enum Actions {

    INDEX{
        {
            this.command=new CmdIndex();

        }
    },LOGIN{
        {
            this.command=new CmdLogin();

        }
    },LOGOUT{
        {
            this.command=new CmdLogout();

        }
    },SIGNUP {
        {
            this.command = new CmdSignup();

        }
    },ERROR{        {
        this.command=new CmdError();

    }
    },CREATEAD{        {
        this.command=new CmdCreateAd();

    }},MYADS {
        {
            this.command = new CmdMyAds();
        }
    },
    EDITUSERS {
        {
            this.command = new CmdEditUsers();
        }
    },CREATECATEGORY {
        {
            this.command = new CmdCreateCategory();
        }
    },
    EDITCATEGORY {
        {
            this.command = new CmdEditCategory();
        }
    };


    CmdAbstract command;

}
