package me.jastz.common.zxing;

import com.google.common.collect.Maps;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author zhiwen
 */
public final class QRCodeUtil {

    private static MultiFormatWriter multiFormatWriter;

    private static MultiFormatReader multiFormatReader;

    static {
        multiFormatWriter = new MultiFormatWriter();
        multiFormatReader = new MultiFormatReader();
    }

    private QRCodeUtil() {
    }

    /**
     * 根据内容生成二维码图片文件
     *
     * @param content 二维码内容
     * @param size    二维码图片长、宽
     * @param bgColor 二维码背景色 取值参考：http://www.bootcss.com/p/websafecolors/
     * @param color   二维码颜色 取值参考：http://www.bootcss.com/p/websafecolors/
     * @param file    文件位置
     */
    public static boolean generateQRCodeToFile(String content, int size, int bgColor, int color, Path file) {
        boolean result;
        try {
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(color, bgColor);
            Map<EncodeHintType, Object> hints = Maps.newHashMap();
            /**
             * 设置二维码的 margin
             */
            hints.put(EncodeHintType.MARGIN, 0);
            result = writeToPath(multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hints), "PNG", file, matrixToImageConfig);
        } catch (WriterException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * 根据内容生成二维码图片文件(白色背景黑色二维码)
     *
     * @param content
     * @param size
     * @param file
     * @return
     */
    public static boolean generateQRCodeToFile(String content, int size, Path file) {
        boolean result;
        try {
            Map<EncodeHintType, Object> hints = Maps.newHashMap();
            /**
             * 设置二维码的 margin
             */
            hints.put(EncodeHintType.MARGIN, 0);
            result = writeToPath(multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hints), "PNG", file, null);
        } catch (WriterException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    private static boolean writeToPath(BitMatrix bitMatrix, String format, Path file, MatrixToImageConfig matrixToImageConfig) {
        boolean result = true;
        try {
            if (matrixToImageConfig == null) {
                MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            } else {
                MatrixToImageWriter.writeToPath(bitMatrix, format, file, matrixToImageConfig);
            }

        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    private static boolean writeToStream(BitMatrix bitMatrix, String format, OutputStream stream, MatrixToImageConfig matrixToImageConfig) {
        boolean result = true;
        try {
            if (matrixToImageConfig == null) {
                MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
            } else {
                MatrixToImageWriter.writeToStream(bitMatrix, format, stream, matrixToImageConfig);
            }

        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public static boolean writeToStream(String content, int size, OutputStream outputStream) {
        boolean result = true;
        try {
            Map<EncodeHintType, Object> hints = Maps.newHashMap();
            /**
             * 设置二维码的 margin
             */
            hints.put(EncodeHintType.MARGIN, 0);
            writeToStream(multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hints), "PNG", outputStream, null);
        } catch (WriterException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * 解析二维码
     * <p>
     * 参考: https://stackoverflow.com/questions/36210537/find-qr-code-in-image-and-decode-it-using-zxing
     *
     * @param filePath
     * @return
     */
    public static String readQRCode(Path filePath) {

        try {
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(filePath.toFile()))));
            Result result = multiFormatReader.decode(binaryBitmap);
            if (result == null) {
                return "";
            }
            return result.getText();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
