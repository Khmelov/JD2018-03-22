package by.it.kovko.jd01_05;

import java.util.Arrays;
import java.util.Random;


public class TaskC {
    public static void main(String[] args) {
        double xMin=5.33, xMax=9;
        int n=28, columns=5;
        double min=10, max=150;
        int rows=18;
        double arr[] = randomVector(min,max,rows);
        String format="M[%d]=%.2f";
        printInColumns(arr,format,columns);
        printInRows(arr,format,columns);
        step1(xMin,xMax,n,columns);
        int aMin=103, aMax=450, elements=31;
        step1(aMin,aMax,elements);
    }
    private static double[] randomVector(double min, double max, int rows){
        double randomVector[] = new double[rows];
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            randomVector[i]=min+Math.abs(max-min)*r.nextDouble();
        }
        return randomVector;
    }

    private static void step1(double xMin, double xMax, int n, int columns){
        double xStep=(xMax-xMin)/n, x=xMin;
        double array[] = new double [n];
        System.out.println("Массив A[]");
        for (int i = 0; i < n; i++, x+=xStep) {
            array[i]=Math.cbrt(x*x+4.5);
            System.out.printf("%s[ %-2d]=%f  ","A",i,array[i]);
            if ((i+1)%columns==0)
                System.out.println();
        }
        System.out.println();
        int newArrayLength=n;
        double newArray[];
        for (double a : array) {
            if (a<3.5)
                --newArrayLength;
            else
                break;
        }
        newArray = new double [newArrayLength];
        double geometricMean=1;
        for (int i = newArrayLength-1, j=n-1; i >=0 ; i--, j--){
            newArray[i]=array[j];
            geometricMean*=newArray[i];
        }
        System.out.println("Массив B[] из элементов A>3.5");
        geometricMean=Math.pow(geometricMean,1.0/newArrayLength);
        for (int i = 0; i < newArray.length; i++) {
            System.out.printf("%s[ %-2d]=%7.5f  ","B",i,newArray[i]);
            if ((i+1)%columns==0)
                System.out.println();
        }
        System.out.printf("\nGeometric mean: %.5f\n", geometricMean);
    }
    private static void step1(int min, int max, int n){
        double array[]=new double[n];
        Random r = new Random();
        int range=(max-min)+1;
        for (int i = 0; i < array.length; i++){
            array[i]=(double)Math.round(min+r.nextInt(range));
            System.out.println(array[i]);
        }
        int newArrayLength=0;
        double tempArray[] = new double[n];
        for (int i = 0; i < array.length; i++) {
            if (array[i]>i*10){
                tempArray[newArrayLength]=array[i];
                ++newArrayLength;
            }
        }
        double newArray[] = new double[newArrayLength];
        System.arraycopy(tempArray,0,newArray,0,newArrayLength);
        System.out.println(Arrays.toString(newArray));
    }

    private static void printInRows(double array[], String format, int columns){

        //int columnLength=String.format(format,1,array[0]).length();
        int columnLength=0, stringLength;
        for (int i = 0; i < array.length; i++) {
            stringLength=String.format(format,i,array[i]).length();
            columnLength=(columnLength<stringLength)?stringLength:columnLength;
        }

        int realColumns=(array.length>columns?columns:array.length%columns);
        int bottomColumns=(array.length-1)%realColumns+1;
        char topLeftCorner=0x2554, topRightCorner=0x2557, topDivisor=0x2566;
        char midLeft=0x2560, midRight=0x2563, midDivisor=0x256C;
        char bottomLeftCorner=0x255A, bottomRightCorner=0x255D, bottomDivisor=0x2569;
        char horizontalPlank=0x2550,vertivalPlank=0x2551;

        String columnFormat=String.format("%"+(columnLength+2)+"s"," ").replace(' ',horizontalPlank)+topDivisor;
        String headerFormat=String.format("%"+realColumns+"s"," ").replaceAll(" ",columnFormat);
        headerFormat=topLeftCorner+headerFormat.substring(0,headerFormat.length()-1)+topRightCorner;
        String midFormat=headerFormat.replace(topLeftCorner,midLeft).replace(topDivisor,midDivisor).replace(topRightCorner,midRight);
        String bottomFormat=String.format("%"+(bottomColumns)+"s"," ").replaceAll(" ",columnFormat.replace(topDivisor,bottomDivisor));
        bottomFormat=bottomLeftCorner+ bottomFormat.substring(0,bottomFormat.length()-1)+bottomRightCorner;

        System.out.println(headerFormat);
        String s;
        for (int i = 0; i < array.length; i++) {
            s=String.format(format,i,array[i]);
            System.out.printf(vertivalPlank+" "+"%-"+(columnLength+1)+"s",s);
            if (i==array.length-1){
                System.out.print(vertivalPlank+"\n" + bottomFormat+"\n");
                break;
            }
            if ((i+1)%realColumns==0){
                System.out.print(vertivalPlank+"\n");
                if (i+realColumns<array.length){
                    System.out.print(midFormat);
                } else{
                    System.out.print(midFormat.substring(0,1+(columnLength+3)*(array.length%realColumns)));
                    System.out.print(midFormat.substring(1+(columnLength+3)*(array.length%realColumns),midFormat.length()).replace(midDivisor,bottomDivisor).replace(midRight,bottomRightCorner));
                }
                System.out.print("\n");
            }
        }


    }
    private static void printInColumns(double array[], String format, int columns){
        int columnLength=0, stringLength;
        for (int i = 0; i < array.length; i++) {
            stringLength=String.format(format,i,array[i]).length();
            columnLength=(columnLength<stringLength)?stringLength:columnLength;
        }

        int realColumns=(array.length>columns?columns:array.length%columns);
        //int bottomColumns=(array.length-1)%realColumns+1;
        char topLeftCorner=0x2554, topRightCorner=0x2557, topDivisor=0x2566;
        char midLeft=0x2560, midRight=0x2563, midDivisor=0x256C;
        char bottomLeftCorner=0x255A, bottomRightCorner=0x255D, bottomDivisor=0x2569;
        char horizontalPlank=0x2550,vertivalPlank=0x2551;

        String columnFormat=String.format("%"+(columnLength+2)+"s"," ").replace(' ',horizontalPlank)+topDivisor;
        String headerFormat=String.format("%"+realColumns+"s"," ").replaceAll(" ",columnFormat);
        headerFormat=topLeftCorner+headerFormat.substring(0,headerFormat.length()-1)+topRightCorner;
        String midFormat=headerFormat.replace(topLeftCorner,midLeft).replace(topDivisor,midDivisor).replace(topRightCorner,midRight);
        //String bottomFormat=String.format("%"+(bottomColumns)+"s"," ").replaceAll(" ",columnFormat.replace(topDivisor,bottomDivisor));
        //bottomFormat=bottomLeftCorner+ bottomFormat.substring(0,bottomFormat.length()-1)+bottomRightCorner;

        System.out.println(headerFormat);
        String s;

        int tableRows=array.length/realColumns+((array.length%realColumns>0)?1:0);
        String bottomFormat=String.format("%"+(realColumns-((array.length%realColumns>0)?1:0))+"s"," ").replaceAll(" ",columnFormat.replace(topDivisor,bottomDivisor));
        bottomFormat=bottomLeftCorner+ bottomFormat.substring(0,bottomFormat.length()-1)+bottomRightCorner;
        int colIndex=0;
        for (int i = 0; i <tableRows ; ++i) {
            for (int j=0;j<realColumns;++j){
                colIndex=i+j*tableRows;
                if (colIndex<array.length) {
                    s = String.format(format, colIndex, array[colIndex]);
                    System.out.printf(vertivalPlank + " " + "%-" + (columnLength + 1) + "s", s);
                }
            }
            if (i==tableRows-1){
                System.out.println(vertivalPlank+"\n"+bottomFormat);
                break;
            } else {
                System.out.println(vertivalPlank);
                if (colIndex<array.length){
                    if (colIndex+1<array.length)
                        System.out.println(midFormat);
                    else
                        System.out.println(midFormat.substring(0,midFormat.length()-1)+bottomRightCorner);
                } else {
                    System.out.println(midFormat.substring(0,midFormat.length()-4-columnLength)+midRight);
                }
            }
        }
    }
}
