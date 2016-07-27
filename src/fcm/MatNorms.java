package fcm;

import norm_mat.*;
import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.MWException;



public class MatNorms 
{
	
	

	int columns1=0;
	int c=0;
	double d=0;
	double[][] membership_matrix;
	public MatNorms(int c,int columns1,double[][] membership_matrix)
	{
		this.columns1=columns1;
		this.c=c;
		this.membership_matrix=membership_matrix;
		
	}
	
	
	public  double cal_norm() throws MWException
	{
		MWNumericArray mwa = new MWNumericArray(membership_matrix, MWClassID.DOUBLE);
		NormMatlab mn=new NormMatlab();
		Object[] result = null; 		
		result=mn.calNorms(1,mwa);
		System.out.println("*********************·¶ÊýÎª£º"+result[0].toString());
		return Double.parseDouble(result[0].toString());
		
	}
	
}
