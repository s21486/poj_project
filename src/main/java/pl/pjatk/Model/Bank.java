package pl.pjatk.Model;

import java.util.List;

public class Bank extends Entity {
    private String bankId;
    private List<Account> accountList;

    public Bank(String bankId, List<Account> accountList) {
        this.bankId = bankId;
        this.accountList = accountList;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccountByNumber(String accountNumber){
        accountList.removeIf(account -> account.getAccountNumber() == accountNumber);
    }

    @Override
    public void printToScreen() {
        System.out.println("Bank Id: " + bankId);
    }
}
