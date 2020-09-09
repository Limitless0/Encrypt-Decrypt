package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static String encDec = "enc";
    static boolean encrypting = true;
    static String str = "";
    static int key = 0;
    static String inPathName = "";
    static String outPathName = "";
    static boolean data = false;
    static boolean outFile = false;
    static BlackBox blkBox = null;
    static boolean shift = true;
    static String alg = "";

    public static void main(String[] args) {
        argsSet(args);
        modeSet();
        String out = "";
        if (encrypting) {
            out = blkBox.encrypt(str, key);
        }
        if (!encrypting) {
            out = blkBox.decrypt(str, key);
        }
        printToFile(out);

    }

    static void printToFile(String out) {
        // System.out.println("printing to file");
        try {
            File encryptedFile = new File(outPathName);
            FileWriter encFileWriter = new FileWriter(encryptedFile);
            encFileWriter.write(out);
            //System.out.println("printing " + out + " to " + outPathName);
            encFileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: File not created: " + outPathName);
        }
    }

    static void modeSet() {
        if (encDec.equals("dec")) {
            encrypting = false;
        }
        if (!data) {
            try {
                File file = new File(inPathName);
                Scanner scan = new Scanner(file);
                while (scan.hasNext()) {
                    str += scan.nextLine();
                    System.out.println(str);
                }
                scan.close();
            } catch (Exception e) {
                System.out.println("Error: No file found: " + inPathName);
            }
        }
        if (shift) {
            blkBox = new BlackBoxShift();
        } else {
            blkBox = new BlackBoxUni();
        }
    }

    static void argsSet(String[] args) {
        for (int ii = 0; ii < args.length; ii += 2) {
            if (args[ii].equals("-in")) {
                inPathName = args[ii + 1];
            }
            if (args[ii].equals("-out")) {
                outPathName = args[ii + 1];
                outFile = true;
            }
            if (args[ii].equals("-mode")) {
                encDec = args[ii + 1];
            }
            if (args[ii].equals("-key")) {
                key = Integer.parseInt(args[ii + 1]);
            }
            if (args[ii].equals("-data")) {
                str = args[ii + 1];
                data = true;
            }
            if (args[ii].equals("-alg")) {
                alg = args[ii + 1];
                if (alg.toUpperCase().equals("UNICODE")) {
                    shift = false;
                }
            }
        }
    }

}