package org.bffl.dbConnector.dao.repos;

import org.bffl.dbConnector.dao.model.App_user;
import org.bffl.dbConnector.dao.model.Target_url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface Target_urlRepo extends JpaRepository<Target_url, String> {}
