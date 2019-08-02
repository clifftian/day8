package com.day8.io;
import java.io.*;

/**
 * @author ftian
 *
 */
public class TestIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//1.����Ϊ��λ��һ���ļ���ȡ���
		BufferedReader in = new BufferedReader( new FileReader("E:/share/windchill.log"));
		String s, s2 = new String();
		while((s = in.readLine()) != null)
		s2 += s + "\n";
		in.close();
		//System.out.println(s2);
		
		//1b. ���ռ��̵�����
		BufferedReader stdin = new BufferedReader(new InputStreamReader( System.in));
		//System.out.println("Enter a line:");
		//System.out.println(stdin.readLine());
		
		//2. ��һ��String�����ж�ȡ���
		StringReader in2 = new StringReader(s2);
		int c;
		try{
		while((c = in2.read()) != -1)
		//System.out.print((char)c);
		in2.close();
		}catch(Exception e)
		{
			System.out.println("Close stream");
		}

		//3. ���ڴ�ȡ����ʽ������
		try{
		DataInputStream in3 = new DataInputStream(new ByteArrayInputStream(s2.getBytes()));
		while(true)
		{
			System.out.print((char)in3.readByte());
		}
		}catch(Exception e){
			System.out.println("End of stream");
		}
		
		//4. ������ļ�
		try{
		BufferedReader in4 = new BufferedReader(new StringReader(s2));
		PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("E:/share/windchill1.log")));
		int lineCount = 1;
		while((s = in4.readLine()) != null)
		out1.println(lineCount++ + "��" + s);
		out1.close();
		in4.close ();
		}
		catch(EOFException ex){
		System.out.println("End of stream #4");
		}
		
//		5. ��ݵĴ洢�ͻָ�
		try{
		DataOutputStream out2 = 
		new DataOutputStream(
		new BufferedOutputStream(
		new FileOutputStream("E:/share/Data.txt")));
		out2.writeDouble(3.1415926);
		out2.writeChars("\nThas was pi:writeChars\n");
		out2.writeBytes("Thas was pi:writeByte\n");
		out2.close();
		DataInputStream in5 =
		new DataInputStream(
		new BufferedInputStream(
		new FileInputStream("E:/share/Data.txt")));
		BufferedReader in5br =
		new BufferedReader(
		new InputStreamReader(in5));
		System.out.println(in5.readDouble());
		System.out.println (in5br.readLine());
		System.out.println(in5br.readLine());
		}
		catch(EOFException e){
		System.out.println("End of stream");
		}

//		6. ͨ��RandomAccessFile�����ļ�
		RandomAccessFile rf =
		new RandomAccessFile("E:/share/rtest.dat", "rw");
		for(int i=0; i<10; i++)
		rf.writeDouble(i*1.414);
		rf.close();

		rf = new RandomAccessFile("E:/share/rtest.dat", "r");
		for(int i=0; i<10; i++)
		System.out.println("Value " + i + "��" + rf.readDouble());
		rf.close();

		rf = new RandomAccessFile("E:/share/rtest.dat", "rw");
		rf.seek(5*8);
		rf.writeDouble(47.0001 );
		rf.close();

		rf = new RandomAccessFile("E:/share/rtest.dat", "r");
		for(int i=0; i<10; i++)
		System.out.println("Value " + i + "��" + rf.readDouble());
		rf.close ();
		}
	}
