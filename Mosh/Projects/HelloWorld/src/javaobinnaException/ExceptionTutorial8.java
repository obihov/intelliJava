package javaobinnaException;

import java.io.FileReader;
import java.io.IOException;

/**
 * We can use the "finally" block to explicitly dispose off resources.
 * The one problem with this approach is that calling the close method if the AutoCloseable interface on objects,
 * also requires surrounding it around try/catch block as well.
 * This leaves our finally block looking messy, as we may have embedded try/catch blocks inside it.
 * We have a better approach that can make our code look cleaner
 * In java this approach is called "try with resources statement".
 */
public class ExceptionTutorial8 {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("File Error reported: " + e.getMessage());
        }
    }

    public static void readFile() throws IOException {
        try (
                FileReader reader1 = new FileReader("somefile.txt"); //external resource1
                FileReader reader2 = new FileReader("somefile.txt"); //external resource2
        ) {
            reader1.read();
            reader2.read();
        } catch (IOException ex) {
            throw ex;
        }
    }
}
