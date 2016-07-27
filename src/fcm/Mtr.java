package fcm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public  class Mtr
{

	int lines=0;
	int columns=0;
	String path=null;
	double[][] matrix=new double[1][1];
	String[][] tmp=new String[1][1];

	public Mtr(int lines,int columns) throws IOException  //��Ҫ�������캯�������쳣����//��Ҫ�������캯�������쳣����������Ϣ˵�ĺ���ȷ����Ϊ���쳣��Ҫ�������붨��һ����ʽ�Ĺ��췽������Ϊ���getContent�������׳��쳣����word_text��Ϊһ����Ա���������˸÷�����ֵ�����������ֻ��Ĭ�ϵĹ��췽����Ҳ����˵���ڹ�����CV�Ķ���ʱʵ�ʵ�������getContent����ȴû�д����������׳����쳣��������Ҫ��ʽ����һ�����췽��:�����Ϳ����ˡ�����getContent�������׳��쳣�������ڷ����ڽ���try catch�����쳣��
	{	
		this.lines=lines;
		this.columns=columns;
		this.matrix=new double[lines][columns];
		this.tmp=new String[lines][columns];
	}
	
	
	public  double[][] setMatrix(String path) throws IOException
	{
		int l=0;
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		try
		{
			//��ȡ�ļ���·����txt�ļ�·��
			String str="";
			fis=new FileInputStream(path);
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			//���ж�ȡ
			while((str=br.readLine())!=null)
			{
				tmp[l]=str.split(" +");
				l++;
			}
			//ת��
			for(int i=0;i<lines;i++)
			{
				for(int j=0;j<columns;j++)
					matrix[i][j]= Double.parseDouble(tmp[i][j]);
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

		return matrix;
	}
	
	
}