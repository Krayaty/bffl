package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends JpaRepository<Tag, String> {}
