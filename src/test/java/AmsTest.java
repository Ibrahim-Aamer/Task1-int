import org.junit.*;
import static org.junit.Assert.*;

import java.util.Date;

public class AmsTest
{
    private Account savingAcc;
    private Account checkingAcc;
    private User user;

    public AmsTest()
    {
        user = new User("Ibrahim Aamer","04-03-00","0311-5623283","House 61, Strt 1, Sec B");

        savingAcc = new SavingsAccount(user,1200);

        checkingAcc = new CheckingAccount(user,1200);
    }

    /*
     * Checking check balance of Checking Account
     * */
    @Test
    public void testCheckBalanceCheckingAccount()
    {

        Float expectedResult = (float)1200;

        Float result = checkingAcc.checkBalance();

        Assert.assertEquals(expectedResult,result);

    }

    /*
     * Checking check balance of Savings Account
     * */
    @Test
    public void testCheckBalanceSavingsAccount()
    {

        Float expectedResult = (float)1200;

        Float result = savingAcc.checkBalance();

        Assert.assertEquals(expectedResult,result);

    }

    /*
     * This function tests deposit function of Checking Account
     * This function also checks print Statement function
     */
    @Test
    public void testMakeDepositCheckingAccount()
    {

        Date transactionTime = new Date();

        String expectedResult1 =  "--------------------------------------------------\n"
                + "              TRANSACTION STATEMENT\n"
                + "-------------------------------------------------\n"
                + "Account Number     : " + checkingAcc.getAccountNum() + "\n"
                + "Transaction Amount : 4500.0\n"
                + "Remaining Balance  : 5690.0\n"
                + "Transaction Time   : " + transactionTime + "\n"
                + "--------------------------------------------------\n";

        //POSITIVE TEST CASE
        String result1 = checkingAcc.makeDeposit(4500);

        Assert.assertEquals(expectedResult1,result1);


        //------------------------------------------------------------------------------


        //NEGATIVE TEST CASE
        String expectedResult2 =  "INVALID DEPOSIT AMOUNT !";

        String result2 = checkingAcc.makeDeposit(-4500);//invalid amount

        Assert.assertEquals(expectedResult2,result2);


    }

    /*
     * This function tests deposit function of Savings Account
     * This function also checks print Statement function
     */
    @Test
    public void testMakeDepositSavingsAccount()
    {
        Date transactionTime = new Date();

        String expectedResult1 =  "--------------------------------------------------\n"
                + "              TRANSACTION STATEMENT\n"
                + "-------------------------------------------------\n"
                + "Account Number     : " + savingAcc.getAccountNum() + "\n"
                + "Transaction Amount : 4500.0\n"
                + "Remaining Balance  : 5700.0\n"
                + "Transaction Time   : " + transactionTime + "\n"
                + "--------------------------------------------------\n";

        //POSITIVE TEST CASE
        String result1 = savingAcc.makeDeposit(4500);

        Assert.assertEquals(expectedResult1,result1);

        //------------------------------------------------------------------------------

        //NEGATIVE TEST CASE
        String expectedResult2 =  "INVALID DEPOSIT AMOUNT !";

        String result2 = savingAcc.makeDeposit(-4500);//invalid amount

        Assert.assertEquals(expectedResult2,result2);


    }

    /*
     * This function tests withdrawal function of Checkings Account
     * This function also checks print Statement function
     */
    @Test
    public void testMakeWithdrawalCheckingsAccount()
    {
        Date transactionTime = new Date();

        String expectedResult1 =  "--------------------------------------------------\n"
                + "              TRANSACTION STATEMENT\n"
                + "-------------------------------------------------\n"
                + "Account Number     : " + checkingAcc.getAccountNum() + "\n"
                + "Transaction Amount : 500.0\n"
                + "Remaining Balance  : 690.0\n"
                + "Transaction Time   : " + transactionTime + "\n"
                + "--------------------------------------------------\n";

        //POSITIVE TEST CASE
        String result1 = checkingAcc.makeWithdrawal(500);

        Assert.assertEquals(expectedResult1,result1);

        //------------------------------------------------------------------------------

        //NEGATIVE TEST CASE
        String expectedResult2 =  "TRANSACTION FAILED ! \n (Max debt reached)\n";

        String result2 = checkingAcc.makeWithdrawal(8000);//invalid amount as amount exceed max valid amount

        Assert.assertEquals(expectedResult2,result2);


    }



    /*
     * This function tests withdrawal function of Savings Account
     * This function also checks print Statement function
     */
    @Test
    public void testMakeWithdrawalSavingsAccount()
    {
        Date transactionTime = new Date();

        String expectedResult1 =  "--------------------------------------------------\n"
                + "              TRANSACTION STATEMENT\n"
                + "-------------------------------------------------\n"
                + "Account Number     : " + savingAcc.getAccountNum() + "\n"
                + "Transaction Amount : 500.0\n"
                + "Remaining Balance  : 700.0\n"
                + "Transaction Time   : " + transactionTime + "\n"
                + "--------------------------------------------------\n";

        //POSITIVE TEST CASE
        String result1 = savingAcc.makeWithdrawal(500);

        Assert.assertEquals(expectedResult1,result1);

        //------------------------------------------------------------------------------

        //NEGATIVE TEST CASE
        String expectedResult2 =  "TRANSACTION FAILED ! \n (Amount exceeds current Balance)\n";

        String result2 = savingAcc.makeWithdrawal(5000);//invalid amount as amount exceed balance

        Assert.assertEquals(expectedResult2,result2);


    }

    /*
     * This function checks all deduction of both accounts
     */
    @Test
    public void testDisplayAllDeductions()
    {


        //CHECKING DEDUCTIONS OF CHECKING ACCOUNT
        Float expectedResult1 = (float)48.0;

        //POSITIVE TEST CASE
        Float result1 = checkingAcc.displayAllDeductions();

        Assert.assertEquals(expectedResult1,result1);


        //---------------------------------------------------------

        //CHECKING DEDUCTIONS OF CHECKING ACCOUNT
        Float expectedResult2 = (float)0;


        //NEGATIVE TEST CASE
        Float result2 = savingAcc.displayAllDeductions();

        Assert.assertEquals(expectedResult2,result2);  //No zakat deducted

        //NEGATIVE TEST CASE
        savingAcc.makeDeposit(30000);//depositing amount to make sure zakat is deducted

        Float expectedResult3 = (float)780;


        //POSITIVE TEST CASE
        Float result3 = savingAcc.displayAllDeductions();

        Assert.assertEquals(expectedResult3,result3);  //Zakat will now get deducted

    }





}