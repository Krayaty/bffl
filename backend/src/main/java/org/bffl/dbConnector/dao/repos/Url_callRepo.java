package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_url_call_id;
import org.bffl.dbConnector.dao.model.Url_call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Url_callRepo extends JpaRepository<Url_call, Composite_url_call_id> {

    @Query(nativeQuery = true, value =
            "SELECT C.client_ip, S.group_name, S.custom_suffix, T.url, C.call_timestamp " +
            "FROM url_call C " +
            "INNER JOIN short_url S ON C.short_url_id = S.id " +
            "INNER JOIN assigned_target T ON S.id = T.short_url_id " +
            "WHERE S.id = 1 AND T.assign_timestamp = (" +
                    "SELECT assign_timestamp " +
                    "FROM assigned_target " +
                    "WHERE short_url_id = S.id AND assign_timestamp <= C.call_timestamp " +
                    "ORDER BY assign_timestamp DESC LIMIT 1" +
            ");")
    List<Object> findAllCallsOfShortURL(int searched_short_url_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "INSERT INTO url_call (client_ip, short_url_id, call_timestamp)" +
            "VALUES (:new_client_ip, (" +
                    "SELECT id " +
                    "FROM short_url " +
                    "WHERE group_name = :searched_group_name AND custom_suffix = :searched_custom_suffix" +
            "), CURRENT_TIMESTAMP);")
    int saveUrlCall(String searched_group_name, String searched_custom_suffix, String new_client_ip);

}
