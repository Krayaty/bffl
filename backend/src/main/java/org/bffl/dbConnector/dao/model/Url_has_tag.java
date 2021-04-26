package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_url_has_tags_id;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url_has_tag", schema = "bffl")
public class Url_has_tag {

    @EmbeddedId
    private Composite_url_has_tags_id id;

    @MapsId("tag_id")
    @ManyToOne(targetEntity = Tag.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    private Tag url_has_tags_tag;

    @MapsId("short_url_id")
    @ManyToOne(targetEntity = Short_url.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "short_url_id")
    private Short_url url_has_tags_short_url;

}

