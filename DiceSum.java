import java.util.*;
public class DiceSum
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int sum=sc.nextInt();
		int count=0;
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=6;j++)
			{
				if((i+j)==sum)
			    {
					count++;
				}
				System.out.println(count);
			}
		}
	}
}
/*public class DiceSum
{
	public static void main(String[] args) {
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
	}
}*/