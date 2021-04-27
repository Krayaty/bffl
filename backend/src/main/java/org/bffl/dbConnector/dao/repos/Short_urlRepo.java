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
    public List<Object> findAllShortURLsWithCurrentTargetByGroupName(String searched_group_name);

}

