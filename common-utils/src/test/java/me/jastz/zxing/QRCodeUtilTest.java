package me.jastz.zxing;

import me.jastz.common.zxing.QRCodeUtil;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * @author zhiwen
 */
public class QRCodeUtilTest {

    @Test
    public void qRCodeToFile() {
        QRCodeUtil.generateQRCodeToFile("xxx", 512, 0xFFFFFFFF, 0xFFff699d, Paths.get("E:", "qrcode", "xxx.png"));
    }

    @Test
    public void qRCodeToFileDefault() {
        QRCodeUtil.generateQRCodeToFile("default", 512, Paths.get("E:", "qrcode", "default.png"));
    }


    @Test
    public void readQRCode() {
        String text = QRCodeUtil.readQRCode(Paths.get("E:", "qrcode", "xxx.png"));
        System.out.println(text);
    }
}
