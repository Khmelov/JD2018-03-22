package by.it.sgolovach.jd03_04.java;

enum Action {
    INDEX{
        {
            this.comand=new CmdIndex();
            this.jsp="/index.jsp";
        }
    },
    LOGIN{
        {
            this.comand=new CmdLogin();
            this.jsp="/login.jsp";
        }
    },
    LOGOUT{
        {
            this.comand=new CmdLogout();
            this.jsp="/logout.jsp";
        }
    },
    SIGNUP{
        {
            this.comand=new CmdSignup();
            this.jsp="/signup.jsp";
        }
    },
    ERROR{
        {
            this.comand=new CmdError();
            this.jsp="/error.jsp";
        }
    };

    String jsp="/error.jsp";
    ActionComand comand;

}
