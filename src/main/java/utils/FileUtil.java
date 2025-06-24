package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static void copyToFile(File src, File destination){
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
