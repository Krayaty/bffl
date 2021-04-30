package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Short_url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Short_urlRepo extends JpaRepository<Short_url, String> {

    @Query(nativeQuery = true, value =
            "SELECT S.id, S.group_name, S.custom_suffix, S.create_timestamp, S.scope, S.delete_flag, S.update_flag, T.url, T.assign_timestamp " +
            "FROM ( SELECT * " +
                "FROM short_url " +
                "WHERE group_name = :searched_group_name " +
            ") AS S INNER JOIN (" +
                "SELECT X.short_url_id, MAX(X.assign_timestamp) AS assign_timestamp, (" +
                    "SELECT url " +
                    "FROM assigned_target " +
                    "WHERE short_url_id = X.short_url_id AND assign_timestamp = MAX(X.assign_timestamp)" +
                ") FROM assigned_target X " +
                "GROUP BY X.short_url_id" +
            ") AS T ON S.id = T.short_url_id;")
    public List<Object> findAllShortURLsWithCurrentTargetByGroup(String searched_group_name);


    @Query(nativeQuery = true, value =
            "SELECT S.*, T.url, T.assign_timestamp " +
            "FROM (" +
                    "SELECT *" +
                    "FROM short_url " +
                    "WHERE id = :searched_short_url_id" +
            ") AS S INNER JOIN (" +
                    "SELECT X.short_url_id, MAX(X.assign_timestamp) AS assign_timestamp, (" +
                        "SELECT url " +
                        "FROM assigned_target " +
                        "WHERE short_url_id = X.short_url_id AND assign_timestamp = MAX(X.assign_timestamp)" +
                    ") FROM assigned_target X " +
                    "WHERE X.short_url_id = :searched_short_url_id " +
                    "GROUP BY X.short_url_id" +
            ") AS T ON S.id = T.short_url_id")
    public List<Object> findShortURLWithCurrentTargetByID(int searched_short_url_id);

    @Query(nativeQuery = true, value =
            "INSERT INTO short_url (group_name, custom_suffix, scope, delete_flag, update_flag, create_timestamp) " +
            "VALUES (:new_group_name:, :new_custom_suffix:, :new_scope, :new_delete_flag, :new_update_flag, CURRENT_TIMESTAMP); ")
    public void saveShortURL(String new_group_name, String new_custom_suffix, String new_scope, String new_delete_flag, String new_update_flag);

}

