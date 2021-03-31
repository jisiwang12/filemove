package cn.gsq.run;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author qsefr
 * @program: filemove
 * @description: 删除jav目录下的poster文件
 * @date 2021-03-31 22:09:22
 */
public class FileDel {
    public static final String PATTERN = ".*poster.*";
    //运行方法，比较字符并删除文件
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入路径：");
        String path = scanner.nextLine();
        File file = new File(path);
        File[] files = file.listFiles();
        //二级目录
        for (File file1 : files) {
            //三级文件夹
            File[] files1 = file1.listFiles();
            for (File file2 : files1) {
                String fileName = file2.getName();
                if (Pattern.matches(PATTERN, fileName)) {
                    boolean delete = file2.delete();
                    if (delete) {
                        System.out.println("文件" + fileName + "已删除");
                    } else {
                        System.out.println("文件" + fileName + "删除失败");
                    }
                }
            }
        }
    }
}
