package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.App_group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface App_groupRepo extends JpaRepository<App_group, String> {
}
