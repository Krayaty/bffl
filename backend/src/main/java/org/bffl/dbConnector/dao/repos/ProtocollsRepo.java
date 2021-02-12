package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Protocolls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocollsRepo extends JpaRepository<Protocolls, String> {}
