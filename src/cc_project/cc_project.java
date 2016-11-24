/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc_project;

/* @author SIDHARTHA */

import java.util.Scanner;
import cc_project.variable;
import cc_project.syntax;
import cc_project.varTable;

class cc_project{

	varTable table=new varTable();

        String valueOf(String str)
        {
            int opCount=0;
            for(int i=0;i<str.length();i++)
                if(syntax.isOperator(str.charAt(i)))
                    opCount++;
            if(opCount==0)
            {
                str=variable.removePara(str);
                String type=variable.type(str);
                if(type.equals("String") || type.equals("char"))
                {
                    String st=table.valueOf(str);
                    if(st.equals("")==false)
                        str=""+st;
                }
                else
                {
                    if(type.equals("int"))
                    {
                        str=""+Integer.parseInt(str);
                    }
                    else if(type.equals("float"))
                    {
                        str=""+Float.parseFloat(str);
                    }
                }
            }
            else if(syntax.isExpression(str)==1)
            {
                return solve.cool(str);
            }
            else if(syntax.isExpression(str)==2)
            {
                str=table.reduce(str);
                if(syntax.isExpression(str)==1)
                    return solve.cool(str);
            }
            return str;
        }
        
	String allocate(String name,String value)
	{
            if(variable.isVariable(name))
            {
		table.insertVar(name,value,variable.type(value));
                return name+" "+value+" "+variable.type(value);
            }
            else
            {
                return "Illegal variable declaration !";
            }
	}

	String solve(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='=')
				return allocate(str.substring(0,i),valueOf(str.substring(i+1,str.length())));
		}
                return valueOf(str);
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str="";
                cc_project cc=new cc_project();
                int check;
                System.out.println("\n CC_PROJECT \n v1.0.0 \n Last build : 25-OCT-2016 \n  Project Author 1 : Sidhartha Singh \n  Project Author 2 : Kartikeya Jain\n  ");
		while(true)
		{
                    try{
                        System.out.print(">>> ");
			str=sc.nextLine();
                        check=syntax.good(str);
			if(check==2){
				System.out.println(cc.solve(variable.removespace(str)));
			}
                        else if(check==1){
				continue;
			}
                        else if(check==0)
                        {
                            break;
                        }
                    }
                    catch(Exception e)
                    {
                        if(str.equals(""))
                        {
                            
                        }
                        else
                        {
                            e.printStackTrace();
                        }
                    }
		}
	}
}