/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc_project;

/* @author SIDHARTHA */

class syntax{
    
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
    
        static int good(String str)
	{
                if(syntax.equal_para(str)==false)
                {
                    System.out.println("\nUnbalanced Paranthesis\n");
                    return 1;
                }
				if(str.equalsIgnoreCase("exit")==true)
                {
                    System.out.println("\nExitting the program\n");
                    return 0;
                }
		return 2;
	}
    
	static boolean equal_para(String s)
	{
		int i=0;
		for(int j=0;j<s.length();j++)
		{
			if(s.charAt(j)=='(')
				i++;
			else if(s.charAt(j)==')')
				i--;
                        if(i<0)
                            i=0;
		}
		if(i==0)
			return true;
		return false;
	}
        
        static boolean isOperator(char a)
        {
            String str="()+-*/^";
            for(int i=0;i<str.length();i++)
                if(a==str.charAt(i))
                    return true;
            return false;
        }
        
        static int isExpression(String s)
        {
            int op=0,ch=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)>='0' && s.charAt(i)<='9')
                    continue;
                else if(s.charAt(i)=='.')
                    continue;
                if(syntax.isOperator(s.charAt(i)))
                {
                    op++;
                }
                if(variable.isVarBeginning(s.charAt(i)))
                {
                    ch++;
                }
            }
            if(ch>0 && op>0)
                return 2;
            else if(ch==0 && op>0)
                return 1;
            return 0;
        }
}