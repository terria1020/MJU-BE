package com.project.db.mju.webserver.web.v1.repository;

import com.project.db.mju.webserver.web.v1.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long> {
    public Project findProjectByProjectName(String name);
    public Optional<Project> findByProjectName(String name);
}
