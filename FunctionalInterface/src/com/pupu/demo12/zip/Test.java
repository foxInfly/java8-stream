package com.pupu.demo12.zip;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lipu
 * @since 2020-08-25 14:03:33
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String pathname = "C:\\Users\\Administrator\\Desktop\\temp\\111";
        List<File> files = ZipUtil.getAllFiles(new File(pathname));
        System.out.println("files: "+files);

        String dstPath = "C:\\Users\\Administrator\\Desktop\\temp\\解压缩文件夹";
        String relativePath = ZipUtil.getRelativePath(dstPath, new File("C:\\Users\\Administrator\\Desktop\\temp\\111.zip"));
        System.out.println(relativePath);


        String fileName = "";
        File file = ZipUtil.createFile(dstPath, pathname);
        System.out.println(file);

    }
}
