package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Short_url;
import org.bffl.dbConnector.dao.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag, String> {}
