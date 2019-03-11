package pers.fancy.frame4j.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fancy
 */
public class FileGet {
    public void traverseFolder1(String path) {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    System.out.println(file2.getAbsolutePath());
                    list.add(file2);
                    folderNum++;
                } else {
                    System.out.println(file2.getAbsolutePath());
                    fileNum++;
                }
            }

            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println(file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
                        System.out.println(file2.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
            System.out.println("");
        }
        System.out.println(folderNum + fileNum);

    }

    public void traverseFolder2(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("�ļ����ǿյ�!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("�ļ���:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("�ļ�:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("");
        }
    }

    public static List<File> filelist = new LinkedList<>();

    public static List<File> getFileList(String strPath) {

        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath());
                } else if (fileName.endsWith("java")) {
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                } else {
                    continue;
                }
            }

        }
        return filelist;
    }

    public static void main(String[] args) {
        System.out.println(getFileList("d:/src").size());
    }
}
