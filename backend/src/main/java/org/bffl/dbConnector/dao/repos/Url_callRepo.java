package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_url_call_id;
import org.bffl.dbConnector.dao.model.Url_call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Url_callRepo extends JpaRepository<Url_call, Composite_url_call_id> {}
