package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.Short_url;
import org.bffl.dbConnector.dao.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag, String> {

    @Query(nativeQuery = true, value =
            "SELECT T.title,  T.description, T.color " +
            "FROM url_has_tag UhT, Tag T " +
            "WHERE UhT.tag_id = T.id AND UhT.short_url_id = :searched_short_url_id;")
    public List<Object> findAllTagsAssignedToShortURL(int searched_short_url_id);


    /*@Query(nativeQuery = true, value =
            "SELECT id, title, description, color " +
            "FROM Tag " +
            "WHERE group_name = :searched_group_name")
    public List<Object> findAllTagsOfGroup(String searched_group_name);*/

    public List<Tag> findAllTagsOfGroup(String searched_group_name);

    @Query(nativeQuery = true, value =
            "SELECT T.id, T.title, T.description, T.color " +
            "FROM Tag T, short_url S " +
            "WHERE T.group_name = S.group_name AND S.id = :searched_group_name")
    public List<Object> findAllPossibleTagsForShortURL(int searched_short_url_id);

}
