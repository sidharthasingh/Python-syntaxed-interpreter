/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc_project;

/* @author SIDHARTHA */

class variable{
	String name;
	String type;
	String value;
        
        static String removespace(String str)
	{
		String st="";
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)!=' ')
				st+=str.charAt(i);
		return st;
	}

	static boolean isVarBeginning(char a)
	{
		if((a>=65 && a<=90) || (a>=97 && a<='z') || a=='_')
			return true;
		return false;
	}

	static boolean isPartOfVar(char a)
	{
		if(isVarBeginning(a) || (a>='0' && a<='9'))
			return true;
		return false;
	}
        
        static boolean isVariable(String a)
        {
            int i=0;
            if(variable.isVarBeginning(a.charAt(0))==false)
                return false;
            for(;i<a.length();i++)
            {
                if(variable.isPartOfVar(a.charAt(i))==false)
                    return false;
            }
            return true;
        }

	static String toIdentifier(String str)
	{
		String arr="";
		for(int i=0;i<str.length();i++)
		{
			if(isVarBeginning(str.charAt(i)))
			{
				int j=i;
				while(isPartOfVar(str.charAt(i)) && i<str.length()){
					i++;
					if(i==str.length())
						break;
				}
				i--;
				// code for variable table;
				System.out.println(str.substring(j,i+1));
				arr+='&';
			}
			else if(str.charAt(i)==' '){

			}
			else
			{
				arr+=str.charAt(i);
			}
		}
		return arr;
	}

	static String type(String value)
	{
		int noofdec=0,i;
		for(i=0;i<value.length();i++)
		{
			if(value.charAt(i)=='.')
			{
				noofdec+=1;
			}
			else if(value.charAt(i)>='0' && value.charAt(i)<='9')
			{

			}
			else
			{
				if(value.length()==1)
					return "char";
				else
					return "String";
			}
		}
		if(noofdec==0)
			return "int";
		else
			return "float";
	}
        static String removePara(String str)
        {
            int i;
            String st="";
            for(i=0;i<str.length();i++)
            {
                if(str.charAt(i)!='(' || str.charAt(i)!=')')
                    st+=str.charAt(i);
            }
            return st;
        }
} 