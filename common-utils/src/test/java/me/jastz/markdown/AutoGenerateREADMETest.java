package me.jastz.markdown;

import me.jastz.common.markdown.AutoGenerateREADME;
import org.junit.Test;

public class AutoGenerateREADMETest {
    @Test
    public void generateReadMeMarkDownFormFolderFiles() {
        AutoGenerateREADME.generateReadMeMarkDownFormFolderFiles("C:\\Users\\zhang\\Desktop\\github\\MarkDown\\Java-SE\\NIO", "README.md");
    }
}
