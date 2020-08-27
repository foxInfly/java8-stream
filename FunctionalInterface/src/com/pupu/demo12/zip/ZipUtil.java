package com.pupu.demo12.zip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lipu
 * @since 2020-08-25 11:47:27
 */
public class ZipUtil {


    /**
     * 获取所有的文件
     *
     * @param srcFile 源文件
     * @return 所有的子文件放到一个list中
     */
    public static List<File> getAllFiles(File srcFile) {
        List<File> fileList = new ArrayList<>();

        Optional.ofNullable(srcFile.listFiles()).ifPresent(
                file -> {
                    List<File> collect = Arrays.stream(file).peek(
                            a -> {
                                if (a.isFile()) {
                                    fileList.add(a);
                                }
                                if (a.isDirectory()) {//若不是空目录，则递归添加其下的目录和文件
                                    if (a.length() > 0) {
                                        fileList.addAll(getAllFiles(a));
                                    } else {
                                        fileList.add(a);//若是空目录，则添加这个目录到fileList
                                    }
                                }
                            }
                    ).collect(Collectors.toList());
                }
        );




        /*for (int i = 0; i < tmp.length; i++) {

            if (tmp[i].isFile()) {
                fileList.add(tmp[i]);
                System.out.println("add file: " + tmp[i].getName());
            }

            if (tmp[i].isDirectory()) {
                if (tmp[i].listFiles().length != 0) {//若不是空目录，则递归添加其下的目录和文件
                    fileList.addAll(getAllFiles(tmp[i]));
                } else {//若是空目录，则添加这个目录到fileList
                    fileList.add(tmp[i]);
                    System.out.println("add empty dir: " + tmp[i].getName());
                }
            }
        }  */  // end for

        return fileList;
    }


    /**
     * 依据文件名和压缩源路径得到文件在压缩源路径下的相对路径
     *
     * @param dirPath 压缩原路径
     * @param file    要压缩的文件
     * @return String
     */
    public static String getRelativePath(String dirPath, File file) {
        System.out.println();
        System.out.println("执行getRelativePath(String dirPath, File file)...");
        File dir = new File(dirPath);
        String relativePath = file.getName();

        while (true) {
            file = file.getParentFile();

            if (file == null) {
                break;
            }

            if (file.equals(dir)) {
                break;
            } else {
                relativePath = file.getName() + "/" + relativePath;
            }
        }    // end while

        return relativePath;
    }

    /**
     * 创建文件：
     * 根据压缩包内文件名和解压缩目的路径，创建解压缩目标文件，生成中间目录
     *
     * @param dstPath  解压缩目的路径
     * @param fileName 压缩包的文件名
     * @return File
     */
    public static File createFile(String dstPath, String fileName) throws IOException {
        System.out.println();
        System.out.println("执行createFile(String dstPath, String fileName)...");

        String[] dirs = fileName.split("\\\\");//将文件名的各级目录分解
        File file = new File(dstPath);

        if (dirs.length > 1) {//文件有上级目录
            for (int i = 0; i < dirs.length - 1; i++) {
                file = new File(file, dirs[i]);//依次创建文件对象直到文件的上一级目录
            }

            if (!file.exists()) {
                file.mkdirs();//文件对应目录若不存在，则创建
                System.out.println("mkdirs: " + file.getCanonicalPath());
            }

            file = new File(file, dirs[dirs.length - 1]);//创建文件

            return file;
        } else {
            if (!file.exists()) {
                file.mkdirs();//若目标路径的目录不存在，则创建
                System.out.println("mkdirs: " + file.getCanonicalPath());
            }

            file = new File(file, dirs[0]);//创建文件

            return file;
        }
    }
}
