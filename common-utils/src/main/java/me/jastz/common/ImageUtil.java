package me.jastz.common;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhiwen on 2016/12/19.
 */
public class ImageUtil {

    public static void code(OutputStream outputStream, String code) {
        int w = 200, h = 100;
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();

        setBackground(g2, w, h);
        drawCodes(g2, code, w, h);
        drawLines(g2, w, h);

        g2.dispose();
        try {
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setBackground(Graphics2D g2, int w, int h) {
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, w, h);
        g2.setColor(Color.BLACK);
    }

    public static void drawCodes(Graphics2D g2, String codes, int w, int h) {
        Font f = new Font("SansSerif", Font.BOLD, 30);
        g2.setFont(f);
        g2.setColor(Color.RED);
        FontMetrics fm = g2.getFontMetrics();
        int x = (w - fm.stringWidth(codes)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g2.drawString(codes, x, y);
        g2.setFont(f);
    }

    public static void drawLines(Graphics2D g2, int w, int h) {
        g2.setColor(Color.CYAN);
        Random random = new Random();
        int x1, y1, x2, y2;
        for (int i = 0; i < 30; i++) {
            int c = random.nextInt(2);
            g2.setColor(Arrays.asList(Color.CYAN,Color.magenta,Color.red).get(c));
            x1 = random.nextInt(w);
            y1 = random.nextInt(h);
            x2 = random.nextInt(w);
            y2 = random.nextInt(h);
            System.out.println(String.format("x1=%s,y1=%s,x2=%s,y2=%s", x1, y1, x2, y2));
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    public static void writeToFile(String fileName, String code) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            code(fos, code);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String randomCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        writeToFile("D:" + File.separator + "1.jpg", randomCode());
    }
}
