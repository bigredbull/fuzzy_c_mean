package fcm;

public class CenterDistance 
{
	int lines=0;
	int columns=0;
	int lines1=0;
	int columns1=0;
	int c=0;
	double[][] matrix;
	double[][] membership_matrix1;
	
	public CenterDistance(int c,int lines,int columns,int lines1,int columns1,double[][] matrix,double[][] membership_matrix1)
	{
		this.lines=lines;
		this.columns=columns;
		this.lines1=lines1;
		this.columns1=columns1;
		this.c=c;
		this.matrix=matrix;
		this.membership_matrix1=membership_matrix1;
		
	}
	
	public double[][] set_centerDistc()
	{
		double[][] cd=new double[c][columns1];	//3为指定类别,cv为隶属矩阵
		double[][] sqr_min_sum=new double[c][columns1];
		
		
		for(int i=0;i<c;i++)  //c=3
			for(int j=0;j<columns1;j++)	//columns1=10
			{				
				for(int k=0;k<columns;k++)	//columns=4
				{
					sqr_min_sum[i][j]=sqr_min_sum[i][j]+(matrix[j][k]-membership_matrix1[i][k])*(matrix[j][k]-membership_matrix1[i][k]);
				}
				cd[i][j]=Math.sqrt(sqr_min_sum[i][j]);
			}
//		System.out.println("每个数据点到类 中心的距离为：");
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<columns1;j++)
			{
				System.out.print(cd[i][j]+" ");
			}
			System.out.println();
		}
		return cd;
		
	}
}
