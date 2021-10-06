package com.example.securebydesign.competition1;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;


public class Customer {

    private static final int MIN_LENGTH_ACCOUNT_NUMBER=12;
    private static final int MAX_LENGTH_ACCOUNT_NUMBER=16;
    private final String customerId;
    private final String customerName;
    private final String bankAccountNumber;
    private final Integer accountBalance;
    public Customer (final String customerId,final String customerName,final String bankAccountNumber,final Integer accountBalance){
        this.customerId=Validate.notNull(customerId);
        this.customerName= Validate.notNull(StringEscapeUtils.escapeHtml4(customerName));
        validateBankAccountNumber(bankAccountNumber);
        this.bankAccountNumber=bankAccountNumber;
        validateAccountBalance(accountBalance);
        this.accountBalance= accountBalance;
    }
    private void validateBankAccountNumber(String bankAccountNumber){
        Validate.matchesPattern("[0-9]+",bankAccountNumber);
        Validate.exclusiveBetween(MIN_LENGTH_ACCOUNT_NUMBER,MAX_LENGTH_ACCOUNT_NUMBER,bankAccountNumber.length());
        Validate.notNull(bankAccountNumber);

    }
    private void validateAccountBalance(Integer accountBalance)throws IllegalArgumentException{
        Validate.notNull(accountBalance);
        if(accountBalance.intValue()<0)
            throw new IllegalArgumentException();

    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

}
