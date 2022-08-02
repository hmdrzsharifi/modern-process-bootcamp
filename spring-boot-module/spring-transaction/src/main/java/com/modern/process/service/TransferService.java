package com.modern.process.service;

import com.modern.process.model.Account;
import com.modern.process.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {

            Account sender = accountRepository.findById(idSender).orElse(null);
            Account receiver = accountRepository.findById(idReceiver).orElse(null);

            BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
            BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

            accountRepository.changeAmount(idSender, senderNewAmount);
            accountRepository.changeAmount(idReceiver, receiverNewAmount);

            // throw new RuntimeException("Oh no! Something went wrong!");
    }

    /*@Transactional (rollbackOn = Exception.class)
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws FileNotFoundException {

        try {
            Account sender = accountRepository.findById(idSender).orElse(null);
            Account receiver = accountRepository.findById(idReceiver).orElse(null);

            BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
            BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

            accountRepository.changeAmount(idSender, senderNewAmount);
            accountRepository.changeAmount(idReceiver, receiverNewAmount);

            throw new RuntimeException("Oh no! Something went wrong!");
        } catch (Exception exp) {
            throw new FileNotFoundException("Oh no! Something went wrong!");
        }
    }*/

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
}
