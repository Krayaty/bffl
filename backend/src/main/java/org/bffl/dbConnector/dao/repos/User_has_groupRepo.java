package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_user_has_group_id;
import org.bffl.dbConnector.dao.model.User_has_group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_has_groupRepo extends JpaRepository<User_has_group, Composite_user_has_group_id> {}
