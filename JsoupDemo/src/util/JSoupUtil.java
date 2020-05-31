package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupUtil {

	//ͨ��url����html�ļ�
	public static String loadByUrl(String url) {
		String title = null;
		try {
			if(url != null && !"".equals(url)) {
				Connection conn = Jsoup.connect(url);
				Document doc = conn.get();
				title = doc.title();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return title;
	}
	
	//�Լ�������html�ļ�
	public static String loadFile() {
		String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		String title = doc.title();
		return title;
	}
	
	//ͨ��file����html�ļ�
	public static String loadByFilePath(String filePath) {
		String title = null;
		File file = new File(filePath);
		if(file.exists()) {
			Document doc;
			try {
				doc = Jsoup.parse(file, "utf-8");
				title = doc.title();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return title;
	}
	
	//��ȡhtml�ļ�Ԫ��
	public static void getFileInfo(String filePath) {
        Document document = null;
        File file = new File(filePath);
        if(file.exists()) {
        	try {
    			document = Jsoup.parse(file, "utf-8");
    			String title = document.title();

    	        System.out.println("title :"+title);
    	        //��ȡhtml�е�head
    	        System.out.println(document.head());
    	        //��ȡhtml�е�body
    	        System.out.println(document.body());

    	        //��ȡHTMLҳ���е���������
    	        Elements eles = document.select("table[id=table]");
    	        for (Element ele : eles){
    	            System.out.println("html : "+ ele.html());
    	            System.out.println("text :"+ ele.text());
    	        }
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
	}
	
	public static void appendEle(String filePath) {
		Document document = null;
        File file = new File(filePath);
        if(file.exists()) {
        	try {
    			document = Jsoup.parse(file, "utf-8");
    			String title = document.title();

    	        System.out.println("title :"+title);
    	        //��ȡhtml�е�head
    	        System.out.println(document.head());
    	        //��ȡhtml�е�body
    	        System.out.println(document.body());

    	        //��ȡHTMLҳ���е���������
    	        Elements tableEle = document.select("table[id=table]");
    	        Elements tableBody = tableEle.select("tbody[id=tbody]");
    	        String tr = "<tr>"
    	        		  + "	<td>"
    	        		  + "		�ۿ�ص�"
    	        		  + "	</td>"
    	        		  + "</tr>";
    	        tableBody.append(tr);
    	        System.out.println(tableBody);
    	        String outFile = "E:" + File.separator + "eclipse" + File.separator + "workspace" + File.separator + "JsoupDemo" + File.separator + "src" + File.separator + "html" + File.separator + "test.html";
    	        FileOutputStream fos = new FileOutputStream(outFile, true);
    	        fos.write(document.html().getBytes("utf-8"));
    	        fos.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
	}
	
}
