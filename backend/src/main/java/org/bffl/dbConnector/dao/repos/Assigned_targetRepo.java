package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_assigned_target_id;
import org.bffl.dbConnector.dao.model.Assigned_target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Assigned_targetRepo extends JpaRepository<Assigned_target, Composite_assigned_target_id> {}
