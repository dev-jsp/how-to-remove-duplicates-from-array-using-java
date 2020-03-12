import java.util.Scanner;

class EliminateDuplicatesFromArray
{

	public static int[] eliminateDuplicates(int[] list)
	{
		int key;
		int newSize=list.length;//total length Of array
		for(int i=0;i<newSize-1;i++)//for select each element as key
		{	
			key=list[i];//store first element as Key

			for(int j=i+1;j<newSize;j++)//Start Comparing with Next Element otherwise key element will be removed
			{				
					if(key==list[j])
					{	
						newSize=newSize-1;//Decreasing Length to Skip Last Element which already shifted up after below loop
						for(int k=j;k<newSize;k++)//Shift Up Array to remove Duplicate 
						{
							
							list[k]=list[k+1];// remove duplicate 
							
						}
						j--;//for skipped element after delete			
					}
					

			}
		
		}
		int[] pureList=new int[newSize]; //Declare Resulting Array with newSize
			System.out.println(" After Removing Elements Array=> ");

		for(int p=0;p<newSize;p++)
		{
			pureList[p]=list[p];
		}
		return pureList;
	}
	public static void main(String as[])
	{
		Scanner s=new Scanner(System.in);
		int[] pureList,list;


		System.out.println("Enter Size of array");
		int len=s.nextInt();
		list=new int[len];		
		for(int i=0;i<list.length;i++)
		{
			System.out.print("Enter "+i+" element :=> ");
			list[i]=s.nextInt();
	
		}
		
		pureList=eliminateDuplicates(list);//returns pure Array

		for(int x: pureList)//for each loop for display output
		{
			System.out.println(x);
		}
			

	}
}