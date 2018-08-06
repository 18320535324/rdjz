package com.rdjz.common.db.utils;

import java.io.File;

public class Util {

	public static String templatePath = "";

	/**
	 * column to property
	 * 
	 * @param columnName
	 * @return
	 */
	public static String to(String columnName) {
		if (!columnName.contains("_")) {
			return columnName;
		}
		String pre = columnName.substring(0, columnName.indexOf("_"));
		String sub = columnName.substring(columnName.indexOf("_") + 2);
		String word = columnName.substring(columnName.indexOf("_") + 1, columnName.indexOf("_") + 2);
		return to(pre + word.toUpperCase() + sub);
	}

	public static String upperFirst(String columnName) {
		String sub = columnName.substring(1);
		String word = columnName.substring(0, 1);
		return to(word.toUpperCase() + sub);
	}

	public static String getSavePath(String rootPath,String packageName){
		String s = packageName.replaceAll("\\.", "/");
		return rootPath+"/"+s;
	}

	public static  String getTemplatePath(){
		return Util.templatePath;
	}
	
	public static void setTemplatePath(String templatePath){
		Util.templatePath = templatePath;
	}

	public static String convertSlashPath(String path){
		String newPath = "";
		int indexOf = path.indexOf("/");
		if (indexOf == 0)
			path = path.substring(1);
		newPath = path.replaceAll("/", "\\.");
		return newPath;
	}
}
