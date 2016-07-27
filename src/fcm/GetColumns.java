package fcm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetColumns
{

	public int getTextcolumns(int lines,String path)
	{
		String[][] t=new String[lines][];
		int l=0;
		BufferedReader br=null;
		try
		{
			//读取文件，路径是txt文件路径
			br=new BufferedReader(new FileReader(new File(path)));
			String str=null;
			//按行读取
			while((str=br.readLine())!=null)
			{
				t[l]=str.split(" +");
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
		return t[0].length;
	}
}
