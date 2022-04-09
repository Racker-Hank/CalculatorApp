package mode.conversion;

public class Computer {
    public static void Hex_To_other (String hexadecimal) {
        int decimal = Integer.parseInt(hexadecimal, 16);
        String binary = Integer.toBinaryString(decimal);
        String octal = Integer.toOctalString(decimal);
        System.out.println("DEC = " + decimal);
        System.out.println("BIN = " + binary);
        System.out.println("OCT = " + octal);
    }

    public static void Binary_To_other (String binary) {
        int decimal = Integer.parseInt(binary, 2);
        String hex = Integer.toHexString(decimal);
        String octal = Integer.toOctalString(decimal);
        System.out.println("DEC = " + decimal);
        System.out.println("HEX = " + hex);
        System.out.println("OCT = " + octal);
    }

    public static void DEC_To_other (int decimal) {
        String binary = Integer.toBinaryString(decimal);
        String hex = Integer.toHexString(decimal);
        String octal = Integer.toOctalString(decimal);
        System.out.println("BIN = " + binary);
        System.out.println("HEX = " + hex);
        System.out.println("OCT = " + octal);
    }

    public static void OCT_To_other (String Octal) {
        int decimal = Integer.parseInt(Octal, 8);
        String binary = Integer.toBinaryString(decimal);
        String hex = Integer.toHexString(decimal);
        System.out.println("DEC = " + decimal);
        System.out.println("BIN = " + binary);
        System.out.println("HEX = " + hex);
    }
}
