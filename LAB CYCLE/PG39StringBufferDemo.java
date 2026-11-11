public class PG39StringBufferDemo {

    // a. Append to StringBuffer
    static void appendDemo() {
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Original       : " + sb);
        sb.append(" World");
        System.out.println("After append() : " + sb);
        sb.append(123);
        System.out.println("After append(123): " + sb);
    }

    // b. Insert into StringBuffer
    static void insertDemo() {
        StringBuffer sb = new StringBuffer("Hello World");
        System.out.println("Original       : " + sb);
        sb.insert(5, " Beautiful");
        System.out.println("After insert() : " + sb);
    }

    // c. Delete from StringBuffer
    static void deleteDemo() {
        StringBuffer sb = new StringBuffer("Hello Beautiful World");
        System.out.println("Original        : " + sb);
        sb.delete(5, 15);
        System.out.println("After delete()  : " + sb);
        sb.deleteCharAt(0);
        System.out.println("After deleteCharAt(0): " + sb);
    }

    // d. Reverse a StringBuffer
    static void reverseDemo() {
        StringBuffer sb = new StringBuffer("Java Programming");
        System.out.println("Original        : " + sb);
        sb.reverse();
        System.out.println("After reverse() : " + sb);

        StringBuffer sb2 = new StringBuffer("madam");
        System.out.println("\nOriginal        : " + sb2);
        StringBuffer sb2copy = new StringBuffer(sb2).reverse();
        if (sb2.toString().equals(sb2copy.toString()))
            System.out.println("\"" + sb2 + "\" is a PALINDROME!");
        else
            System.out.println("\"" + sb2 + "\" is NOT a palindrome.");
    }

    // e. Replace in StringBuffer
    static void replaceDemo() {
        StringBuffer sb = new StringBuffer("Hello World");
        System.out.println("Original        : " + sb);
        sb.replace(6, 11, "Java");
        System.out.println("After replace() : " + sb);
    }

    // f. Capacity and Length
    static void capacityLengthDemo() {
        StringBuffer sb = new StringBuffer();
        System.out.println("Default Capacity : " + sb.capacity());
        System.out.println("Default Length   : " + sb.length());

        sb.append("Hello Java");
        System.out.println("\nAfter appending \"Hello Java\":");
        System.out.println("Length           : " + sb.length());
        System.out.println("Capacity         : " + sb.capacity());

        StringBuffer sb2 = new StringBuffer(50);
        System.out.println("\nCustom Capacity  : " + sb2.capacity());
    }

    // g. charAt and setCharAt
    static void charAtDemo() {
        StringBuffer sb = new StringBuffer("Hello Java");
        System.out.println("Original            : " + sb);
        System.out.println("charAt(0)           : " + sb.charAt(0));
        System.out.println("charAt(6)           : " + sb.charAt(6));
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt(0,'h'): " + sb);
    }

    // h. indexOf and lastIndexOf
    static void indexOfDemo() {
        StringBuffer sb = new StringBuffer("Java is great. Java is fun.");
        System.out.println("String              : " + sb);
        System.out.println("indexOf(\"Java\")     : " + sb.indexOf("Java"));
        System.out.println("lastIndexOf(\"Java\") : " + sb.lastIndexOf("Java"));
        System.out.println("indexOf(\"is\")       : " + sb.indexOf("is"));
    }

    // i. substring from StringBuffer
    static void substringDemo() {
        StringBuffer sb = new StringBuffer("Hello Java World");
        System.out.println("Original             : " + sb);
        System.out.println("substring(6)         : " + sb.substring(6));
        System.out.println("substring(6, 10)     : " + sb.substring(6, 10));
    }

    // j. Convert StringBuffer to String
    static void toStringDemo() {
        StringBuffer sb = new StringBuffer("StringBuffer to String");
        System.out.println("StringBuffer : " + sb);
        String str = sb.toString();
        System.out.println("String       : " + str);
        System.out.println("Type         : " + str.getClass().getName());
    }

    // ── main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("StringBuffer CLASS DEMO");

        System.out.println("\na. append()");
        appendDemo();

        System.out.println("\nb. insert()");
        insertDemo();

        System.out.println("\nc. delete()");
        deleteDemo();

        System.out.println("\nd. reverse()");
        reverseDemo();

        System.out.println("\ne. replace()");
        replaceDemo();

        System.out.println("\nf. capacity() & length()");
        capacityLengthDemo();

        System.out.println("\ng. charAt() & setCharAt()");
        charAtDemo();

        System.out.println("\nh. indexOf() & lastIndexOf()");
        indexOfDemo();

        System.out.println("\ni. substring()");
        substringDemo();

        System.out.println("\nj. toString()");
        toStringDemo();
    }
}
