package cn.gsq.run;

import java.io.File;
import java.util.Scanner;

/**
 * @author qsefr
 * @program: filemove
 * @description: 移动文件夹,防止双重文件夹包含文件
 * @date 2021-03-27 15:26:13
 */
public class FileMove {
    //文件夹根路径
    private  String filePath = "";

    public void run() {
        System.out.println("请输入路径:");
        Scanner scanner = new Scanner(System.in);
        filePath = scanner.nextLine();
        //根目录
        File fileRoot = new File(filePath);
        //获取所有文件夹
        File[] fileAll = fileRoot.listFiles();
        if (fileAll != null) {
            //file 根目录下的每个文件夹
            for (File file:
                    fileAll) {
                File[] files = file.listFiles();
                File fileSec=files[0];
                //判断是否有这个文件夹
                if (fileSec.isDirectory()) {
                    File[] fileTh = fileSec.listFiles();
                    for (File fileT:
                            fileTh) {
                        fileT.renameTo(new File(file.getAbsolutePath() + "\\" + fileT.getName()));
                        System.out.println("文件"+fileSec.getAbsolutePath()+fileT.getName()+"以移动");
                        System.out.println("文件夹以移动完成");
                        if (fileSec.delete()) {
                            System.out.println("文件夹删除完成");
                        }
                    }
                }
            }
        }

    }

}