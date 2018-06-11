package by.it.desykevich.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public  abstract class CmdAbstract {

     abstract  CmdAbstract execute(HttpServletRequest reg) throws Exception;

     @Override
     public String toString() {
          return this.getClass().getSimpleName()
                  .replaceFirst("Cmd", "");
     }




     public String getJsp(){
          return "/"+this.toString().toLowerCase()+".jsp";
     }
}
