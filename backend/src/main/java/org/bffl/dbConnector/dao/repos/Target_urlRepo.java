package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Target_url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Target_urlRepo extends JpaRepository<Target_url, String> {}
