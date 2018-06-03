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
    LOGOUT{
        {
            this.comand=new CmdLogout();
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
    };


    CmdAbstract comand;

}
