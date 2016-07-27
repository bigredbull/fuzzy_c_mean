package fcm;

import java.text.DecimalFormat;

public class CenterMembership 
{
	int columns1=0;
	int c=0;
	double[][] centerDistc_matrix;
	double[][] centerDistc_matrix_tr;


	
	public CenterMembership(int c,int columns1,double centerDistc_matrix[][])
	{
		this.columns1=columns1;
		this.c=c;
		this.centerDistc_matrix=centerDistc_matrix;
		
	}
	
	public double[][] set_centerMem()
	{
		double[][] cm=new double[c][columns1];	//3Ϊָ�����,cvΪ��������
		double[][] sqr_div_sum=new double[c][columns1];
		
		/*
		 * ����ת��*/
		centerDistc_matrix_tr= new double[centerDistc_matrix[0].length][centerDistc_matrix.length];
		for(int i = 0;i < centerDistc_matrix[0].length;i++)
		{
			for(int j = 0;j < centerDistc_matrix.length;j++)
			{
				centerDistc_matrix_tr[i][j] = centerDistc_matrix[j][i];
			}
		}
		
		for(int i=0;i<c;i++)  //c=3
			for(int j=0;j<columns1;j++)	//columns1=10
			{				
				for(int k=0;k<c;k++)	//columns=4
				{
					sqr_div_sum[i][j]=sqr_div_sum[i][j]+(centerDistc_matrix[i][j]/centerDistc_matrix[k][j])*(centerDistc_matrix[i][j]/centerDistc_matrix[k][j]);
				}
				cm[i][j]=1/(sqr_div_sum[i][j]);
			}
//		System.out.println("ÿ�����ݵ㵽�� ���ĵľ���Ϊ��");
		
		DecimalFormat df = new DecimalFormat("0.000");//ȡС�������λ
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<columns1;j++)
			{
				System.out.print(df.format(cm[i][j])+"    ");
			}
			System.out.println();
		}		
		
		
		/*
		 * �˴�Ϊ����python �����ʽ�����*/
//		System.out.print("([");
//		for(int i=0;i<c;i++)
//		{
//			if(i<c-1)
//			{
//				System.out.print("[");
//				for(int j=0;j<columns1;j++)
//				{
//					if (j<columns1-1)
//						System.out.print(cm[i][j]+",");
//					else
//						System.out.print(cm[i][j]);
//					
//				}
//				System.out.print("]");
//				System.out.print(",");
//			}
//			else
//			{
//				System.out.print("[");
//				for(int j=0;j<columns1;j++)
//				{
//					if (j<columns1-1)
//						System.out.print(cm[i][j]+",");
//					else
//						System.out.print(cm[i][j]);
//					
//				}
//				System.out.print("]");
//			}		
//		}
//		System.out.print("])");
//		System.out.println();
		
		
		
//		System.out.println(centerDistc_matrix_tr[columns1-1][c-1]);
		return cm;
		
	}
}
