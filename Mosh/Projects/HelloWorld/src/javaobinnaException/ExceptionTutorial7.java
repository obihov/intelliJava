package javaobinnaException;

import java.io.FileReader;
import java.io.IOException;

/**ABOUT:
 * This tutorial introduces the "finally" block.
 * The "finally" block can be used for resetting state of an object.
 * Sometimes it can be used to explicitly dispose idle/unused objects in memory.
 *
 * Note:
 * Garbage collector handles the disposal of objects in memory, but this happens randomly.
 * Certain classes in Java can have their objects explicitly disposed.
 * These classes must implement the AutoCloseable interface and
 * call the close method to explicitly dispose its objects when needed.
 */
public class ExceptionTutorial7 {

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("File Error reported: " + e.getMessage());
        }
    }

    public static void readFile() throws IOException {
        FileReader reader = null;

        try {
            reader = new FileReader("somefile.txt");
            reader.read();
        } catch (IOException ex) {
            throw ex;
        }
        finally {
            //Before we call the close method, we need to check that reader is not null.
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
    }
}
