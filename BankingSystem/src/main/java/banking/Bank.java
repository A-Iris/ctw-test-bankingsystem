package banking;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        // TODO: complete the constructor
        accounts=new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // TODO: complete the method
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // TODO: complete the method
        Long accountNumber = (long) (accounts.size()+1); // TODO: replace with unique long id
        Account account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // TODO: complete the method
        Long accountNumber = (long) (accounts.size()+1); // TODO: replace with unique long id
        Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public double getBalance(Long accountNumber) {
        // TODO: complete the method

        Account account = accounts.get(accountNumber);
        return account!=null?account.getBalance(): -1.0;
    }

    public void credit(Long accountNumber, double amount) {
        // TODO: complete the method
        Account account = accounts.get(accountNumber);
        account.creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {
        // TODO: complete the method
        Account account = accounts.get(accountNumber);
        return account.debitAccount(amount);
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // TODO: complete the method
        Account account = accounts.get(accountNumber);
        return account.validatePin(pin);
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        CommercialAccount account = (CommercialAccount) accounts.get(accountNumber);
        account.addAuthorizedUser(authorizedPerson);
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        // TODO: complete the method
        Account account = accounts.get(accountNumber);
        if (authorizedPerson==null){
            return false;
        }

        if(account instanceof CommercialAccount){
            CommercialAccount comAccount = (CommercialAccount) account;
            return comAccount.isAuthorizedUser(authorizedPerson);
        } else {
            /*ConsumerAccount conAccount = (ConsumerAccount)  account;
            Person consumer=(Person) conAccount.getAccountHolder();
            return consumer.getIdNumber()==authorizedPerson.getIdNumber() && consumer.getFirstName().equals(authorizedPerson.getFirstName()) && consumer.getLastName().equals(authorizedPerson.getLastName());
             */

            return false;
        }

    }

    public Map<String, Double> getAverageBalanceReport() {
        // TODO: complete the method
        List<Account> commercialAccountList= accounts.values().stream().filter(account -> account instanceof CommercialAccount ).collect(Collectors.toList());
        List<Account> consumerAccountList= accounts.values().stream().filter(account -> account instanceof ConsumerAccount ).collect(Collectors.toList());

        Map<String,Double> balanceReport=new HashMap<>();
        double commercialBalance=0.0;
        double consumerBalance=0.0;
        
        for (Account account: commercialAccountList){
            commercialBalance+=account.getBalance();
        }

        for (Account account: consumerAccountList){
            consumerBalance+=account.getBalance();
        }

        balanceReport.put(ConsumerAccount.class.getSimpleName(),consumerBalance / consumerAccountList.size());
        balanceReport.put(CommercialAccount.class.getSimpleName(),commercialBalance / commercialAccountList.size());

        return balanceReport;
    }
}
