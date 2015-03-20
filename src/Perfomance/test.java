package Perfomance;

/**
 *
 * @author Proprio
 */
public class test 
{
    
    public static int algo(int n, int m)
    {        
        int s=1;
        for (int i=n; i<m; ++i)
        {
            s = s*i;
        }
        return s;
    }
    
    public static int algo1(int n, int m)
    {       
        if ( n >= m )
        {            
            return 1;
        }else
        {
            return n * algo1( n+1,m );
        }        
    }
    
    public static int C(int n)
    {
        int s=0;
        if ( n == 0 )
        {
            s=1;
        }else
        {
            for (int i=0; i <= (n-1); i++)
            {
                s = s + (C(i) * C(n-1-i));
            }
        }
        return s;
    }

    public static void main(String[] args) 
    {
        System.out.println("s= "+algo(2,10));
        System.out.println("s1= "+algo1(2,10));
        System.out.println("C=" + C(4));
    }
}
