package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_assigned_target_id;
import org.bffl.dbConnector.dao.model.Assigned_target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Assigned_targetRepo extends JpaRepository<Assigned_target, Composite_assigned_target_id> {

    @Query(nativeQuery = true, value =
            "SELECT * " +
                    "FROM assigned_target " +
                    "WHERE short_url_id = :searched_short_url_id " +
                    "ORDER BY assign_timestamp DESC;")
    List<Object> findAllAssignedTargetsOfShortURL(int searched_short_url_id);

    @Query(nativeQuery = true, value =
            "SELECT T.url " +
            "FROM assigned_target T " +
            "WHERE T.short_url_id = (" +
                    "SELECT id " +
                    "FROM short_url " +
                    "WHERE group_name = :searched_group_name AND custom_suffix = :searched_custom_suffix" +
            ") AND assign_timestamp = (" +
                    "SELECT MAX(assign_timestamp) " +
                    "FROM assigned_target " +
                    "WHERE short_url_id = T.short_url_id " +
                    "GROUP BY short_url_id" +
            ");")
    String findAssignedTargetOfShortUrl(String searched_group_name, String searched_custom_suffix);
    
    @Modifying
    @Query(nativeQuery = true, value =
            "INSERT INTO assigned_target (short_url_id, assign_timestamp, url) " +
            "VALUES ((" +
                    "SELECT id " +
                    "FROM short_url " +
                    "WHERE custom_suffix = :new_custom_suffix AND group_name = :new_group_name" +
            "), CURRENT_TIMESTAMP, :new_target_url); ")
    Boolean saveTargetOfNewShortURL(String new_group_name, String new_custom_suffix, String new_target_url);

    @Modifying
    @Query(nativeQuery = true, value =
            "INSERT INTO assigned_target(url, assign_timestamp, short_url_id) " +
            "VALUES (:new_target_url, CURRENT_TIMESTAMP, (" +
                    "SELECT id " +
                    "FROM short_url " +
                    "WHERE update_flag = true AND id = :searched_short_url_id" +
            "));")
    Boolean saveNewTargetOfShortURL(int searched_short_url_id, String new_target_url);

}
