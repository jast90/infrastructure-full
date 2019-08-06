package me.jastz.common.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zhiwen
 */
public class FileUtils {
    private FileUtils() {

    }

    public static void writeJsonToFile(String json, String fileName, Path path) {
        writeStringToFile(json, fileName, path);
    }

    public static void writeStringToFile(String content, String fileName, Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Path filePath = Paths.get(path.toString(), fileName);
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                Files.write(filePath, content.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入成功");
    }
}
