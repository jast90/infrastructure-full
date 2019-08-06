package me.jastz.common.markdown;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class AutoGenerateREADME {

    private AutoGenerateREADME() {
    }

    /**
     * 将目录下的文件按创建时间排序生成readme markdown
     *
     * @param folder
     * @param markDownFileName
     */
    public static void generateReadMeMarkDownFormFolderFiles(String folder, String markDownFileName) {
        File folderFile = new File(folder);

        if (folderFile.isDirectory() == false) {
            throw new IllegalArgumentException(String.format("%s is not folder.", folder));
        }
        File[] files = folderFile.listFiles();
        Arrays.sort(files, (file1, file2) -> {
            int i = 0;
            try {
                BasicFileAttributes attr1 = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
                BasicFileAttributes attr2 = Files.readAttributes(file2.toPath(), BasicFileAttributes.class);
                if (attr1.creationTime().toMillis() < attr2.creationTime().toMillis()) {
                    i = -1;
                } else {
                    i = 1;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return i;

        });
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (File file : files) {
            if (file.isFile() == false) {
                continue;
            }
            if (file.getName().equalsIgnoreCase("readme.md")) {
                continue;
            }
            i++;
            String name = file.getName().substring(file.getName().indexOf(".") + 1, file.getName().lastIndexOf("."));
            stringBuilder.append(String.format("%s. [%s](%s)  ", i, name, file.getName())).append("\r\n");
        }
        File file = new File(String.format("%s\\%s", folder, markDownFileName));
        FileWriter fileWriter = null;
        try {
            if (file.createNewFile()) {
                fileWriter = new FileWriter(file);
                fileWriter.write(stringBuilder.toString());
            } else {
                if (file.delete()) {
                    System.out.println(String.format("文件%s已经存在，删除成功", file.getAbsolutePath()));
                }
                fileWriter = new FileWriter(file);
                fileWriter.write(stringBuilder.toString());
            }
            System.out.println(String.format("文件%s创建成功", file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
