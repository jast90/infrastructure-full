package me.jastz.java;

import me.jastz.common.java.PropertiesUtil;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhiwen
 */
public class JavaTest {

    @Test
    public void test() {
        //获取系统的环境变量
        System.out.println(System.getenv("hello"));
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getenv("OneDrive"));
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
        //C:\Program Files (x86)\Intel\iCLS Client\;C:\Program Files\Intel\iCLS Client\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Git\cmd;E:\tools\apache-maven-3.3.9\bin;C:\Program Files\Java\jdk1.8.0_05/bin;C:\Program Files\Java\jdk1.8.0_05/jre/bin;C:\Program Files\nodejs\;E:\tools\nexus-3.2.0-01-win64\nexus-3.2.0-01\bin;D:\Go\bin;C:\Program Files\PuTTY\;E:\tools\javacc-6.0\bin;C:\Program Files\Redis\;C:\WINDOWS\System32\OpenSSH\;C:\Users\lenovo\AppData\Local\Programs\Python\Python36-32\Scripts\;C:\Users\lenovo\AppData\Local\Programs\Python\Python36-32\;C:\Users\lenovo\scoop\shims;C:\Users\lenovo\AppData\Local\Microsoft\WindowsApps;C:\Users\lenovo\AppData\Roaming\npm;C:\Program Files\Docker Toolbox;E:\tools\Redis-x64-3.2.100;E:\tools\gradle-4.3\bin;E:\tools\javacc-6.0\bin;C:\Users\lenovo\AppData\Local\Programs\Fiddler;C:\Users\lenovo\AppData\Local\atom\bin;%USERPROFILE%\AppData\Local\Microsoft\WindowsApps;
    }

    @Test
    public void test1() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("E:\\mbss\\mbss-wxa\\src\\main\\resources\\i18n/messages_failure.properties"));
            PropertiesUtil.propertiesToFile(properties, "E:\\mbss\\mbss-wxa\\src\\main\\resources\\i18n/messages_failure_1.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
