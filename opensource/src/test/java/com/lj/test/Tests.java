package com.lj.test;

import java.io.File;
import java.io.FilenameFilter;

public class Tests {

		public static void main(String[] args) {
			File f = new File("E:/apache-maven-3.0.2/repo/");
			String[] s = new String[]{"1","2","3","4"};
			go(f);
		}
		public static void go(File f){
			File[] filelist = f.listFiles();
			for(File m:filelist){
				if(m.isFile()){
					if(m.getName().endsWith("pom")){
						if(m.length()==813){
							System.out.println(m.getPath()+m.getName()+"---"+m.length()+"  "+m.getParentFile().getName());
							System.out.println(m.delete());
						}
					}
				}else{
					go(m);
				}
			
			}
		}
}
