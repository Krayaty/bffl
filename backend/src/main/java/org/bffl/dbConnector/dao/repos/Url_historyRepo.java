package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_url_history_id;
import org.bffl.dbConnector.dao.model.Url_history;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Url_historyRepo extends JpaRepository<Url_history, Composite_url_history_id> {}
