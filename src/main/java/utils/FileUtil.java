package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
    public static void copyToFile(File src, File destination){
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static Properties properties(String address){
        Properties properties = new Properties();
        try{
            properties.load(fileInputStream(address));
        } catch (IOException e) {
            System.err.println(e);
        }
        return properties;
    }

    public static FileInputStream fileInputStream(String address) {
        FileInputStream fileIp = null;
        try {
            fileIp = new FileInputStream(address);
        }
        catch (FileNotFoundException exception) {
            System.err.println(exception);
        }
        return fileIp;
    }
}
