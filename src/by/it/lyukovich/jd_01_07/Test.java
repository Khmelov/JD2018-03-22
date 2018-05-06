package by.it.lyukovich.jd_01_07;

public class Test {
    public static void main(String[] args) {
        /*StringBuilder sb = new StringBuilder();
        String[] string;
        double[][] matr = {{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}, {100, 200, 300, 400}};
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                if (i == 0 && j == 0) {
                    sb.append("{");
                }
                if (j == 0) {
                    sb.append("{");
                }
                if (j < matr[j].length - 1) {
                    sb.append(matr[i][j] + ",");
                } else sb.append(matr[i][j]);
                if (j == matr[j].length - 1) {
                    sb.append("}");
                }
                if (j == matr[j].length - 1 && i < matr[i].length - 1) {
                    sb.append(",");
                }
                if (i == matr[i].length - 1 && j == matr[j].length - 1) {
                    sb.append("}");
                }
            }
        }
        System.out.println(sb);
        System.out.println(sb.substring(1, sb.length() - 1));*/
        test();
    }
    public static void test(){
        for (int i = 0; i < 4; i++) {
            for (int j = -1; j < i; i++);}
        System.out.print("*");
    }
}


