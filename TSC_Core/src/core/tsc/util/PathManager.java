package core.tsc.util;

import java.io.File;
import java.io.IOException;

import core.tsc.ProjectID;

public abstract class PathManager {
	
	private static final String SRC_DIR = "src";
	private static final String TSC_DIR = "tsc";
	
	public final static String getCurrentPath(){
		try {
			return new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public final static String getWorkspacePath(){

		try {
			return new File("..").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public final static String getProjectPath(ProjectID id){
		switch (id) {
		case CORE:
			return getFullDir(new String[]{getWorkspacePath(), "TSC_Core", SRC_DIR, "core", TSC_DIR});
		case MAIN_APP:
			return getFullDir(new String[]{getWorkspacePath(), "TheSheldonChallenge", SRC_DIR, "javapp", TSC_DIR});
		case ANDROID:
			return getFullDir(new String[]{"data", "data", "app.tsc"});
		default:
			return null;
		}
	}
	
	public final static String getDir(String dirName){
		return dirName + File.separator;
	}
	
	public final static String getFullDir(String[] dirNames){
		String fullDir = "";
		for(String dir : dirNames){
			fullDir += getDir(dir);
		}
		return fullDir;
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentPath());
	} 

}
