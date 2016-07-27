package fcm;

import java.io.IOException;
import java.text.DecimalFormat;

import com.mathworks.toolbox.javabuilder.MWException;




public class FcmCal {

	public static void main(String[] args) throws IOException, MWException	  //或try-catch
	{
		GetLines gl=new GetLines();
		GetColumns gc=new GetColumns();
		
		int lines=gl.getTextLines("resource/matrix.txt");
		int columns=gc.getTextcolumns(gl.getTextLines("resource/matrix.txt"),"resource/matrix.txt");
		int lines1=gl.getTextLines("resource/membership_matrix.txt");
		int columns1=gc.getTextcolumns(gl.getTextLines("resource/membership_matrix.txt"),"resource/membership_matrix.txt");
		int c=lines1;//设定分类数量
		double e=0.01;//设定停止阈值
		int itr=20;	//itr为至多迭代次数
		
		Mtr m1=new Mtr(lines,columns);
		Mtr m2=new Mtr(lines1,columns1);
		
		double[][] matrix=m1.setMatrix("resource/matrix.txt");  //读入并且初始化矩阵
		double[][] membership_matrix=m2.setMatrix("resource/membership_matrix.txt"); 
		
		
		//**************************************************************
		System.out.println("原始数据矩阵为：");
		for(int i=0;i<lines;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		//*************************************************************		
		for(int i=1;i<itr;i++) //itr-1为至多迭代次数
		{
			System.out.println("第"+i+"次迭代的隶属矩阵为：");
			for(int j=0;j<lines1;j++)
			{
				for(int k=0;k<columns1;k++)
				{
					System.out.print(membership_matrix[j][k]+" ");
				}
				System.out.println();
			}
			System.out.println("第"+i+"次迭代得到类中心矩阵为：");
			ClassCenter cc=new ClassCenter(c,lines,columns,lines1,columns1,matrix,membership_matrix);
			double[][] membership_matrix1=cc.set_centerVec();//输出类中心向量
			
			System.out.println("第"+i+"次迭代得到点到类中心距离矩阵为：");
			CenterDistance cd=new CenterDistance(c,lines,columns,lines1,columns1,matrix,membership_matrix1);
			double[][] centerDistc_matrix=cd.set_centerDistc();//输出点到类中心距离
			
			System.out.println("第"+i+"次迭代得到点到新的隶属矩阵为：");
			CenterMembership cm=new CenterMembership(c,columns1,centerDistc_matrix);
			double[][] centerMembership_matrix=cm.set_centerMem();//输出点到类中心距离
			
			double[][] min_matrix=new double[lines][columns1];
			for(int j=0;j<c;j++)
			{
				for(int k=0;k<10;k++)
				{
					min_matrix[j][k]=membership_matrix[j][k]-centerMembership_matrix[j][k];
				}
			}
			

			
			//***********************************************************************************
			/*
			 * 输出前后两步隶属矩阵差值*/
			DecimalFormat df = new DecimalFormat("0.000");//取小数点后三位
			System.out.println("u("+i+")-u("+(i-1)+")为：");
			System.out.print("([");
			for(int j=0;j<c;j++)
			{
				if(j<c-1)
				{
					System.out.print("[");
					for(int k=0;k<columns1;k++)
					{
						if (k<columns1-1)
							System.out.print(df.format(min_matrix[j][k])+",");
						else
							System.out.print(df.format(min_matrix[j][k]));
						
					}
					System.out.print("]");
					System.out.print(",");
				}
				else
				{
					System.out.print("[");
					for(int k=0;k<columns1;k++)
					{
						if (k<columns1-1)
							System.out.print(df.format(min_matrix[j][k])+",");
						else
							System.out.print(df.format(min_matrix[j][k]));
						
					}
					System.out.print("]");
				}		
			}
			System.out.print("])");
			System.out.println();
			//********************************************************************************
			
			MatNorms no=new MatNorms(c,columns1,min_matrix);
			double norm=no.cal_norm();
			if(norm<e)
			{
				System.out.println("计算停止！"+"\n"+"最终聚类隶属矩阵为：");
				for(int j=0;j<c;j++)
				{
					for(int k=0;k<columns1;k++)
					{
						System.out.print(centerMembership_matrix[j][k]+" ");
					}
					System.out.println();
				}
				break;
			}
			membership_matrix=centerMembership_matrix;//重新给隶属矩阵赋值
			
		}
		
	}		
}

