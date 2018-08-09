package com.ten.util;

import java.io.*;

/**
 * ImageWriter: 写入图片到服务器
 *
 * @auther ten
 */
public class ImageWriter {

    private final String imagePath;

    private ImageWriter(String imagePath) {
        this.imagePath = imagePath;
    }

    public static ImageWriter newImageWriter(String imagePath) {
        return new ImageWriter(imagePath);
    }

    /**
     * 从输入流写入文件到目录下
     *
     * @param stream request输入流
     * @throws IOException 写入异常
     */
    public void writeImage(InputStream stream) throws IOException {

        FileOutputStream fos = new FileOutputStream(imagePath);
        byte[] bbuf = new byte[32];
        int hasRead = 0;

        // 将文件写入服务器的硬盘上
        while ((hasRead = stream.read(bbuf)) > 0) {
            fos.write(bbuf, 0, hasRead);
        }

        fos.close();
        stream.close();

        Byte n;
        // read the temp file
        RandomAccessFile random = new RandomAccessFile(imagePath, "r");
        // read line2 to find the name of the upload file.
        int second = 1;
        String secondLine = null;
        while (second <= 2) {
            secondLine = random.readLine();
            second++;
        }
        // get the last location of the dir char.'\\'
        int position = secondLine.lastIndexOf('\\');
        // get the name of the upload file.
        String fileName = secondLine.substring(position + 1, secondLine.length() - 1);
        // relocate to the head of file
        random.seek(0);
        // get the location of the char.'Enter' in Line4.
        long forthEndPosition = 0;
        int forth = 1;
        while ((n = random.readByte()) != -1 && (forth <= 4)) {
            if (n == '\n') {
                forthEndPosition = random.getFilePointer();
                forth++;
            }
        }

        RandomAccessFile random2 = new RandomAccessFile(imagePath, "rw");
        // locate the end position of the content.Count backwards 6 lines
        random.seek(random.length());
        long endPosition = random.getFilePointer();
        long mark = endPosition;
        int j = 1;

        endPosition = getEndPosition(random, endPosition, mark, j);

        // locate to the begin of content.Count for 4 lines's end position.
        random.seek(forthEndPosition);
        long startPoint = random.getFilePointer();
        // read the real content and write it to the realFile.
        while (startPoint < endPosition - 1) {
            n = random.readByte();
            random2.write(n);
            startPoint = random.getFilePointer();
        }
        random.close();
        random2.close();
    }

    private static long getEndPosition(RandomAccessFile random, long endPosition, long mark, int j) throws IOException {
        Byte n;
        while ((mark >= 0) && (j <= 6)) {
            mark--;
            random.seek(mark);
            n = random.readByte();
            if (n == '\n') {
                endPosition = random.getFilePointer();
                j++;
            }
        }
        return endPosition;
    }
}
