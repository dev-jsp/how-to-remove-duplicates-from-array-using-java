# how-to-remove-duplicates-from-array-using-java

**Contents:**
1: Create a file & Declare a Class 
2: Declare the main method
3: Declare Variables 
4: Taking inputs
5: Passing input to the second method
6: Declare the second method which contains our logic
7: actual logic for removing duplicates from an array
8: Returning a pure array
9: Display the Output

>**Note**: I am following the java naming conventions in this solution.
>It is not forced to follow, but it is a good habit as a programmer.
>And it will make your program easy readable for other programmers.


#1. Create a file & Declare a Class 

Create a file `EliminateDuplicatesFromArray.java`
Open a file and declare class 

```java
import java.util.Scanner;

class EliminateDuplicatesFromArray{

}
```


>According to java conventions, Filename and class name must be the same which makes it easier to maintain and organize your programs.
We are importing the Scanner class to take inputs

#2 : Declare the main method
 
```java
public static void main(String as[]){

}
```

This is the starter method of any java program

#3 : Declare Variables in main method

Now declare necessary variables that will require in the program.
* Two Arrays one for input and another for output
```java
int[] list,pureList;
```

* Size of Array
```java
int len;
```
* object of Scanner class
```java
Scanner s=new Scanner(System.in);
```

It will require if we use Dynamic Initialization

#4 : Taking inputs

Two ways to take input/initializing array
* Static Initialization
```java
list={10,20,30,30,30,30,40,50,10,40,10,50,10,0,0,0,10,70,80,10,90,10,90,90,90};
```

* Dynamic Initialization 
For this, we need to take input from the user.
So we need an Object of Scanner class to get input as declared in step 3.

```java
System.out.println("Enter Size of array");
int len=s.nextInt();

list=new int[len]; // instantiation  		
for(int i=0;i<list.length;i++)
{
	System.out.print("Enter "+i+" element :=> ");
	list[i]=s.nextInt();  // initialization
	
}
```

#5 : Passing input to the second method

```java
pureList=removeDuplicates(list);
```

passing `list` as input to the method `removeDuplicates` and it will return to `pureList`.

#6 : Declare the second method

Creating the second method
```java
public static int[] eliminateDuplicates(int[] list){


}
```

why `static` ? because we're calling it from the main method.

#7 : Actual logic for removing duplicates from an array

* Declare Variables in `eliminateDuplicates` method
```java
int key,newSize;
int[] pureList;
```
the `key` variable is for selecting each element of the `list` as `key` and comparing `key` 
with each element of the `list`
`pureList` is for storing pure Array
`newSize` is the length of `pureList` Array

###7.1 : Initialize inputs

```java
newSize=list.length;
```

the list variable will contain passed impure array
Currently, `newSize` will contain length of input array(impure Array)
`newSize` will be decreased as the element is removed.


###7.2 : Process the Array [Actual Logic]

```java
for(int i=0;i<newSize-1;i++)//for select each element as key
{	
	key=list[i];//store first element as Key
	for(int j=i+1;j<newSize;j++){/* Start Comparing with Next Element 
                                      otherwise key element will be removed */
		if(key==list[j])
		{	
	        	newSize=newSize-1; /* Decreasing Length to Skip the Last 
                                              element which already shifted up 
                                             after below loop */
			for(int k=j;k<newSize;k++)//Shift Up Array to remove Duplicate 		{
				list[k]=list[k+1];  //remove duplicate 
			}
			j--; //for skipped element after deletion			
		}
	}
}
```

* 1st For loop
      Selecting Each element of the array
      Assigning to `Key` variable
* 2nd For loop
      Selecting Each element of the array after the `key` element   
* If Statement
           Comparing key with each element of array excluding `key`
           If match found
                then decrement `newSize` variable
                because in 3rd loop we are deleting one element from the array
* 3rd For loop
        removing an element from the array by shifting up the next element
 
Now decrement 2nd loop counter `j` by one because after deletion of element next element's index will become deleted element's index.
So the next element will not be skipped for comparison.

#8 : Returning a pure array

After this `list` has no duplicates values but it contains dummy values 
So Copy list with `newSize` length to `pureList` array.

```java
pureList=new int[newSize]; //Instantiate pureList Array with newSize

for(int p=0;p<newSize;p++)
{
	pureList[p]=list[p];
}
return pureList;
```

#9 : Display the Output


```java
for(int x: pureList)//for each loop for display output
{
	System.out.println(x);
}
```

