package com.wang.service;

import com.wang.bean.User;
import com.wang.util.HOST;
import com.wang.util.MyDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * ImageServlet
 * <p>
 * 获取图片数据写入服务器文件目录下
 *
 * @auther ten
 */
public class UpImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 将图片写入服务器文件夹,并保存到数据库中
     * <p>
     * 1. 获取二进制输入流
     * 2. 获取图片存储目录: user_id
     * 3. 获取图片存储命名: date
     * <p>
     * 4. 检查目录是否存在 ? 通过 : 创建目录
     * 5. 获取图片完整路径,写入图片
     * <p>
     * 6. 上传完后跳转界面
     *
     * @throws
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1. 获取二进制输入流
            InputStream stream = req.getInputStream();

            //2. 获取图片存储目录: user_id
            int user_id = ((User) req.getSession().getAttribute("user")).getId();
            String directoryname = HOST.IMAGE_PATH + user_id;

            //3. 获取图片存储命名: date
            String date = MyDate.getInstance().getCurrentTime();
            String imagename = date + ".jpg";

            //4. 检查目录是否存在 ? 通过 : 创建目录
            File directory = new File(directoryname);
            if (!directory.exists()) {
                directory.mkdir();
            }

            //5. 获取图片完整路径,写入图片
            String imagePath = directoryname + "/" + imagename;

            FileOutputStream fos = new FileOutputStream(imagePath);
            byte[] bbuf = new byte[32];
            int hasRead = 0;

            //将文件写入服务器的硬盘上
            while ((hasRead = stream.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
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
            //6. 上传完后跳转界面
            resp.sendRedirect(HOST.PAGE_IMAGESHOW);
        }

    }
}
