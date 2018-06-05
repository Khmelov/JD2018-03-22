package by.it.verishko.project.java.controller;

public enum Actions {
    INDEX {
        {
            this.command = new CmdIndex();
        }
    }, LOGIN {
        {
            this.command = new CmdLogin();
        }
    }, PROFILE {
        {
            this.command = new CmdProfile();
        }
    }, SIGNUP {
        {
            this.command = new CmdSignup();
        }
    }, LISTGOODS {
        {
            this.command = new CmdListGoods();
        }
    }, CREATEPRODUCT {
        {
            this.command = new CmdCreateProduct();
        }
    }, LOGINPAGE {
        {
            this.command = new CmdLoginPage();
        }
    }, ERROR {
        {
            this.command = new CmdError();
        }
    };
    CmdAbstract command;
}

