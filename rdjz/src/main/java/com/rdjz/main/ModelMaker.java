package com.rdjz.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rdjz.common.db.utils.DatabaseMetaDateApplication;
import com.rdjz.common.db.utils.FileUtil;
import com.rdjz.common.db.utils.TemplateUtil;
import com.rdjz.common.db.utils.Util;

public class ModelMaker {


	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws Exception{
		File file = new File("F:/xiaoming/long/d");
		System.out.println(file.exists());
	}

	public static void maker(String tableName, String classPackage,String modelFinalPath) throws IOException {
		String className = Util.upperFirst(Util.to(tableName));
		String property = makeMapper(tableName);
		Map<String, String> param = new HashMap<String, String>();
//		param.put("author", System.getProperty("user.name") );
		param.put("author", "saltedfish");
		param.put("nowTimeString",simpleDateFormat.format(new Date()));
		
		param.put("property", property);
		param.put("className", className);
		param.put("package", classPackage);
		String content = FileUtil.getContent(Util.getTemplatePath() + "/ModelDemo.java");
		content = TemplateUtil.merge(content, param);
		String fileName = modelFinalPath + "/" + className + ".java";
		FileUtil.deleteFileIfExists(new File(fileName));
		if (!new File(modelFinalPath).exists())
			new File(modelFinalPath).mkdirs();
		FileUtil.writeOnce(fileName, content);
	}

	private static String makeMapper(String tableName) {
		DatabaseMetaDateApplication metaData = DatabaseMetaDateApplication.get();
		DatabaseMetaDateApplication.Table table = metaData.getTableColumns(null, tableName);
		return make(tableName, table);
	}

	private static String make(String tableName, DatabaseMetaDateApplication.Table table) {
		String string = "";
		String getSeter = "";
		for (DatabaseMetaDateApplication.Column column : table.columns) {
			//String tmpPropertys = "\n\t/** \n\t/* " "\n\t**/" + //
			String tmpPropertys = "\n\t@ApiModelProperty(value = \""+ column.desc + "\")\n\t" + //
					"\tprivate {type} {columnValue};\n";
			String type = "";
			if ("text".equalsIgnoreCase(column.type) || "varchar".equalsIgnoreCase(column.type)) {
				type = "String";
			} else if ("datetime".equalsIgnoreCase(column.type) || "date".equalsIgnoreCase(column.type)) {
				type = "Date";
			} else if ("int".equalsIgnoreCase(column.type)||"TINYINT".equalsIgnoreCase(column.type)) {
				type = "Integer";
			} else if ("bigint".equalsIgnoreCase(column.type)) {
				type = "Long";
			} else if ("double".equalsIgnoreCase(column.type)) {
				type = "Double";
			} else if ("float".equalsIgnoreCase(column.type)) {
				type = "Float";
			}
			tmpPropertys = tmpPropertys.replace("{type}", type);
			tmpPropertys = tmpPropertys.replace("{columnValue}", Util.to(column.name));
			string += tmpPropertys;
			String tmpGetSeter = "\n\tpublic {type} get{upperName}() {" + //
					"\n\t\treturn {name};" + //
					"\n\t}" + //
					"\n\n\tpublic void set{upperName}({type} {name}) {" + //
					"\n\t\tthis.{name} = {name};" + //
					"\n\t}\n";
			tmpGetSeter = tmpGetSeter.replace("{type}", type);
			tmpGetSeter = tmpGetSeter.replace("{name}", Util.to(column.name));
			tmpGetSeter = tmpGetSeter.replace("{upperName}", Util.upperFirst(Util.to(column.name)));
			getSeter += tmpGetSeter;
		}
		return string + getSeter;
	}

}
