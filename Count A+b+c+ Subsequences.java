import java.io.*;
import java.util.*;
import java.util.*;

public class Main {
    public static int countSequence(String str)
    {
        int a=0;
        int ab=0;
        int abc=0;

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == 'a')
               {
                 a= 2*a + 1;
               }

            else if(str.charAt(i) =='b')
              {
                ab = 2*ab + a;
              }
            else if(str.charAt(i) =='c')
              {
                abc= 2*abc +ab; 
              }
        }
        return abc;
    }
    public static void main(String[] args) throws Exception {
            Scanner sc= new Scanner(System.in);
            String s = sc.nextLine();

            int ans= countSequence(s);
            System.out.println(ans);
    }
}
