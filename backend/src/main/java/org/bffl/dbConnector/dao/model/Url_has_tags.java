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
@IdClass(Composite_url_has_tags_id.class)
@Table(name = "url_has_tags", schema = "bffl")
public class Url_has_tags {

    @Id
    private String short_url_id;

    @Id
    private String tag_name;

}

