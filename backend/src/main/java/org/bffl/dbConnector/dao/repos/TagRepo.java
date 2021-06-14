package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag, Integer> {

    @Query(nativeQuery = true, value =
            "SELECT T.id, T.title, T.description, T.color " +
            "FROM url_has_tag UhT, Tag T " +
            "WHERE UhT.tag_id = T.id AND UhT.short_url_id = :searched_short_url_id")
    List<Object> findAllTagsAssignedToShortURL(int searched_short_url_id);


    @Query(nativeQuery = true, value =
            "SELECT id, title, description, color " +
            "FROM Tag " +
            "WHERE group_name = :searched_group_name")
    List<Object> findAllTagsOfGroup(String searched_group_name);

    @Query(nativeQuery = true, value =
            "SELECT T.id, T.title, T.description, T.color " +
            "FROM Tag T, short_url S " +
            "WHERE T.group_name = S.group_name " +
            "AND NOT EXISTS ( " +
                    "SELECT * " +
                    "FROM url_has_tag " +
                    "WHERE tag_id = T.id " +
                    "AND short_url_id = S.id) " +
            "AND S.id = :searched_short_url_id")
    List<Object> findAllPossibleTagsForShortURL(int searched_short_url_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE tag " +
            "SET title = :new_title " +
            "WHERE title != :new_title AND id = :searched_tag_id")
    Integer updateTitleOfTag(int searched_tag_id, String new_title);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE tag " +
            "SET description = :new_description " +
            "WHERE description != :new_description AND id = :searched_tag_id")
    Integer updateDescriptionOfTag(int searched_tag_id, String new_description);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "UPDATE tag " +
            "SET color = :new_color " +
            "WHERE color != :new_color AND id = :searched_tag_id")
    Integer updateColorOfTag(int searched_tag_id, String new_color);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "DELETE FROM tag " +
            "WHERE id = :searched_tag_id;")
    Integer deleteTagById(int searched_tag_id);

}
