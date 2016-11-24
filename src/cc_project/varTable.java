/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc_project;

/* @author SIDHARTHA */

import cc_project.variable;

class varTable{
	variable vars[]=new variable[200];
	int index=0;
	void insertVar(String name,String value,String type)
	{
		if(isPresent(name)==false)
		{
                    vars[index]=new variable();
                    vars[index].name=name;
                    vars[index].value=value;
                    vars[index].type=type;
                    index++;
                }
                else
                {
                        int temp=indexOf(name);
                        vars[temp].name=name;
                        vars[temp].value=value;
                        vars[temp].type=type;
                }
	}
	boolean isPresent(String name)
	{
		int x=indexOf(name);
                if(x!=index)
                    return true;
                return false;
	}
	int indexOf(String name)
	{
            int i=0;
		for(;i<index;i++)
			if(vars[i].name.equals(name))
				return i;
		return i;
	}
        
        String reduce(String str)
        {
            int temp=0;
            for(int i=0;i<index;i++)
            {
                temp=str.indexOf(vars[i].name);
                if(temp==-1)
                    continue;
                else
                {
                    str=str.substring(0,temp)+vars[i].value+str.substring(temp+vars[i].name.length(),str.length());
                    i--;
                }
            }
            return str;
        }
        
        String valueOf(String str)
        {
            int x=indexOf(str);
            if(x!=index)
                return vars[x].value;
            else 
                return "";
        }
}