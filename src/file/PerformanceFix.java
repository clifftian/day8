package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerformanceFix {

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("F:\\temp\\hosts");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("F:\\temp\\hosts.tmp");
		BufferedWriter bw = new BufferedWriter(fw);

		boolean isFound = false;
		Pattern pattern = Pattern.compile("\\s*.*127\\.0\\.0\\.1.*localhost.*",
				Pattern.CASE_INSENSITIVE);

		String str;
		while ((str = br.readLine()) != null) {
			Matcher m = pattern.matcher(str);
			if (m.find()) {
				isFound = true;
				str = str
						.concat(" ajax.googleapis.com  stats.g.doubleclick.net  use.typekit.net  s2826.t.eloqua.com	c.na10.visual.force.com");
			}
			bw.write(str);
			bw.newLine();
		}

		if (!isFound)
			bw.write("127.0.0.1       localhost	 ajax.googleapis.com  stats.g.doubleclick.net  use.typekit.net  s2826.t.eloqua.com	c.na10.visual.force.com");

		br.close();
		bw.close();

		File realName = new File("F:\\temp\\hosts");
		realName.delete();
		new File("F:\\temp\\hosts.tmp").renameTo(realName);

	}

}
