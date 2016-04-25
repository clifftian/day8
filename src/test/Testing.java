package test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Testing {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		System.out.println("你好");

		Properties pro = new Properties();
		// 读取classes 目录下的配置文件
		pro.load(new FileReader(
				"E:\\customization\\learning\\thinking\\bin\\jdbc\\config.properties"));
		System.out.println(pro.getProperty("host"));

	}

}
