package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_assigned_target_id;
import org.bffl.dbConnector.dao.model.Assigned_target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Assigned_targetRepo extends JpaRepository<Assigned_target, Composite_assigned_target_id> {

    @Query(nativeQuery = true, value =
            "INSERT INTO assigned_target (short_url_id, assign_timestamp, url) " +
            "VALUES ((" +
                    "SELECT id " +
                    "FROM short_url " +
                    "WHERE custom_suffix = :new_custom_suffix AND group_name = :new_group_name" +
            "), CURRENT_TIMESTAMP, :new_target_url); ")
    public void saveTargetOfNewShortURL(String new_group_name, String new_custom_suffix, String new_target_url);

}
