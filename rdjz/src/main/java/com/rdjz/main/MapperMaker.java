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


public class MapperMaker {

	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void maker(String tableName, String classPackage,String mapperPackage,String mapperSavePath) throws IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("className", Util.upperFirst(Util.to(tableName)));
		param.put("author", System.getProperty("user.name") );
		param.put("nowTimeString", simpleDateFormat.format(new Date()));
		param.put("modelPackage",classPackage);
		param.put("mapperPackage", mapperPackage );
		String content = FileUtil.getContent(Util.getTemplatePath()+"/MapperDemo.java");
		content = TemplateUtil.merge(content, param);
		String fileName = Util.getSavePath(mapperSavePath,mapperPackage) +"/"+Util.upperFirst(Util.to(tableName)) + "Mapper.java";
		FileUtil.deleteFileIfExists(new File(fileName));
		FileUtil.writeOnce(fileName, content);
	}

}
