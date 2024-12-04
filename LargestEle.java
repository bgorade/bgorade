
/*public class LargestEle  {  
    public static void main(String[] args) {  
  
        //Initialise array  
        int [] arr = new int [] {32, 57, 63, 55, 48};  
        //Initialise large with first element of array.  
        int large = arr[0];  
        //Loop through the arr
           for (int i = 0; i < arr.length; i++) {  
            //Compare elements of array with large
          if(arr[i] >large)  
              large = arr[i];  
        }  
        System.out.println("The largest element in the given array: " + large);  
    }  
}*/
/*Java Program to find the largest element in an array using Sorting of elements*/
import java.util.Scanner;
public class LargestEle
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int r;     //Declaring the size of the array
        System.out.println("Enter the size of your array");
        r=sc.nextInt();   //Initialise array size

        int arr[]=new int[r];   //Declaring the array 
        System.out.println("Enter your array");  
        for(int i=0;i<r;i++)     //Initialising the array
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<r;i++)   //Use to hold an element of the given array.
        {
            for(int j=i+1;j<r;j++)   //Use to check for rest of the elements of the array
            {
                if(arr[i]<arr[j])    //Comparing and swapping
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        
        System.out.println("The Largest element of the given array is "+arr[0]);  //Display the Largest after sorting
        
    }
}