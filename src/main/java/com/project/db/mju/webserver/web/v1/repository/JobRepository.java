package com.project.db.mju.webserver.web.v1.repository;

import com.project.db.mju.webserver.web.v1.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
