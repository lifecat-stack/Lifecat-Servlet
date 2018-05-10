package com.wang.android;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @name AndroidUpImage
 * @description 从Android端接收数据
 * @auther
 */
public class AndroidUpImage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取客户端传过来图片的二进制流
            InputStream stream = req.getInputStream();

            //以当前时间戳为图片命名
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String strCurrentTime = df.format(new Date());

            String imagePath = "D:\\Java\\lifecatweb\\web\\upimage\\" + strCurrentTime + ".jpg";

            FileOutputStream fos = new FileOutputStream(imagePath);
            byte[] bbuf = new byte[32];
            int hasRead = 0;
            while ((hasRead = stream.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);//将文件写入服务器的硬盘上
            }
            fos.close();
            stream.close();

            /*
             *  但是需要注意，采用这种原始的方式写入文件时，你会发现被写入的文件内容前4行并非是读取文件的真正内容，
             * 从第四行开始才是正文数据。第二行是文件路径以及名称。所以通常的做法是，先将文件写入临时文件中，然后
             * 再采用RandomAccessFile读取临时文件的第四行以后部分。写入到目标文件中。
             */

            Byte n;
            //read the temp file
            RandomAccessFile random = new RandomAccessFile(imagePath, "r");
            //read line2 to find the name of the upload file.
            int second = 1;
            String secondLine = null;
            while (second <= 2) {
                secondLine = random.readLine();
                second++;
            }
            //get the last location of the dir char.'\\'
            int position = secondLine.lastIndexOf('\\');
            //get the name of the upload file.
            String fileName = secondLine.substring(position + 1, secondLine.length() - 1);
            //relocate to the head of file
            random.seek(0);
            //get the location of the char.'Enter' in Line4.
            long forthEndPosition = 0;
            int forth = 1;
            while ((n = random.readByte()) != -1 && (forth <= 4)) {
                if (n == '\n') {
                    forthEndPosition = random.getFilePointer();
                    forth++;
                }
            }

            RandomAccessFile random2 = new RandomAccessFile(imagePath, "rw");
            //locate the end position of the content.Count backwards 6 lines
            random.seek(random.length());
            long endPosition = random.getFilePointer();
            long mark = endPosition;
            int j = 1;
            while ((mark >= 0) && (j <= 6)) {
                mark--;
                random.seek(mark);
                n = random.readByte();
                if (n == '\n') {
                    endPosition = random.getFilePointer();
                    j++;
                }
            }

            //locate to the begin of content.Count for 4 lines's end position.
            random.seek(forthEndPosition);
            long startPoint = random.getFilePointer();
            //read the real content and write it to the realFile.
            while (startPoint < endPosition - 1) {
                n = random.readByte();
                random2.write(n);
                startPoint = random.getFilePointer();
            }
            random.close();
            random2.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
