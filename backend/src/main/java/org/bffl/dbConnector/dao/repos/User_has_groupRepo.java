package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_user_has_group_id;
import org.bffl.dbConnector.dao.model.User_has_group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_has_groupRepo extends JpaRepository<User_has_group, Composite_user_has_group_id> {

    @Query(nativeQuery = true, value =
            "SELECT group_name " +
                    "FROM user_has_group " +
                    "WHERE user_id = :searched_user_id " +
                    "AND (end_timestamp IS NULL " +
                    "OR end_timestamp > CURRENT_TIMESTAMP) " +
                    "ORDER BY end_timestamp DESC;")
    public List<Object> findAlLGroupsOfUser(String searched_user_id);

}
