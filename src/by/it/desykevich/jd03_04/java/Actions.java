package by.it.desykevich.jd03_04.java;

public enum Actions {

    INDEX{
        {
            this.command=new CmdIndex();
            this.jsp="/index.jsp";
        }
    },LOGIN{
        {
            this.command=new CmdLogin();
            this.jsp="/login.jsp";
        }
    },LOGOUT{
        {
            this.command=new CmdLogout();
            this.jsp="/logout.jsp";
        }
    },SIGNUP {
        {
            this.command = new CmdSignup();
            this.jsp = "/signup.jsp";
        }
    },ERROR{        {
        this.command=new CmdError();
        this.jsp="/error.jsp";
    }};

    public String jsp="/error.jsp";
    ActionCmd command;

}
