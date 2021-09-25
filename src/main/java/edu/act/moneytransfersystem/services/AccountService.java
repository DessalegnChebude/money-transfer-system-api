package edu.act.moneytransfersystem.services;

import edu.act.moneytransfersystem.domains.Account;
import edu.act.moneytransfersystem.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        int age = calculateAge(account.getDateOfBirth(), LocalDate.now());
        if(age > 15){
            return accountRepository.save(account);
        }
        else{
            System.out.println("User under age of 15 cannot register");
            return null;
        }

    }

    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }

    }
    public Iterable<Account> allAccounts () { return accountRepository.findAll();}
    }

