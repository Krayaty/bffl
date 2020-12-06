package org.bffl.dao.repo;

import org.bffl.dao.model.App_user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface App_userRepo extends JpaRepository<App_user, Long> {

    ArrayList<App_user> findByName(String fName, String sName);

}
