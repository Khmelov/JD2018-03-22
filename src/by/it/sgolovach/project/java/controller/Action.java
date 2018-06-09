package by.it.sgolovach.project.java.controller;

enum Action {
    INDEX{
        {
            this.comand=new CmdIndex();
        }
    },
    LOGIN{
        {
            this.comand=new CmdLogin();
        }
    },
    PROFILE{
        {
            this.comand=new CmdProfile();
        }
    },
    SIGNUP{
        {
            this.comand=new CmdSignup();
        }
    },
    ERROR{
        {
            this.comand=new CmdError();
        }
    },
    PAGELOG{
        {
            this.comand=new CmdPagelog();
        }
    },
    CREATEAD{
        {
            this.comand=new CmdCreateAd();
        }
    },
    LISTAD{
        {
            this.comand=new CmdListad();
        }
    },
    EDITUSERS{
        {
            this.comand=new CmdEditUsers();
        }
    },
    EDITPROFILE{
        {
            this.comand=new CmdEditProfile();
        }
    },
    EDITUSERSAD{
        {
            this.comand=new CmdEditUsersAd();
        }
    };


    CmdAbstract comand;

}
