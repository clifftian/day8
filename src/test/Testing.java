package test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Testing {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		System.out.println("���");

		Properties pro = new Properties();
		// ��ȡclasses Ŀ¼�µ������ļ�
		pro.load(new FileReader(
				"E:\\customization\\learning\\thinking\\bin\\jdbc\\config.properties"));
		System.out.println(pro.getProperty("host"));

	}

}
