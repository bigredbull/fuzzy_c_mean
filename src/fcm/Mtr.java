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

	public Mtr(int lines,int columns) throws IOException  //需要建立构造函数进行异常处理，//需要建立构造函数进行异常处理，报错信息说的很明确：因为有异常需要处理，必须定义一个显式的构造方法。因为你的getContent方法有抛出异常，而word_text作为一个成员变量利用了该方法赋值，但是你的类只有默认的构造方法，也就是说你在构造类CV的对象时实际调用了了getContent方法却没有处理它声明抛出的异常。所以你要显式定义一个构造方法:这样就可以了。或者getContent方法不抛出异常，而是在方法内进行try catch处理异常。
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
			//读取文件，路径是txt文件路径
			String str="";
			fis=new FileInputStream(path);
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			//按行读取
			while((str=br.readLine())!=null)
			{
				tmp[l]=str.split(" +");
				l++;
			}
			//转换
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