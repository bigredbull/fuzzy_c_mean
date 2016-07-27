package fcm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetLines
{
	
	public  int  getTextLines(String path) throws IOException 
	{
		int lines=0;
		BufferedReader br1=null;
		// 定义文件路径
		//这里定义一个字符流的输入流的节点流，用于读取文件（一个字符一个字符的读取）
		try
		{//不try-catch会提示错误
			br1=new BufferedReader(new FileReader(new File(path))); // 在定义好的流基础上套接一个处理流，用于更加效率的读取文件（一行一行的读取）
			while(br1.readLine() != null) 
			{ // readLine()方法是按行读的，返回值是这行的内容
				lines++; // 每读一行，则变量x累加1
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return lines;
	}
}
