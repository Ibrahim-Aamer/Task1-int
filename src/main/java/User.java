import java.util.Date;

/**
 A class for Users
 */
public class User
{
	/**
	 * Construct a user object
	 * @param uName
	 * @param date of birth
	 * @param phNum
	 * @param Addr
	 */
	public User(String uName, String dob, String phNum, String addr )
	{
		userCnt ++;//incrementing user count in each constructor call

		Name = uName;
		address = addr;
		phoneNum = phNum;
		dateCreated = new Date();
		this.dob = dob;

		//Creating a unique username (with no spaces) for each user based on user count
		userName = Name.replaceAll("\\s", "") + Integer.toString(userCnt);	}

	/**
	 * Display details User
	 * @return Details of User in a string
	 */
	public String displayDetails()
	{
		String ret =  "Username           : " + getUserName() + '\n'
				+  "Full Name          : " + getName() + '\n'
				+  "Joining Date       : " + dateCreated + '\n'
				+  "Date of Birth      : " + dob + '\n'
				+  "Address            : " + address + '\n'
				+  "Phone Number       : " + phoneNum + '\n'
				+ this.checkAccountsStatus();

		return ret;

	}

	/**
	 * Displaying Accounts status of user
	 */
	public String checkAccountsStatus()
	{
		String ret;

		if( checkAcc == null )
		{
			ret = "Checking Account   : INACTIVE ";
		}
		else
		{
			ret = "Checking Account   : ACTIVE ";
		}

		if( savAcc == null )
		{
			ret ="Savings Account    : INACTIVE ";
		}
		else
		{
			ret ="Savings Account    : ACTIVE ";
		}

		return ret;
	}

	/**
	 *
	 * @return Name of the user
	 */
	public String getName() {
		return Name;
	}

	public String getUserName() {
		return userName;
	}



	public SavingsAccount getSavAcc() {
		return savAcc;
	}

	public void setSavAcc(SavingsAccount savAcc) {
		this.savAcc = savAcc;
	}

	public CheckingAccount getCheckAcc() {
		return checkAcc;
	}

	public void setCheckAcc(CheckingAccount checkAcc) {
		this.checkAcc = checkAcc;
	}



	static private int userCnt = 0;
	private String userName;
	private String Name;
	private String address;
	private String phoneNum;
	private Date dateCreated;
	private String dob;
	private CheckingAccount checkAcc;
	private SavingsAccount savAcc;
}