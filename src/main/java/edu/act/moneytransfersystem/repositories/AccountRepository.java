package edu.act.moneytransfersystem.repositories;

import edu.act.moneytransfersystem.domains.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Class name and data type of the ID fields

@Repository
public interface AccountRepository extends CrudRepository <Account, Long>{}
