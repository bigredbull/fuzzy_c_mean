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
		// �����ļ�·��
		//���ﶨ��һ���ַ������������Ľڵ��������ڶ�ȡ�ļ���һ���ַ�һ���ַ��Ķ�ȡ��
		try
		{//��try-catch����ʾ����
			br1=new BufferedReader(new FileReader(new File(path))); // �ڶ���õ����������׽�һ�������������ڸ���Ч�ʵĶ�ȡ�ļ���һ��һ�еĶ�ȡ��
			while(br1.readLine() != null) 
			{ // readLine()�����ǰ��ж��ģ�����ֵ�����е�����
				lines++; // ÿ��һ�У������x�ۼ�1
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
