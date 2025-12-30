package com.strings;

public class StringDemo {
    public static void main(String[] args) {
        System.out.println("John" + 3);
        System.out.println("John" + 3 + 8);
        System.out.println("John" + (3 + 8));
        System.out.println(3 + 8 + 5 + "John");
        System.out.println("John" + null);
        System.out.println(null + "John");

        // String methods

        // length()
        String name = "John";
        System.out.println("length: " + name.length());
        System.out.println("charAt(3): " + name.charAt(3));
//        System.out.println(name.charAt(12)); // StringIndexOutOfBoundsException

        // indexOf()
        name = "nametor Dolittle";
        System.out.println("indexOf('t'): " + name.indexOf('t'));
        System.out.println("indexOf('t', 5): " + name.indexOf('t', 5));
        System.out.println("indexOf('cto'): " + name.indexOf("cto"));
        System.out.println("indexOf('Do, 2'): " + name.indexOf("Do", 2));
        System.out.println("indexOf(\"A\"): " + name.indexOf("A"));

        // substring
        name = "John Wayne";
        System.out.println("substring(3)" + name.substring(3));
        System.out.println("substring(3, 8)" + name.substring(3, 8));
        System.out.println("substring(3, 3)" + name.substring(3, 3)); // empty string
//        System.out.println("substring(8, 3)" + name.substring(8, 3)); // StringIndexOutOfBoundsException
//        System.out.println("substring(3, 14)" + name.substring(3, 14)); // StringIndexOutOfBoundsException

        // toLowerCase
        System.out.println(name.toLowerCase());

        // toUpperCase
        System.out.println(name.toUpperCase());

        // equals(), equalsIgnoreCase()
        String name1 = new String("John Wayne");
        String name2 = new String("John Wayne");
        String name3 = new String("john wayne");
        System.out.println("name1.equals(name2): " + name1.equals(name2)); // compares content not reference
        System.out.println("name1 == name2: " + name1 == name2);
        System.out.println("name1.equals(name3): " + name1.equals(name3));

        // startsWith, endsWith()
        System.out.println(name.startsWith("J"));
        System.out.println(name.startsWith("Jo"));
        System.out.println(name.endsWith("e"));
        System.out.println(name.endsWith("Wayne"));

        // contains (contains substring)
        System.out.println(name.contains("n"));
        System.out.println(name.contains("John"));
        System.out.println(name.contains("j"));

        // replace
        String str = "abcdeabc";
        System.out.println(str.replace('c', 'y'));
        System.out.println(str.replace("c", "y"));
        System.out.println(str.replace("bcd", "xyz"));

        // strip, stripLeading(), stripTrailing()
        String abc = "  abc  ";
        System.out.println("|" + abc.strip() + "|");
        System.out.println("|" + abc.trim() + "|"); // same as strip(), but supports Unicode
        System.out.println("|" + abc.stripLeading() + "|");
        System.out.println("|" + abc.stripTrailing() + "|");

        // whitespaces also include \t (tab), \n (new line), \r (carriage return)
        // Note: all escape sequences count as 1 char in length

        // indent(n)

        // if(n==0) does nothing
        // if(n>0) adds same number of blank spaces to each line
        // if(n<0) tries to remove 'n' whitespaces characters from beginning of line
        // normalizes existing line breaks
        // adds line break at the end if missing

        // stripIndent

        // removes all leading incidental whitespace
        // normalizes existing line breaks
        // does not add line break at the end if missing
        str = "     John\n    D.\n   Wayne";
        System.out.println("--");
        System.out.println(str);
        System.out.println("--");
        System.out.println(str.indent(2));
        System.out.println("--");
        System.out.println(str.indent(-2));
        System.out.println("--");
        System.out.println(str.stripIndent());
        System.out.println("--");

        // translateEscapes()
        name = "John\\tWayne";
        System.out.println(name);
        System.out.println(name.translateEscapes());

        // isEmpty, isBlank()
        System.out.println("\"\".isEmpty(): " + "".isEmpty());
        System.out.println("\" \".isEmpty(): " + " ".isEmpty());
        System.out.println("\"\".isBlank(): " + "".isBlank());
        System.out.println("\" \".isBlank(): " + " ".isBlank());

        // string formatting
        // %s for any type, usually for String
        // %d for integral values (int and long)
        // %f for decimal values (float and double)
        // %n inserts a system-dependent line separator

        // format(), formatted()
        name = "John";
        int numbOfMarbles = 5;
        String print1 = name + " has " + numbOfMarbles + " marbles.";
        String print2 = String.format("%s has %d marbles.", name, numbOfMarbles);
        String print3 = "%s has %d marbles.".formatted(name, numbOfMarbles);

        System.out.println(print1);
        System.out.println(print2);
        System.out.println(print3);

        // method chaining
        name = "  John Wayne ";
        System.out.println(name.trim().toUpperCase().replace('Y', 'R'));

        // Strings are immutable
        name = "John Wayne";
        name.toUpperCase();
        System.out.println(name);

        // you have to reassign the new value or create a new String
        name = "John Wayne";
        name = name.toUpperCase();
        System.out.println(name);
        String newName = name.toUpperCase();
        System.out.println(newName);


    }
}
