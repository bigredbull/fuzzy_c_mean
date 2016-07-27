package fcm;

public class ClassCenter 
{
	int lines=0;
	int columns=0;
	int lines1=0;
	int columns1=0;
	int c=0;
	double[][] matrix;
	double[][] matrix_tr;
	double[][] membership_matrix;
	
	public ClassCenter(int c,int lines,int columns,int lines1,int columns1,double[][] matrix,double[][] membership_matrix)
	{
		this.lines=lines;
		this.columns=columns;
		this.lines1=lines1;
		this.columns1=columns1;
		this.c=c;
		this.matrix=matrix;
		this.membership_matrix=membership_matrix;
		
	}
		
	public double[][] set_centerVec()
	{
		double[][] cv=new double[c][columns1];	//3为指定类别,cv为隶属矩阵
		double[] sqr_sum=new double[c];
		double[][] sqr_mul_sum=new double[c][columns];
		
		matrix_tr= new double[matrix[0].length][matrix.length];
		for(int i = 0;i < matrix[0].length;i++)
		{
			for(int j = 0;j < matrix.length;j++)
			{
				matrix_tr[i][j] = matrix[j][i];
			}
		}
		
		for(int i=0;i<c;i++)
			for(int j=0;j<columns1;j++)
			{
				sqr_sum[i]=sqr_sum[i]+membership_matrix[i][j]*membership_matrix[i][j];
			}

		
		for(int i=0;i<c;i++)
			for(int j=0;j<columns;j++)
			{				
				for(int k=0;k<columns1;k++)
				{
					sqr_mul_sum[i][j]+=matrix_tr[j][k]*membership_matrix[i][k]*membership_matrix[i][k];
				}
				cv[i][j]=sqr_mul_sum[i][j]/sqr_sum[i];
			}

		for(int i=0;i<c;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.print(cv[i][j]+" ");
			}
			System.out.println();
		}
		return cv;
		
	}
}
