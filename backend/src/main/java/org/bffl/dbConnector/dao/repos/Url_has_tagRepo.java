package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_url_has_tags_id;
import org.bffl.dbConnector.dao.model.Url_has_tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Url_has_tagRepo extends JpaRepository<Url_has_tag, Composite_url_has_tags_id> {}
