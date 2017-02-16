package cs3112Labs;



public class Lab03 {
	
		public static  void main (String args[])
		{
			int[] testlist ={7,-5,-1,4,5,-6,9,-2};
			//23,11,18,20,45,12
//			7,-5,-1,4,5,-6,9,-2
			// used to test methods
			int [] basecase ={21};
			int leng = testlist.length;
			System.out.print(" My List of Numbers :  ");
			for(int  x: testlist)
			{
				System.out.print(x+" \t ");
			}
			System.out.println("");
			System.out.println("Divide and Conquer Using nLogn");

		
		System.out.println	(findMaximumSubarray(testlist,0,leng-1));
		System.out.println("Brute Force Using n^2");

		
		System.out.println(brute(testlist));
	}
		 
		
		public static  int findMaximumSubarray(int[] A,int low,int high)
		{		

				if (high == low)
				{	//base case because there is only one element is the array
					return A[low];
				}
				else
				{
					int mid = (int) Math.floor((low+high)/2);
					int leftSum = findMaximumSubarray(A,low,mid);
	
					int rightSum = findMaximumSubarray(A,mid+1,high);
					int crossSum = findMaxCrossingSubarray(A,low,mid,high);
							if((leftSum >= rightSum) && (leftSum >= crossSum))
								{
								return leftSum;
								}
						else if ((rightSum>=leftSum)&&(rightSum>=crossSum))
							{
							return rightSum;
							}
					
						else
							{
							return crossSum;
							}
				}
				
		}
		
	
			public static int  findMaxCrossingSubarray(int[] A,int low,int mid,int high)
				{
					int leftSum=-1000;
					int sum = 0;

						for(int i=mid;i>=low;i--)
							{
								sum = sum + A[i];
									if (sum > leftSum)
										{
											leftSum = sum;
											 leftSum = i;
										}
							}
							int rightSum = -1000;
							sum =0;
							// check the mid + 1 
								for(int j = mid +1;j<=high;j++)
									{
										sum = sum +A[j];
											if (sum>rightSum)
												{
													rightSum = sum;
													rightSum = j;
												}
									}

							    return leftSum + rightSum;		
				}
			
					public static int insertionSort(int [] A)
					{
							for (int j=0; j<A.length;j++)
							{
								int key = A[j];
								//InsertA[j] into the sorted sequence A[1..j..-1]
							  int i =j-1;
							  	while (i>=0 && A[i]>key)
							  		{
								  A[i+1] = A[i];
								  i = i-1;
								  A[i+1]=key;
							  		}
							}
							return A[A.length-1];
							
						
						
					}
					
					
					public static int brute( int[] A ) {

					    int max =0;
					    int start;
					    int end;
					    for ( int i = 0; i < A.length-1; i++ ) {
					            
					        int sum = 0;
					        for ( int j = i; j < A.length-1; j++ ) {
					        
					            sum += A[j];           
					            
					            // Is this the new max?
					            if ( sum > max ) {
					                max = sum;
					                start = i;
					                end = j;
					            }                
					        }
					    }

					    return max;
					}
					
					

}