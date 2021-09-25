package edu.act.moneytransfersystem;

import edu.act.moneytransfersystem.domains.Account;
import edu.act.moneytransfersystem.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccountRepositoryIntegrationTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void shouldCreateAnAccountInDB(){

//        Account account = Account.builder()
//        account.setFirstName("Dessalegn");
//        account.setMiddleName("Chebude");
//        account.setLastName("W/yohanis");

        Account account = Account.builder()
                .firstName("Dessalegn")
                .middleName("Chebude")
                .lastName("W/yohanis")
                .dateOfBirth(LocalDate.of(2000,01,01))
                .phoneNumber("9256482565")
                .email("dessalegn@gmail.com")
                .pin(12345)
                .build();
        Account savedAccount = accountRepository.save(account);
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getId()).isEqualTo(1);

        assertThat(savedAccount.getFirstName()).isEqualTo("Dessalegn");
        assertThat(savedAccount.getFirstName()).isEqualTo(account.getFirstName());


    }
}
