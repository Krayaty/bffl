package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.App_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface App_userRepo extends JpaRepository<App_user, String> {}
