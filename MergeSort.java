package mergesort;
import java.util.Scanner;
import java.lang.Math;

public class MergeSort {
	  int[] id;
	  int[] sortedID;
	  public MergeSort(int N) {
		id = new int[N];
	  }
	  public void setID(int i,int a){
			    id[i]=a;
	  }
	  public void startSort()
	  {
		sortedID=recursiveSort(id);
	  }
	  public int[] recursiveSort(int[] a){
			
			if (a.length==1)
				return a;
			float l=a.length;
			int[] first=new int[(int) Math.ceil(l/2)];
			int[] second=new int[(int) Math.floor(l/2)];
			int j=0;
			int i=0;
			while(i<l/2){
				first[i]=a[i];
				i++;
			}
			while(i<l){
				second[j]=a[i];
				i++;
				j++;
			}
			first=recursiveSort(first);
			second=recursiveSort(second);
			return merge(first,second);
		}
	  public int[] merge(int[] a, int[] b){
		int i=0;
		int j=0;
		int k=0;
		int[] m=new int[a.length+b.length];
		while((j<a.length)&&(k<b.length)){
			 if (a[j]<b[k]){
				m[i]=a[j];
				j++;
			 }
			 else
			{
				m[i]=b[k];
				k++;
			}
			i++;
		}
		while(i<(a.length+b.length)){
			if (j<a.length){
				m[i]=a[j];
				j++;
			 }
			 else
			{
				m[i]=b[k];
				k++;
			}
		i++;
		}
		return m;
		}
	    public void printID(){
	  		System.out.println("\nThe input array content is: \n");
			for(int i=0;i<id.length;i++)
			{
				System.out.print(id[i]+" ");
			}
		}
	   public void printSortedID(){
	  		System.out.println("\nThe sorted array content is: \n");
			for(int i=0;i<sortedID.length;i++)
			{
				System.out.print(sortedID[i]+" ");
			}
		}
	  public static void main(String[] args){
			Scanner in = new Scanner(System.in);
			int N = in.nextInt();
			MergeSort ms= new MergeSort(N);
			for(int i=0;i<N;i++)
			{ 
				int p= in.nextInt();
				ms.setID(i,p);
			}
			in.close();
			ms.startSort();
			ms.printID();
			ms.printSortedID();			
	 }
}
