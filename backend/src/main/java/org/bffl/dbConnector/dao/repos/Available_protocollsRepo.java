package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Available_protocolls;
import org.bffl.dbConnector.dao.idClasses.Composite_available_protocolls_id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Available_protocollsRepo extends JpaRepository<Available_protocolls, Composite_available_protocolls_id> {}

