package com.hut.kenny.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class ImageUtil {

    /**
     * 上传图片，将图片存入target路径的同时存进本地
     * @param targetPath target路径
     * @param dir   存储在哪个文件夹下面
     * @param file
     * @return  返回图片名字
     */
    public static String upload(String targetPath, String dir, MultipartFile file) throws IOException {
        //D:\IdeaProjects\EpidemicControl-bbs\target\kenny\image
        //D:\IdeaProjects\EpidemicControl-bbs\src\main\webapp\image
        String realPath = targetPath.substring(0, targetPath.indexOf("target")) + "src\\main\\webapp\\image\\" + dir + "\\";
        targetPath = targetPath + "\\" + dir + "\\";
        System.out.println("rootPath: " + targetPath);
        File rootFolder = new File(targetPath);
        if(!rootFolder.exists()){   //如果上传文件的根目录不存在，就创建一个
            System.out.println("rootFolder.mkdirs()");
            rootFolder.mkdirs();
        }
        //获取上传的文件内容，写入目标文件中
        String currPath = ImageUtil.getFileName(file.getOriginalFilename());
        System.out.println(targetPath + "   " + realPath);

        inputStreamToFile(file.getInputStream(), new File(targetPath + currPath));
		inputStreamToFile(file.getInputStream(), new File(realPath + currPath));

//        File saveFile = new File(targetPath + currPath);
//        file.transferTo(saveFile);
//        saveFile = new File(realPath + currPath);
//
//        System.out.println(realPath + currPath);
//        file.transferTo(saveFile);

        return currPath;
    }

//    		this.inputStreamToFile((FileInputStream) multipartFile.getInputStream(), new File("D:\\study\\img\\b.jpg"));
//		this.inputStreamToFile((FileInputStream) multipartFile.getInputStream(), new File("D:\\study\\img\\c.jpg"));
    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getFileName(String fileName) {
        String headName = fileName.substring(0, fileName.indexOf("."));
        String endName = fileName.substring(fileName.indexOf("."));
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        return headName + name + endName;
    }
}
