package by.it.danilevich.project.java.controller;

enum Actions {
    LISTORDER {
        {
            this.command = new CmdListOrder();
        }
    },
    LISTEDITORDER {
        {
            this.command = new CmdListEditOrder();
        }
    },
    CREATEORDER {
        {
            this.command = new CmdCreateOrder();
        }
    },
    CREATEWORK {
        {
            this.command = new CmdCreateWork();
        }
    },
    CREATEUSER{
        {
            this.command = new CmdCreateUser();
        }
    },
    EDITWORK {
        {
            this.command = new CmdEditWork();
        }
    },
    INITBASE {
        {
            this.command = new CmdInitBase();
        }
    },

    EDITORDER {
        {
            this.command = new CmdEditOrder();
        }
    },
    LISTEDITUSER {
        {
            this.command = new CmdListEditUser();
        }
    },
    EDITUSER {
        {
            this.command = new CmdEditUser();
        }
    },
    LISTWORK {
        {
            this.command = new CmdListWork();
        }
    },
    LISTUSER {
        {
            this.command = new CmdListUser();
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
    PROFILE {
        {
            this.command = new CmdProfile();
        }
    },
    SIGNUP {
        {
            this.command = new CmdSignup();
        }
    },
    LISTEDITWORK {
        {
            this.command = new CmdListEditWork();
        }
    },

    ERROR {
        {
            this.command = new CmdError();
        }
    };

    Cmd command;

}
