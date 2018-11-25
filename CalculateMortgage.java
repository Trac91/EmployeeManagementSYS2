import javax.swing.*;

public class CalculateMortgage {
    static void calculateMonthlyPayment(int loanAmount, int years, double annualInterestRate) {

        double monthlyInterestRate = annualInterestRate / 12.0;

        int months = years * 12;

        double monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -months));

        JOptionPane.showMessageDialog(null, monthlyPayment);
    }



    public void isValidApplication(int income, int deposit) {
        boolean valid = false;

        if (income < 30000 || deposit < 12000)

        {
            return;
        }


    }

}







// Take in financial details from the user and plug them into formula
        /* -- Get Interest Rate per year
           -- Calculate the monthly interest rate
                    monthlyInterest = annualinterest/12
           -- Get amount of years
           -- calculate monthly repayment
                   monthlypayment = loanamount * monthly interestrate(1-1/math.pow(1 + monthlyInterestRate,
                   numberOf years * 12);
           -- Total Payment = MonthlyPayment * numberOfyears * 12

        */
