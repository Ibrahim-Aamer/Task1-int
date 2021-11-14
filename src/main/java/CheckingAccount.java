import java.util.Date;


public class CheckingAccount extends Account
{
	public CheckingAccount(User user, float initDeposit)
	{
		NumCnt = NumCnt + 1; //incrementing account no# at each new creation

		accountNum = NumCnt; //Assigning NumCnt to accountNum

		dateCreated = new Date();//Getting system date and time

		Name = user.getName();  //Getting user name from user object

		this.user = user;

		this.user.setCheckAcc(this);

		balance = initDeposit;//setting initial deposit

	}

	/**
	 *
	 * @param float deposit amount
	 */
	public String makeDeposit(float deposit)
	{
		if( deposit > 0 )
		{
			balance += deposit;
			balance -= transactionFees; //deducting transaction fees
			totalDeductions += transactionFees;//adding in total transaction fees taken

			return this.printStatement(deposit);
		}
		else
		{
			return "INVALID DEPOSIT AMOUNT !";
		}

	}

	/**
	 *
	 * @param float withdrawing amount
	 */
	public String makeWithdrawal(float amount)
	{
		//Withdrawal can proceed uptil account is -5000 in debt
		if( this.balance-amount >= -5000)
		{
			balance -= amount;
			balance -= transactionFees; //deducting transaction fees
			totalDeductions += transactionFees;//adding in total transaction fees taken


			return this.printStatement(amount);
		}
		else
		{
			return "TRANSACTION FAILED ! \n (Max debt reached)\n";
		}

	}




	public float displayAllDeductions()
	{

		float tax = ( (balance*(float)4) / 100 );


		return tax;
	}


	protected float transactionFees = 10;


}