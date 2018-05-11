package by.it.kirova.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalc {

    @Test(timeout = 5000)
    public void getValueFromConstructor() throws Exception {

        //проверка работы конструкторов класса Scalar
        //создание переменной типа Scalar на основе числа
        Scalar sc1 = new Scalar(5.2);
        assertEquals(sc1.toString(), "5.2");

        //создание переменной типа Scalar на основе объекта Scalar
        Scalar sc2 = new Scalar(sc1);
        assertEquals(sc2.toString(), "5.2");

        //создание переменной типа Scalar на основе строки
        Scalar sc3 = new Scalar("8.2");
        assertEquals(sc3.toString(), "8.2");



        //проверка работы конструкторов класса Vector
        //создание переменной типа Vector на основе массива
        Vector v1 = new Vector(new double[]{5.2, -3});
        assertEquals(v1.toString(), "{5.2, -3.0}");

        //создание переменной типа Vector на основе объекта Vector
        Vector v2 = new Vector(v1);
        assertEquals(v2.toString(), "{5.2, -3.0}");

        //создание переменной типа Vector на основе строки
        Vector v3 = new Vector("{5.2, -3}");
        assertEquals(v3.toString(), "{5.2, -3.0}");



        //проверка работы конструкторов класса Matrix
        //создание переменной типа Matrix на основе многомерного массива
        Matrix m1 = new Matrix(new double[][]{{2.0, 4.0, 6.0},{8.0, 10.0, 12.0},{14.0, 16.0, 18.0}});
        assertEquals(m1.toString(), "{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}");

        //создание переменной типа Matrix на основе объекта Matrix
        Matrix m2 = new Matrix(m1);
        assertEquals(m2.toString(), "{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}");

        //создание переменной типа Matrix на основе строки
        Matrix m3 = new Matrix("{{2.0, 4.0, 6.0},{8.0, 10.0, 12.0},{14.0, 16.0, 18.0}}");
        assertEquals(m3.toString(), "{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}");

    }


    @Test(timeout = 5000)
    public void add() throws Exception {
        Parser parser = new Parser();

        //операции типа "скаляр + скаляр"
        assertEquals(parser.calc("2+5.3").toString(), "7.3");
        assertEquals(parser.calc("-2+-8").toString(), "-10.0");
        assertEquals(parser.calc("2+.3").toString(), "2.3");
        assertEquals(parser.calc("2+-.5").toString(), "1.5");
        assertEquals(parser.calc("2+-6.5").toString(), "-4.5");
        assertEquals(parser.calc("5.3+6").toString(), "11.3");
        assertEquals(parser.calc("2+-5.3").toString(), "-3.3");

        //операции типа "скаляр + скаляр" + присвоение значения скаляру + вызов значения скаляра из памяти
        assertEquals(parser.calc("A=5+3").toString(), "8.0");
        assertEquals(parser.calc("B=2.8+6").toString(), "8.8");
        assertEquals(parser.calc("C=A+B").toString(), "16.8");
        assertEquals(parser.calc("C+1").toString(), "17.8");

        //операции типа "скаляр + вектор", "вектор + скаляр" + присвоение значения вектору
        assertEquals(parser.calc("{2,2,-4}+.3").toString(), "{2.3, 2.3, -3.7}");
        assertEquals(parser.calc("5+{1,2.5,-4}").toString(), "{6.0, 7.5, 1.0}");
        assertEquals(parser.calc("D={1,1,-4}+0").toString(), "{1.0, 1.0, -4.0}");

        //операции типа "скаляр + матрица", "матрица + скаляр" + присвоение значения матрице
        assertEquals(parser.calc("5+{{1,10},{6,3}}").toString(), "{{6.0, 15.0}, {11.0, 8.0}}");
        assertEquals(parser.calc("{{-1,10},{6,-33}}+10").toString(), "{{9.0, 20.0}, {16.0, -23.0}}");
        assertEquals(parser.calc("E={{1,10},{10,-5}}+8").toString(), "{{9.0, 18.0}, {18.0, 3.0}}");

        //операции типа "вектор + вектор" + вызов значения вектора из памяти
        assertEquals(parser.calc("{2,3,4}+{5,6,7}").toString(), "{7.0, 9.0, 11.0}");
        assertEquals(parser.calc("{2,-3,4}+{5,6,-7}").toString(), "{7.0, 3.0, -3.0}");
        assertEquals(parser.calc("D+{1,1,-4}").toString(), "{2.0, 2.0, -8.0}");
        assertEquals(parser.calc("F=D+D").toString(), "{2.0, 2.0, -8.0}");

        //операции типа "матрица + матрица" + вызов значения матрицы из памяти
        assertEquals(parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}").toString(), "{{2.0, 4.0}, {16.0, 6.0}}");
        assertEquals(parser.calc("{{1,-2},{-8,3}}+{{1,2},{8,-3}}").toString(), "{{2.0, 0.0}, {0.0, 0.0}}");
        assertEquals(parser.calc("E+{{1,2},{8,3}}").toString(), "{{10.0, 20.0}, {26.0, 6.0}}");
        assertEquals(parser.calc("G=E+E").toString(), "{{18.0, 36.0}, {36.0, 6.0}}");
    }

    @Test(timeout = 5000)
    public void sub() throws Exception {
        Parser parser = new Parser();

        //операции типа "скаляр - скаляр"
        assertEquals(parser.calc("2-5.3").toString(), "-3.3");
        assertEquals(parser.calc("-5--6").toString(), "1.0");
        assertEquals(parser.calc("2-.3").toString(), "1.7");
        assertEquals(parser.calc("2--.5").toString(), "2.5");

        //операции типа "скаляр - скаляр" + присвоение значения скаляру + вызов значения скаляра из памяти
        assertEquals(parser.calc("A=5-3").toString(), "2.0");
        assertEquals(parser.calc("B=2.8-2.8").toString(), "0.0");
        assertEquals(parser.calc("C=A-B").toString(), "2.0"); //-A-5 crash
        assertEquals(parser.calc("C-3").toString(), "-1.0");

        //операции типа "скаляр - вектор", "вектор - скаляр" + присвоение значения вектору
        assertEquals(parser.calc("{2,2,-4}-.3").toString(), "{1.7, 1.7, -4.3}");
        assertEquals(parser.calc("5-{1,2.5,-4}").toString(), "{-6.0, -7.5, -1.0}");
        assertEquals(parser.calc("D={1,1,-4}-1").toString(), "{0.0, 0.0, -5.0}");

        //операции типа "скаляр - матрица", "матрица - скаляр" + присвоение значения матрице
        assertEquals(parser.calc("5-{{1,10},{6,3}}").toString(), "{{-6.0, -15.0}, {-11.0, -8.0}}");
        assertEquals(parser.calc("{{-1,10},{6,-33}}-10").toString(), "{{-11.0, 0.0}, {-4.0, -43.0}}");
        assertEquals(parser.calc("E={{1,10},{10,-5}}-8").toString(), "{{-7.0, 2.0}, {2.0, -13.0}}");

        //операции типа "вектор - вектор" + вызов значения вектора из памяти
        assertEquals(parser.calc("{2,3,4}-{5,6,7}").toString(), "{-3.0, -3.0, -3.0}");
        assertEquals(parser.calc("{2,-3,4}-{5,6,-7}").toString(), "{-3.0, -9.0, 11.0}");
        assertEquals(parser.calc("D-{1,1,-4}").toString(), "{-1.0, -1.0, -1.0}");
        assertEquals(parser.calc("F=D-D").toString(), "{0.0, 0.0, 0.0}");

        //операции типа "матрица - матрица" + вызов значения матрицы из памяти
        assertEquals(parser.calc("{{1,2},{8,3}}-{{1,2},{8,3}}").toString(), "{{0.0, 0.0}, {0.0, 0.0}}");
        assertEquals(parser.calc("{{1,-2},{-8,3}}-{{1,2},{8,-3}}").toString(), "{{0.0, -4.0}, {-16.0, 6.0}}");
        assertEquals(parser.calc("E-{{1,2},{8,3}}").toString(), "{{-8.0, 0.0}, {-6.0, -16.0}}");
        assertEquals(parser.calc("G=E-E").toString(), "{{0.0, 0.0}, {0.0, 0.0}}");
    }

    @Test(timeout = 5000)
    public void mul() throws Exception {
        Parser parser = new Parser();

        //операции типа "скаляр * скаляр"
        assertEquals(parser.calc("2*5.3").toString(), "10.6");
        assertEquals(parser.calc("-5*-6").toString(), "30.0");
        assertEquals(parser.calc("5.5*-6").toString(), "-33.0");
        assertEquals(parser.calc("2*-.3").toString(), "-0.6");
        assertEquals(parser.calc("2*.5").toString(), "1.0");

        //операции типа "скаляр * скаляр" + присвоение значения скаляру + вызов значения скаляра из памяти
        assertEquals(parser.calc("A=5*-3").toString(), "-15.0");
        assertEquals(parser.calc("B=2.5*4").toString(), "10.0");
        assertEquals(parser.calc("C=A*B").toString(), "-150.0"); //-A-5 crash
        assertEquals(parser.calc("C*3").toString(), "-450.0");

        //операции типа "скаляр * вектор", "вектор * скаляр" + присвоение значения вектору
        assertEquals(parser.calc("{2,2,-4}*.3").toString(), "{0.6, 0.6, -1.2}");
        assertEquals(parser.calc("-5*{1,2.5,-4}").toString(), "{-5.0, -12.5, 20.0}");
        assertEquals(parser.calc("D={1,1,-4}*1").toString(), "{1.0, 1.0, -4.0}");

        //операции типа "скаляр * матрица", "матрица * скаляр" + присвоение значения матрице
        assertEquals(parser.calc("5*{{1,10},{6,3}}").toString(), "{{5.0, 50.0}, {30.0, 15.0}}");
        assertEquals(parser.calc("{{-1,10},{6,-33}}*10").toString(), "{{-10.0, 100.0}, {60.0, -330.0}}");
        assertEquals(parser.calc("E={{1,10},{10,-5}}*8").toString(), "{{8.0, 80.0}, {80.0, -40.0}}");

        //операции типа "вектор * вектор" + вызов значения вектора из памяти
        assertEquals(parser.calc("{2,3,4}*{5,6,7}").toString(), "56.0");
        assertEquals(parser.calc("{2,-3,4}*{5,6,-7}").toString(), "-36.0");
        assertEquals(parser.calc("D*{1,1,-4}").toString(), "18.0");
        assertEquals(parser.calc("F=D*D").toString(), "18.0");

        //операции типа "матрица * вектор" + вызов значения матрицы из памяти
        assertEquals(parser.calc("{{1,2},{8,3}}*{1,2}").toString(), "{5.0, 14.0}");
        assertEquals(parser.calc("{{1,-2},{8,-3}}*{1,-2}").toString(), "{5.0, 14.0}");
        assertEquals(parser.calc("E*{1,-8}").toString(), "{-632.0, 400.0}");

        //операции типа "матрица * матрица" + вызов значения матрицы из памяти
        assertEquals(parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}").toString(), "{{17.0, 8.0}, {32.0, 25.0}}");
        assertEquals(parser.calc("{{1,-2},{-8,3}}*{{1,2},{8,-3}}").toString(), "{{-15.0, 8.0}, {16.0, -25.0}}");
        assertEquals(parser.calc("E*{{1,2},{8,3}}").toString(), "{{648.0, 256.0}, {-240.0, 40.0}}");
        assertEquals(parser.calc("G=E*E").toString(), "{{6464.0, -2560.0}, {-2560.0, 8000.0}}");
    }

    @Test(timeout = 5000)
    public void div() throws Exception {
        Parser parser = new Parser();

        //операции типа "скаляр / скаляр"
        assertEquals(parser.calc("2/0.2").toString(), "10.0");
        assertEquals(parser.calc("-5/-1").toString(), "5.0");
        assertEquals(parser.calc("12/-6").toString(), "-2.0");
        assertEquals(parser.calc("3/-.3").toString(), "-10.0");
        assertEquals(parser.calc("2/.5").toString(), "4.0");

        //операции типа "скаляр / скаляр" + присвоение значения скаляру + вызов значения скаляра из памяти
        assertEquals(parser.calc("A=15/-3").toString(), "-5.0");
        assertEquals(parser.calc("B=-2.5/.5").toString(), "-5.0");
        assertEquals(parser.calc("C=A*B").toString(), "25.0"); //-A-5 crash
        assertEquals(parser.calc("C*3").toString(), "75.0");

        //операции типа "вектор / скаляр" + присвоение значения вектору + вызов значения вектора из памяти
        assertEquals(parser.calc("{2,2,-4}/.5").toString(), "{4.0, 4.0, -8.0}");
        assertEquals(parser.calc("D={10,8,-14}/1").toString(), "{10.0, 8.0, -14.0}");
        assertEquals(parser.calc("D/2").toString(), "{5.0, 4.0, -7.0}");

        //операции типа "матрица / скаляр" + присвоение значения матрице + + вызов значения матрицы из памяти
        assertEquals(parser.calc("{{-9,18},{6,-33}}/3").toString(), "{{-3.0, 6.0}, {2.0, -11.0}}");
        assertEquals(parser.calc("E={{20,10},{10,-50}}/2").toString(), "{{10.0, 5.0}, {5.0, -25.0}}");
        assertEquals(parser.calc("E/5").toString(), "{{2.0, 1.0}, {1.0, -5.0}}");

    }

    @Test(timeout = 5000)
    public void shuffleOperations() throws Exception {
        Parser parser = new Parser();

        //примеры из задания А
        assertEquals(parser.calc("A=2+5.3").toString(), "7.3");
        assertEquals(parser.calc("B=A*3.5").toString(), "25.55");
        assertEquals(parser.calc("B1=B+0.11*-5").toString(), "25.0");
        assertEquals(parser.calc("B2=A/2-1").toString(), "2.65");


        //примеры из задания B
        assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");

        //проверка задания C + со скобками
        assertEquals(parser.calc("({{1,2},{8,3}}*({1,2}-{1,2}))*10").toString(),"{-5.0, -6.0}");
        assertEquals(parser.calc("{{1,2},{8,-4}}/2*{1,2}*10-{1,-3}").toString(), "{24.0, 3.0}");
        assertEquals(parser.calc("{{1,2},{8,3}}*{1,2}-{1,2}*10").toString(), "{-5.0, -6.0}");
        assertEquals(parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}+{{1,2},{8,3}}").toString(), "{{18.0, 10.0}, {40.0, 28.0}}");
    }


}