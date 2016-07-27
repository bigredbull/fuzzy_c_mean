package fcm;

import java.io.IOException;
import java.text.DecimalFormat;

import com.mathworks.toolbox.javabuilder.MWException;




public class FcmCal {

	public static void main(String[] args) throws IOException, MWException	  //��try-catch
	{
		GetLines gl=new GetLines();
		GetColumns gc=new GetColumns();
		
		int lines=gl.getTextLines("resource/matrix.txt");
		int columns=gc.getTextcolumns(gl.getTextLines("resource/matrix.txt"),"resource/matrix.txt");
		int lines1=gl.getTextLines("resource/membership_matrix.txt");
		int columns1=gc.getTextcolumns(gl.getTextLines("resource/membership_matrix.txt"),"resource/membership_matrix.txt");
		int c=lines1;//�趨��������
		double e=0.01;//�趨ֹͣ��ֵ
		int itr=20;	//itrΪ�����������
		
		Mtr m1=new Mtr(lines,columns);
		Mtr m2=new Mtr(lines1,columns1);
		
		double[][] matrix=m1.setMatrix("resource/matrix.txt");  //���벢�ҳ�ʼ������
		double[][] membership_matrix=m2.setMatrix("resource/membership_matrix.txt"); 
		
		
		//**************************************************************
		System.out.println("ԭʼ���ݾ���Ϊ��");
		for(int i=0;i<lines;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		//*************************************************************		
		for(int i=1;i<itr;i++) //itr-1Ϊ�����������
		{
			System.out.println("��"+i+"�ε�������������Ϊ��");
			for(int j=0;j<lines1;j++)
			{
				for(int k=0;k<columns1;k++)
				{
					System.out.print(membership_matrix[j][k]+" ");
				}
				System.out.println();
			}
			System.out.println("��"+i+"�ε����õ������ľ���Ϊ��");
			ClassCenter cc=new ClassCenter(c,lines,columns,lines1,columns1,matrix,membership_matrix);
			double[][] membership_matrix1=cc.set_centerVec();//�������������
			
			System.out.println("��"+i+"�ε����õ��㵽�����ľ������Ϊ��");
			CenterDistance cd=new CenterDistance(c,lines,columns,lines1,columns1,matrix,membership_matrix1);
			double[][] centerDistc_matrix=cd.set_centerDistc();//����㵽�����ľ���
			
			System.out.println("��"+i+"�ε����õ��㵽�µ���������Ϊ��");
			CenterMembership cm=new CenterMembership(c,columns1,centerDistc_matrix);
			double[][] centerMembership_matrix=cm.set_centerMem();//����㵽�����ľ���
			
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
			 * ���ǰ���������������ֵ*/
			DecimalFormat df = new DecimalFormat("0.000");//ȡС�������λ
			System.out.println("u("+i+")-u("+(i-1)+")Ϊ��");
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
				System.out.println("����ֹͣ��"+"\n"+"���վ�����������Ϊ��");
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
			membership_matrix=centerMembership_matrix;//���¸���������ֵ
			
		}
		
	}		
}

