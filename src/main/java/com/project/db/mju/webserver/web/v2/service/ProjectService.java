package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.domain.Project;
import com.project.db.mju.webserver.web.v1.dto.ProjectDto;
import com.project.db.mju.webserver.web.v1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "v2ProjectService")
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectDto findProjectByProjectName(String name) {
        final Project project = projectRepository.findProjectByProjectName(name);

        return new ProjectDto(project);
    }
}
