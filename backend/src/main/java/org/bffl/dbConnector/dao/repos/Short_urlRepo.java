package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Short_url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Short_urlRepo extends JpaRepository<Short_url, Integer> {

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
    List<Object> findAllShortURLsWithCurrentTargetByGroup(String searched_group_name);


    @Query(nativeQuery = true, value =
            "SELECT S.id, S.group_name, S.custom_suffix, S.create_timestamp, S.scope, S.delete_flag, S.update_flag, T.url, T.assign_timestamp " +
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
    List<Object> findShortURLWithCurrentTargetByID(int searched_short_url_id);

    @Query(nativeQuery = true, value =
            "SELECT * " +
            "FROM short_url " +
            "WHERE custom_suffix = :searched_custom_suffix " +
            "AND group_name = :searched_group_name")
    List<Short_url> findShortURLBySuffix(String searched_group_name, String searched_custom_suffix);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "INSERT INTO short_url (group_name, custom_suffix, scope, delete_flag, update_flag, create_timestamp) " +
            "VALUES (:new_group_name, :new_custom_suffix, :new_scope, :new_delete_flag, :new_update_flag, CURRENT_TIMESTAMP); ")
    Integer saveShortURL(String new_group_name, String new_custom_suffix, int new_scope, boolean new_delete_flag, boolean new_update_flag);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE short_url " +
            "SET custom_suffix = :new_custom_suffix " +
            "WHERE id = :searched_short_url_id AND NOT custom_suffix = :new_custom_suffix AND update_flag = true;")
    Integer updateSuffixOfShortURL(int searched_short_url_id, String new_custom_suffix);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE short_url " +
            "SET scope = :new_scope " +
            "WHERE CURRENT_TIMESTAMP + 3600 * interval '1 second' < (" +
                    "(SELECT create_timestamp " +
                    "FROM short_url " +
                    "WHERE id = :searched_short_url_id) + :new_scope * interval '1 second'" +
            ") AND NOT scope = :new_scope AND id = :searched_short_url_id AND update_flag = true;")
    Integer updateScopeOfShortURL(int searched_short_url_id, int new_scope);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE short_url " +
            "SET delete_flag = :new_delete_flag " +
            "WHERE NOT delete_flag = :new_delete_flag AND id = :searched_short_url_id")
    Integer updateDeleteFlagOfShortURL(int searched_short_url_id, boolean new_delete_flag);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE short_url " +
            "SET update_flag = :new_update_flag " +
            "WHERE NOT update_flag = :new_update_flag AND id = :searched_short_url_id")
    Integer updateUpdateFlagOfShortURL(int searched_short_url_id, boolean new_update_flag);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "DELETE FROM short_url " +
            "WHERE id = :searched_short_url_id AND delete_flag = true;")
    Integer deleteShortURL(int searched_short_url_id);

}

