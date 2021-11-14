import java.util.Date;

public class Account
{
	public Account()
	{

	}

	/**
	 * Constructs a new account object (Parameterized constructor)
	 * @param username,
	 */
	public Account(User user, int initDeposit)
	{

	}

	/**
	 *
	 * @return String Name & balance
	 */
	public float checkBalance()
	{

		return this.balance;
	}




	public void transferAmount(float amount, int accountNum)
	{

	}

	/**
	 *
	 * @param transactionAmount
	 * @return returns string which holds transaction details
	 */
	public String printStatement(float transactionAmount)
	{
		Date transactionTime = new Date();

		String ret = "--------------------------------------------------\n"
				+ "              TRANSACTION STATEMENT\n"
				+"-------------------------------------------------\n"
				+ "Account Number     : " + Integer.toString(accountNum) + '\n'
				+  "Transaction Amount : " + Float.toString(transactionAmount) + '\n'
				+  "Remaining Balance  : " + Float.toString(balance) + '\n'
				+  "Transaction Time   : " + transactionTime + '\n'
				+  "--------------------------------------------------\n"	;

		return ret;

	}

	public String makeDeposit(float deposit)
	{
		return null;
	}

	public String makeWithdrawal(float amount)
	{
		return null;
	}

	/**
	 * Function to be overridden
	 */
	public float displayAllDeductions()
	{
		return 0;
	}


	/**
	 * Returns account number
	 * @return Account number
	 */
	public int getAccountNum()
	{
		return accountNum;
	}

	static protected int NumCnt = 0;
	protected int accountNum;
	protected String Name;
	protected float balance;
	protected Date dateCreated;
	protected User user; //user object to hold user details
	protected float totalDeductions = 0;

}




