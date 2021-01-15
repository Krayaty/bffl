package org.bffl.dao.repo;

import org.bffl.dao.model.App_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface App_userRepo extends JpaRepository<App_user, Long> {}
