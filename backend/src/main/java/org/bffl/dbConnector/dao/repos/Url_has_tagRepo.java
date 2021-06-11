package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.idClasses.Composite_url_has_tags_id;
import org.bffl.dbConnector.dao.model.Url_has_tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface Url_has_tagRepo extends JpaRepository<Url_has_tag, Composite_url_has_tags_id> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "INSERT INTO url_has_tag (short_url_id, tag_id)" +
            "VALUES (:searched_short_url_id, (" +
                    "SELECT id " +
                    "FROM tag " +
                    "WHERE group_name = ( " +
                        "SELECT group_name " +
                        "FROM short_url " +
                        "WHERE id = :searched_short_url_id) AND id = :chosen_tag_id" +
                    ")" +
            ");")
    Integer saveTagOfGroupToShortURLByID(int chosen_tag_id, int searched_short_url_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "INSERT INTO url_has_tag (short_url_id, tag_id)" +
            "VALUES ((" +
                    "SELECT id " +
                    "FROM short_url " +
                    "WHERE group_name = :searched_group_name AND custom_suffix = :searched_custom_suffix;" +
            "), (" +
                    "SELECT id " +
                    "FROM tag " +
                    "WHERE group_name = :searched_group_name AND id = :chosen_tag_id" +
            "));")
    Integer saveTagOfGroupToShortURLBySuffix(int chosen_tag_id, String searched_group_name, String searched_custom_suffix);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "DELETE FROM url_has_tag " +
            "WHERE tag_id = :searched_tag_id AND short_url_id = :searched_short_url_id")
    Integer deleteUrlHasTagAssignment(int searched_tag_id, int searched_short_url_id);

}
