package demo;

import java.io.File;

import util.JSoupUtil;

public class demo {

	public static void main(String[] args) {
		String filePath = "E:" + File.separator + "eclipse" + File.separator + "workspace" + File.separator + "JsoupDemo" + File.separator + "src" + File.separator + "html" + File.separator + "NewFile.html";
		JSoupUtil.appendEle(filePath);
	}
	
}
