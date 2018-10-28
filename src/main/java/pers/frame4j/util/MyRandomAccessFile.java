package pers.frame4j.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public class MyRandomAccessFile {

	public static List<File> filelist = new LinkedList<File>();

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
					files[i].delete();
					System.out.println("ɾ���ɹ�");
					continue;
				}
			}

		}
		return filelist;
	}

	public static void delNote(File file) {
		
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			System.out.println("���سɹ�");
			String ss = null;
			while ((ss = raf.readLine()) != null) {

				if (ss.contains("//")) {
					System.out.println("��ʼ�滻");
					int location = ss.indexOf("//");
					String ss2 = ss.substring(location);
					long i = raf.getFilePointer();
					raf.seek(i - ss2.length() - 2);

					int targetLength = ss2.length();

					StringBuilder sb = new StringBuilder();
					for (int a = 0; a < targetLength; a++) {
						sb.append(" ");
					}
					sb.append("\r\n");
					raf.writeBytes(sb.toString());
					System.out.println("going");

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		List<File> list = getFileList("d:/src");
		for (File file : list) {
			delNote(file);
		}
	}
}