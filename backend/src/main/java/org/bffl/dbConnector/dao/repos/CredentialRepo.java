package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepo extends JpaRepository<Credential, String> {}
