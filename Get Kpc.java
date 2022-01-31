Sample Input
78
Sample Output
[tv, tw, tx, uv, uw, ux]

import java.io.*;
import java.util.*;

public class Main {
    static String[] codes= {".;" ,"abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz" };
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        String s =sc.next();
        ArrayList<String> ans= getKPC(s);
        System.out.println(ans);
        
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        
        char ch=str.charAt(0);
        String ros=str.substring(1);
        
        ArrayList<String> recAns=getKPC(ros);
        ArrayList<String> myAns=new ArrayList<>();
        
        int idx=ch-'0';
        
        String code=codes[idx];
        for(int i=0;i<code.length();i++)
        {
            char newChar=code.charAt(i);
            for(String ele:recAns)
            {
                myAns.add(newChar+ele);
            }
        }
        
       return myAns; 
    }

}
