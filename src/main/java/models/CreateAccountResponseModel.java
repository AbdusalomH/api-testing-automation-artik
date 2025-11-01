package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateAccountResponseModel extends BaseModel {
    private long id;
    private String accountNumber;
    private double balance;
    private List<Transactions> transactions;

    public long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }
}
