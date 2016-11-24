/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc_project;

/* @author SIDHARTHA */

public class solve {
    static int noOfPara(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                count++;
        }
        return count;
    }
    
    static String valueOf(String str)
    {
    	int i,j,k;
    	float tempx,tempy;
    	// code to solve ^
    	for(i=str.length()-1;i>=0;i--)
    	{
    		if(str.charAt(i)=='^')
    		{
    			for(j=i-1;j>=0;j--)
    			{
    				if(syntax.isOperator(str.charAt(j)))
    					break;
    			}
    			for(k=i+1;k<str.length();k++)
    			{
    				if(syntax.isOperator(str.charAt(k)))
    					break;
    			}
    			j++;
    			k--;
    			String st=""+Math.pow(Float.parseFloat(str.substring(j,i)),Float.parseFloat(str.substring(i+1,k+1)));
    			return valueOf(str.substring(0,j)+st+str.substring(k+1,str.length()));
    		}
    	}
    	// code to solve /
    	for(i=str.length()-1;i>=0;i--)
    	{
    		if(str.charAt(i)=='/')
    		{
    			for(j=i-1;j>=0;j--)
    			{
    				if(syntax.isOperator(str.charAt(j)))
    				{
    					break;
    				}
    			}
    			for(k=i+1;k<str.length();k++)
    			{
    				if(syntax.isOperator(str.charAt(k)))
    					break;
    			}
    			j++;
    			k--;
    			tempx=Float.parseFloat(str.substring(j,i));
    			tempy=Float.parseFloat(str.substring(i+1,k+1));
    			tempx=tempx/tempy;
    			String st=""+tempx;
    			return valueOf(str.substring(0,j)+st+str.substring(k+1,str.length()));
    		}
    	}
    	// code to solve *
    	for(i=str.length()-1;i>=0;i--)
    	{
    		if(str.charAt(i)=='*')
    		{
    			for(j=i-1;j>=0;j--)
    			{
    				if(syntax.isOperator(str.charAt(j)))
    				{
    					break;
    				}
    			}
    			for(k=i+1;k<str.length();k++)
    			{
    				if(syntax.isOperator(str.charAt(k)))
    					break;
    			}
    			j++;
    			k--;
    			tempx=Float.parseFloat(str.substring(j,i));
    			tempy=Float.parseFloat(str.substring(i+1,k+1));
    			tempx=tempx*tempy;
    			String st=""+tempx;
    			return valueOf(str.substring(0,j)+st+str.substring(k+1,str.length()));
    		}
    	}
    	// code to solve +
    	for(i=str.length()-1;i>=0;i--)
    	{
    		if(str.charAt(i)=='+')
    		{
    			for(j=i-1;j>=0;j--)
    			{
    				if(syntax.isOperator(str.charAt(j)))
    				{
    					break;
    				}
    			}
    			for(k=i+1;k<str.length();k++)
    			{
    				if(syntax.isOperator(str.charAt(k)))
    					break;
    			}
    			j++;
    			k--;
    			tempx=Float.parseFloat(str.substring(j,i));
    			tempy=Float.parseFloat(str.substring(i+1,k+1));
    			tempx=tempx+tempy;
    			String st=""+tempx;
    			return valueOf(str.substring(0,j)+st+str.substring(k+1,str.length()));
    		}
    	}
        // code to solve -
    	for(i=str.length()-1;i>=0;i--)
    	{
    		if(str.charAt(i)=='-')
    		{
    			for(j=i-1;j>=0;j--)
    			{
    				if(syntax.isOperator(str.charAt(j)))
    				{
    					break;
    				}
    			}
    			for(k=i+1;k<str.length();k++)
    			{
    				if(syntax.isOperator(str.charAt(k)))
    					break;
    			}
    			j++;
    			k--;
    			tempx=Float.parseFloat(str.substring(j,i));
    			tempy=Float.parseFloat(str.substring(i+1,k+1));
    			tempx=tempx-tempy;
    			String st=""+tempx;
    			return valueOf(str.substring(0,j)+st+str.substring(k+1,str.length()));
    		}
    	}
    	// System.out.println(str);
    	return str;
    }

	static String cool(String str)
	{
		int i,j=0,stack=0;
		String st1="",st2="";
		if(solve.noOfPara(str)==0)
			return valueOf(str);
		else
		{
		for(i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(')
			{
				stack++;
				for(j=i+1;j<str.length();j++)
				{
					if(str.charAt(j)=='(')
						stack++;
					else if(str.charAt(j)==')')
						stack--;
					if(stack==0)
							{
								break;
							}
				}
				break;
			}
		}
		
		if(j<str.length()-1)
		{
			st2=str.charAt(j+1)+solve.cool(str.substring(j+2,str.length()));
		}
		if(i>0)
		{
			st1=solve.cool(str.substring(0,i-1))+str.charAt(i-1);
		}
	}
	return valueOf(st1+cool(str.substring(i+1,j))+st2);
    }
}
