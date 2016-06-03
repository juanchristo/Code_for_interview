package quicksort;
import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;

public class QuickSort {
	  int[] id;
	  int pivot;
	  int count=0;
	  public QuickSort() throws FileNotFoundException {
		File f = new File("QuickSort.txt");
		Scanner in = new Scanner(f);
		id = new int[10000];
        for(int i = 0; i < id.length; i++)
            id[i] = in.nextInt();
        in.close();
	  }
	  public void startSort()
	  { 
		pivot= findMedian(0,findMidArray(0,id.length-1),id.length-1);
		partition(pivot, 0, id.length-1);
	  }

	  public boolean partition(int subpivot, int start, int end){
		  count=count+(end-start);
		  if (start==end)
			  return true;
		  if (subpivot!=start)
		  {
			  swap(subpivot, start);
			  subpivot=start;
		  }
		  int j=start;
		  for(int i=start+1;i<=end;i++)
		  {
			if(id[i]<id[subpivot])
			{
				if (i!=(j+1))
					swap(i,j+1);
				j++;
		    }
		  }
		  swap(subpivot,j);
		  if (j==end)
		  {
			  pivot= findMedian(start,findMidArray(start,j-1),j-1);
			  partition(pivot, start, j-1);
			  pivot= findMedian(j,findMidArray(j,end),end);
			  partition(pivot,j,end);
		  }
		  else
		  {
			  pivot= findMedian(start,findMidArray(start,j),j);
			  partition(pivot, start, j);
			  pivot= findMedian(j+1,findMidArray(j+1,end),end);
			  partition(pivot,j+1,end);
		  }
		  return true;
	  	}
	    public void swap(int a, int b)
	    {
	    	int c;
	    	c=id[a];
	    	id[a]=id[b];
	    	id[b]=c;
	    }
	    public int findMidArray(int a, int b)
	    {	
	    	double middle;
	    	middle = Math.floor((a+b)/2);
	    	return (int)middle;
	    }
	    public int findMedian(int a, int b, int c)
	    {
	    	int median;
	    	if (id[a]>id[b])
	    	{
	    			median=a;
	    			if ((id[c]<id[a]) && (id[c]>id[b]))
	    				median=c;
	    			if ((id[c]<id[a]) && (id[c]<id[b]))
	    				median=b;
	    	}
	    	else
	    	{
	    	 		median=b;
	    	    	if ((id[c]<id[b]) && (id[c]>id[a]))
	    				median=c;
	    	    	if ((id[c]<id[b]) && (id[c]<id[a]))
	    				median=a;
	    	}
	    	return median;
	    }
	    public void printID(){
	  		System.out.println("\nThe input array content is: \n");
			for(int i=0;i<id.length;i++)
				System.out.print(id[i]+" ");
		}
	   public void printSortedID(){
	  		System.out.println("\nThe sorted array content is: \n");
			for(int i=0;i<id.length;i++)
				System.out.print(id[i]+" ");
		}
	   public void printCount(){
	  		System.out.println("\nThe count is: \n");
			System.out.print(count);
		}
	  public static void main(String[] args) throws FileNotFoundException{
            QuickSort qs= new QuickSort();
			qs.startSort();
			qs.printSortedID();
			qs.printCount();
	 }
}