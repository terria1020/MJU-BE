package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.domain.Project;
import com.project.db.mju.webserver.web.v1.dto.ProjectDto;
import com.project.db.mju.webserver.web.v1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "v2ProjectService")
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectDto findProjectByProjectName(String name) {
        final Project project = projectRepository.findProjectByProjectName(name);

        return new ProjectDto(project);
    }

    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectDto::new)
                .collect(Collectors.toList());
    }
}
