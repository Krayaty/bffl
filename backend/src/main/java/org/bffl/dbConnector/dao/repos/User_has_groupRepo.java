package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_user_has_group_id;
import org.bffl.dbConnector.dao.model.User_has_group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    List<Object> findAlLGroupsOfUser(String searched_user_id);

    @Query(nativeQuery = true, value =
            "SELECT admin_flag " +
            "FROM user_has_group " +
            "WHERE user_id = :searched_user_id " +
            "AND group_name = :searched_group_name " +
            "AND ( " +
                "end_timestamp IS NULL " +
                "OR end_timestamp > CURRENT_TIMESTAMP" +
            ")")
    List<Object> findIsUserAdminOfGroup(String searched_user_id, String searched_group_name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "INSERT into user_has_group (user_id, group_name, start_timestamp, end_timestamp) " +
                    "VALUES (:new_user_id, :searched_group_name, CURRENT_TIMESTAMP, :new_end_timestamp);")
    Integer saveUserAssignToGroup(String searched_group_name, String new_user_id, int new_end_timestamp);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "INSERT INTO user_has_group (user_id, group_name, start_timestamp, end_timestamp, admin_flag) " +
            "VALUES (:new_user_id, (" +
                    "SELECT G.name " +
                    "FROM app_group_g, user_has_group UhG " +
                    "WHERE UhG.group_name = G.name AND G.name = :searched_group_name AND UhG.user_id = :groupmember_user_id AND UhG.admin_flag = true" +
            "), CURRENT_TIMESTAMP, :new_end_timestamp, true);")
    Integer saveUserAssignAsAdminToGroup(String groupmember_user_id, String searched_group_name, String new_user_id, int new_end_timestamp);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE user_has_group " +
            "SET admin_flag = :new_admin_flag " +
            "WHERE user_id = :searched_user_id AND group_name = (" +
                    "SELECT group_name " +
                    "FROM user_has_group " +
                    "WHERE user_id = :groupmember_user_id AND admin_flag = true AND group_name = :searched_group_name" +
            ");")
    Integer updateAdminStateOfUser(String groupmember_user_id, String searched_user_id, String searched_group_name, boolean new_admin_flag);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE user_has_group " +
            "SET end_timestamp = :new_end_timestamp " +
            "WHERE (" +
                    ":new_end_timestamp IS NULL OR CURRENT_TIMESTAMP + 3600  * interval '1' < :new_end_timestamp" +
            ") AND user_id = :searched_user_id AND group_name = (" +
                    "SELECT group_name " +
                    "FROM user_has_group " +
                    "WHERE user_id = :groupmember_user_id AND admin_flag = true AND group_name = :searched_group_name" +
            ");")
    Integer updateEndTimestampOfUser(String groupmember_user_id, String searched_user_id, String searched_group_name, int new_end_timestamp);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "DELETE FROM user_has_group " +
            "WHERE user_id = :searched_user_id AND group_name = (" +
                    "SELECT group_name " +
                    "FROM user_has_group " +
                    "WHERE group_name = :searched_group_name AND user_id = :groupmember_user_id AND admin_flag = true" +
            ");")
    Integer deleteUserOfGroupAssignment(String groupmember_user_id, String searched_user_id, String searched_group_name);

}
