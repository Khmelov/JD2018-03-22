package by.it.uskoryaev.jd03_04.java;

public enum Action {
    INDEX {
        {
            this.command = new CmdIndex();
            this.jsp = "/index.jsp";
        }
    }, LOGIN {
        {
            this.command = new CmdLogin();
            this.jsp = "/login.jsp";
        }
    }, LOGOUT {
        {
            this.command = new CmdLogout();
            this.jsp = "/logout.jsp";
        }
    }, SIGNUP {
        {
            this.command = new CmdSingUP();
            this.jsp = "/signup.jsp";
        }
    }, ERROR {
        {
            this.command = new CmdError();
            this.jsp = "/login.jsp";
        }
    };

    String jsp = "/error.jsp";
    IActionCmd command;
}
