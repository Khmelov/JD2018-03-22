package by.it.kovko.jd01_12;

public class Text{
    static final String program =
            "package by.it.kovko.jd01_12;\n" +
            "\n" +
            "import java.util.ArrayDeque;\n" +
            "import java.util.HashMap;\n" +
            "import java.util.Map;\n" +
            "import java.util.regex.Matcher;\n" +
            "import java.util.regex.Pattern;\n" +
            "\n" +
            "public class TaskC3 {\n" +
            "    private static boolean parenthesisChecker(String text) {\n" +
            "        ArrayDeque<String> openParentheses = new ArrayDeque<>();\n" +
            "        Map<String, String> parenthesesMap = new HashMap<>();\n" +
            "        parenthesesMap.put(\"[\", \"]\");\n" +
            "        parenthesesMap.put(\"(\", \")\");\n" +
            "        parenthesesMap.put(\"{\", \"}\");\n" +
            "        parenthesesMap.put(\"<\", \">\");\n" +
            "        Matcher m = Pattern.compile(\"[\\\\[\\\\](){}<>]\").matcher(text);\n" +
            "        while (m.find())\n" +
            "                openParentheses.addFirst(m.group());\n" +
            "            else if (!(parenthesesMap.get(openParentheses.pop())).equals(m.group()))\n" +
            "                return false;\n" +
            "        return openParentheses.isEmpty();\n" +
            "    }\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(parenthesisChecker(str));\n" +
            "\n" +
            "    }\n" +
            "}\n";

}
