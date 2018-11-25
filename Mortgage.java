import javax.swing.*;
import java.util.Date;

public class Mortgage extends Person{

    private int numApp;
    private String forename;
    private String surname;
    private String status;
    private Date dob;
    private int numChildren;
    private boolean firstTimeBuyer;
    private int income;
    private int  additionalIncome;
    private int price;
    private int loanRequired;


    int annualInterestRate, amount, numYears;

    public Mortgage(String forename, String surname, String status, String dob, String numChildren, String firstTimeBuyer, String income, String additionalIncome, String price, String loanRequired){

this(0,
        "Unknown",
        "Unknown",
        "Unknown",
        null,
        0,
        false,
        0,
        0,
        0,
        0);    }

public Mortgage(int numApp,String forename, String surname, String status,Date dob, int numChildren, boolean firstTimeBuyer, int income, int additionalIncome, int price, int loanRequired){
        this.numApp = numApp;
        this.forename = forename;
        this.surname = surname;
        this.status = status;
        this.dob=dob;
        this.numChildren=numChildren;
        this.firstTimeBuyer = firstTimeBuyer;
        this.income = income;
        this.additionalIncome =additionalIncome;
        this.price = price;
        this.loanRequired=loanRequired;
}

    public static void add(Mortgage m) {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getForename() {
        return forename;
    }

    @Override
    public void setForename(String forename) {
        this.forename = forename;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getNumApp() {
        return numApp;
    }

    public void setNumApp(int numApp) {
        this.numApp = numApp;
    }

    public boolean isFirstTimeBuyer() {
        return firstTimeBuyer;
    }

    public void setFirstTimeBuyer(boolean firstTimeBuyer) {
        this.firstTimeBuyer = firstTimeBuyer;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(int additionalIncome) {
        this.additionalIncome = additionalIncome;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(int annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }


    public int getLoanRequired() {
        return loanRequired;
    }

    public void setLoanRequired(int loanRequired) {
        this.loanRequired = loanRequired;
    }


    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public int getNumYears() {
        return numYears;
    }

    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return super.toString() + getNumApp() + getForename() + getSurname() + getAdditionalIncome() + getAmount() + getAnnualInterestRate() + getDob() + getIncome() + getNumChildren() + getNumYears() + getPrice() + getStatus();
    }
}
