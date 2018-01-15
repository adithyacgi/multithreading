
class ClassWithResource implements Runnable {
	int arr[]=new int[10];
	int index=0;
	
	public synchronized  void inserIntoArray()
	{	
		System.out.println("added to test remove this");
			if(index<arr.length-1)
			for(int i=0;i<arr.length-1;i++)
			{
				System.out.println("Inserting value by "+Thread.currentThread()+ " value "+i+" at index "+i);
				arr[index++]=i;
			}
	}
	public synchronized void removeFromArray()
	{
		if(index>0)
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("Removing value by "+Thread.currentThread()+" index "+index);
			arr[index--]=0;
		}
		index=0;
		System.out.println("Thread Exiting "+Thread.currentThread());
	}
	public void run()
	{
		System.out.println("Thread entered "+Thread.currentThread());
		inserIntoArray();
		System.out.println("Removing ");
		removeFromArray();
		
	}
}

public class ThreadsWithArrayFillAndDelete 
{
	public static void main(String args[])
	{
		ClassWithResource obj=new ClassWithResource();
		Thread t1=new Thread(obj);
		Thread t2=new Thread(obj);
		t2.setPriority(7);
		t1.start();
		t2.start();

	}
}
