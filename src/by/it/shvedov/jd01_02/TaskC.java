package by.it.shvedov.jd01_02;

public class TaskC {
    public static void main(String[] args) {
 int massiv [][] = new int [10][10];
 int i, j;
 for(i=0;i<=10;i++){
     for(j=0; j<=10; j++){
         massiv [i][j] = ((int) (Math.random() * 40))-20 ;
     }
 }
 step2(massiv);
    }
    private static void step2(int [][] massiv ){
       int i, j, sum;
        for(i=0;i<=10;i++){
            for(j=0; j<=10; j++){
                if (massiv[i][j]>0 && massiv[i+1][j]>0){
                    sum=massiv[i][j]+massiv[i+1][j];

                    System.out.println(sum);
                }
            }

        }


    }


}

