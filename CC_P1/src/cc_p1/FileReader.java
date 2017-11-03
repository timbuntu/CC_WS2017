/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matti
 */
public class FileReader {

    public static InputStream getStream(String filepath) throws FileNotFoundException {
        InputStream fileStream = null;
        fileStream = new FileInputStream(filepath);

        return fileStream;
    }

}
