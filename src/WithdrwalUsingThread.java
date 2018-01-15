
public class WithdrwalUsingThread 
{
	public static void main(String args[])
	{
		Bank obj=new Bank();
		Thread credit=new Thread(obj,"credit");
		Thread debit=new Thread(obj,"debit");
		credit.start();
		debit.start();
		
	}
}
class Bank implements Runnable
{
	int amt=500;
	public void deposit(int addAmt)
	{
		amt+=addAmt;
		System.out.println("Crediting current amount:"+amt+" Added "+addAmt);
	}
	public void withDraw(int debitAmt)
	{
		amt-=debitAmt;
		System.out.println("Debit current amount:"+amt+" debited Amt "+debitAmt);

	}
	public void run()
	{
		if(Thread.currentThread().getName().equals("credit"))
		{
			for(int i=1;i<10;i++)
			{
				deposit(i);

			}
		}
		if(Thread.currentThread().getName().equals("debit"))
		{
			for(int i=1;i<10;i++)
			{
				withDraw(i);
			}
		}
	}
	
	
}