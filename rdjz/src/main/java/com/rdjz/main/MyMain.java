package com.rdjz.main;

import com.rdjz.common.db.utils.DatabaseMetaDateApplication;
import com.rdjz.common.db.utils.Util;

public class MyMain {
	public final static String jdbcDriver = "com.mysql.jdbc.Driver";
	public final static String jdbcUrl ="jdbc:mysql://127.0.0.1/rdjz?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull&amp;autoReconnect=true";
	public final static String jdbcUser = "root";
	public final static String jdbcPasswd = "123456";
	public final static String tableName = "saltedfish";
	
	/**
	 * 默认微服务结构，这个项目路径要直接配置
	 */
	public final static String projectPath = "G:/xiaofeng/workspace/workspace-saltedfish";
	public final static String templatePath = "/rdjz/src/main/resources/generator/demo";
	public final static String PackagePrefix = "/src/main/java";
	public final static String BASE_MODEL_PATH = "/com/rdjz/models";
	
	public static String mapperPathName = "/rdjz";
	public static String mapperPackage = "/com/rdjz";

	public static String modelPathName = "/rdjz";
	public static String modelPackage = "/com/rdjz";

	public static String servicePathName = "/rdjz";
	public static String servicePackage = "/com/rdjz";

	public static String serviceImplPathName = "/rdjz";
	public static String serviceImplPackage = "/com/rdjz";

	public static String controllerPathName = "/rdjz";
	public static String controllerPackage = "/com/rdjz";

	
	
	
	/**
	 * 默认的微服务结构
	 */
	private final static String MAPPER = "/mapper";
	public static String mapperFinalPath;
	
	private final static String MODEL = "/model";
	public static String MODEL_FINAL_PATH;
	
	private final static String SERVICE = "/service";
	public static String serviceFinalPath;
	
	public static String MODEL_FINAL_CLASS_NAME;
	
	private final static String SERVICE_IMPL = "/serviceimpl";
	public static String serviceImplFinalPath;
	
	private final static String CONTROLLER = "/controller";
	public static String controllerFinalPath;
	
	public static void main(String[] args) throws Exception {

		String moduleName = "shop";
		MyMain.initPath(moduleName);
		DatabaseMetaDateApplication.init(jdbcDriver,jdbcUrl,jdbcUser,jdbcPasswd);
		modelMaker(moduleName);
	}

	public static void initPath(String moduleName) {
		moduleName = "/" + moduleName;
		Util.setTemplatePath(projectPath + templatePath);
		MODEL_FINAL_PATH = projectPath + modelPathName + PackagePrefix + modelPackage + moduleName + MODEL;
		MODEL_FINAL_CLASS_NAME = Util.convertSlashPath(modelPackage + moduleName + MODEL);
		
		/*mapperFinalPath = projectPath + mapperPathName + PackagePrefix + mapperPackage + moduleName + MAPPER;
		serviceFinalPath = projectPath + servicePathName + PackagePrefix + servicePackage + moduleName + SERVICE;
		serviceImplFinalPath = projectPath + serviceImplPathName + PackagePrefix + serviceImplPackage + moduleName + SERVICE_IMPL;
		controllerFinalPath = projectPath + controllerPathName + PackagePrefix + controllerPackage + moduleName + CONTROLLER;*/
		System.out.println(MODEL_FINAL_PATH);
		/*System.out.println(mapperFinalPath);
		System.out.println(serviceFinalPath);
		System.out.println(serviceImplFinalPath);
		System.out.println(controllerFinalPath);*/
	}

	//生成Model
	public static void modelMaker(String moduleName) throws Exception {
		ModelMaker.maker(tableName, MODEL_FINAL_CLASS_NAME, MODEL_FINAL_PATH);
	}

	//生成mapper类
	/*public static void mapperMaker()  throws Exception {
        MapperMaker.maker(tableName, Util.convertSlashPath(modelPackage), Util.convertSlashPath(mapperPackage), mapperFinalPath);
	}

	//生成mapperXML
	public static void mapperXmlMaker() throws Exception {
        MapperXmlMaker.maker(tableName, Util.convertSlashPath(modelPackage), Util.convertSlashPath(mapperPackage), mapperXmlFinalPath);
	}

	 //生成service
	public static void serviceMaker() throws Exception {
        ServiceMaker.maker(tableName, Util.convertSlashPath(modelPackage), Util.convertSlashPath(mapperPackage), Util.convertSlashPath(servicePackage), serviceFinalPath);
	}

	 //生成serviceImpl
	public static void serviceImplMaker() throws Exception {
        ActionMaker.maker(tableName, Util.convertSlashPath(modelPackage), servicePackage, Util.convertSlashPath(actionPackage), actionFinalPath);
	}

	 //生成Controller
	public static void controllerMakerMaker() throws Exception {
        ControllerMaker.maker(tableName, Util.convertSlashPath(modelPackage), Util.convertSlashPath(mapperPackage), Util.convertSlashPath(controllerPackage), controllerFinalPath);
	}*/
}
