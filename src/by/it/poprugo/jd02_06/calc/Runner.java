package by.it.poprugo.jd02_06.calc;

public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector(new double[]{1, 2, 3});
        Var m = new Matrix("{1,2,3},{4,5,6},{7,8,9}");
        /* A level: calculator*/
        /*print(s.add(s)); //выведет в консоль 6.0
        print(s.sub(s)); //выведет в консоль 0.0
        print(s.mul(s)); //выведет в консоль 9.0
        print(s.div(s)); //выведет в консоль 1.0*/
        /* B level: vector calculator*/
        /*print(v.add(v)); //выведет в консоль {2.0, 4.0, 6.0}
        print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        print(v.mul(v)); //выведет в консоль 14.0
        print(v.div(v)); //сообщит о невозможности операции*/
        /* B level: matrix calculator*/
        print(m.add(m)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        print(m.sub(m)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        print(m.mul(m)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(m.mul(v)); //{14.0, 32.0, 50.0}
        System.out.println("Else");
        Var vv = new Vector(new double[]{3, 2, 1});
        /*print(v.add(vv)); //выведет в консоль {4.0, 4.0, 4.0}
        print(v.add(s)); //выведет в консоль {4.0, 5.0, 6.0}
        print(v.mul(vv)); //выведет в консоль 10.0
        print(v.mul(s)); //выведет в консоль {3.0, 6.0, 9.0}
        print(v.div(s)); //выведет в консоль {0.333, 0.667, 1.0}
        print(v.sub(s)); //выведет в консоль {-2.0, -1.0, 0.0}
        print(m.add(s)); //выведет в консоль
                        // {{4.0,5.0,6.0},{7.0,8.0,9.0},{10.0,11.0,12.0}}
        print(m.add(v)); //сообщит о невозможности операции*/
        Var mm = new Matrix("{1,2,3},{4,5,6}");
        /*print(m.add(mm)); //сообщит о невозможности операции
        print(m.mul(s)); //{{3.0, 6.0, 9.0}, {12.0, 15.0, 18.0}, {21.0, 24.0, 27.0}}*/
        Var vm = new Vector(new double[]{3, 2});
        //print(m.mul(vm)); //{сообщит о невозможности операции
    }
}
