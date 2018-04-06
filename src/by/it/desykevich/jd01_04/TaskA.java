package by.it.desykevich.jd01_04;

import by.it.desykevich.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {

    static void printMulTable(){
            for (int i = 2; i <10 ; i++) {
                for (int j = 2; j <10 ; j++) {
                    System.out.printf("%1d*%1d=%-3d",i,j,i*j);

                }
                System.out.println();

            }
        }

        static void buildOneDimArray(String line){

        double[] array=InOut.getArray(line);
            System.out.println("Не отсортированный массив");
            InOut.printArray(array,"V",5);
            double first=array[0];
            double last=array[array.length-1];
            Helper.sort(array);
            System.out.println("Массив отсортирован:");
            InOut.printArray(array,"V",4);
            System.out.println("Поиск нового индекса");


            for (int i = 0; i <array.length ; i++) {
                if (array[i]==first){
                    System.out.println("first element=10"+i);
                    break;
                }

            }
            for (int i = 0; i <array.length ; i++) {
                if (array[i]==last){
                    System.out.println("last element=2"+i);
                    break;
                }

            }

        }
        public static void main (String []args ){
        printMulTable();
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        buildOneDimArray(line);
        }


    }

