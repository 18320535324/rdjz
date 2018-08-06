package com.rdjz.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rdjz.common.db.utils.FileUtil;
import com.rdjz.common.db.utils.TemplateUtil;
import com.rdjz.common.db.utils.Util;

public class ActionMaker {

	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void maker(String tableName,String classPackage,String servicePackage,String actionPackage,String actionSavePath) throws IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("tableName", tableName);
		param.put("classNameProperty", Util.to(tableName));
		param.put("className", Util.upperFirst(Util.to(tableName)));
		param.put("author", System.getProperty("user.name") );
		param.put("nowTimeString", simpleDateFormat.format(new Date()));
		param.put("servicePackage", servicePackage);
		param.put("actionPackage", actionPackage);
		param.put("classPackage", classPackage);
		param.put("actionSavePath", actionSavePath);
		String content = FileUtil.getContent(Util.getTemplatePath()+"/ActionDemo.java");
		content = TemplateUtil.merge(content, param);
		String fileName = Util.getSavePath(actionSavePath,actionPackage)+"/" + Util.upperFirst(Util.to(tableName)) + "Action.java";
		FileUtil.deleteFileIfExists(new File(fileName));
		FileUtil.writeOnce(fileName, content);
	}

}
