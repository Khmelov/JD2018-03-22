package by.it.sgolovach.jd01_12;


import java.util.*;

public class TaskC1 {

    static List<Integer> cypher = new ArrayList<>();

    private static int generate() {
        return (int) (Math.random() * 9999 + 1);
    }

    private static int cypherMake() {
        int cyph = generate();
        if (cypher.contains(cyph)) {
            while (cypher.contains(cyph)) {
                cyph = generate();
            }
        }
        cypher.add(cyph);
        return cyph;
    }

    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        String str = "";
        Map<Integer, String> objects = new TreeMap<>();
        int i;
        while (!(str = scaner.next()).equals("end")) {
            i = cypherMake();
            objects.put(i, str);

        }

        System.out.println(objects.toString());

        Map<Integer, String> res = new TreeMap<>();
        for (Iterator<Integer> it = objects.keySet().iterator(); it.hasNext();) {
            Integer key = it.next();
            String val = objects.get(key);
            if (!res.containsValue(val)) {
                res.put(key, val);
            }
        }


        System.out.println(res.toString());

    }
}

/*
opel
mazda
opel
mazda
ford
toyota
lada
mitsubishi
renault
honda
honda
end
*/