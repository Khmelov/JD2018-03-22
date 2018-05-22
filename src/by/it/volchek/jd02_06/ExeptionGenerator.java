package by.it.volchek.jd02_06;

/**
 * Created by volchek on 21.05.18.
 */
public class ExeptionGenerator {
     static Exeption generate(){
         int exeptionNumber = 4;
         int generationNumber = (int) (Math.random()*exeptionNumber+1);

         switch (generationNumber){
             case 1:
                 return new ArithmeticExeption();
             case 2:
                 return new ArithmeticExeption();
             case 3:
                 return new NullPointerExeption();
             case 4:
                 return new StringIndexOutOfBounds();
         }
         return null;
     }
}
