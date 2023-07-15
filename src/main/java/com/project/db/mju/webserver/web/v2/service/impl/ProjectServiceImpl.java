package com.project.db.mju.webserver.web.v2.service.impl;

import com.project.db.mju.webserver.web.v1.domain.Project;
import com.project.db.mju.webserver.web.v1.dto.ProjectDto;
import com.project.db.mju.webserver.web.v1.repository.ProjectRepository;
import com.project.db.mju.webserver.web.v2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "v2ProjectService")
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional(readOnly = true)
    public ProjectDto findProjectByProjectName(String name) {
        Project found = projectRepository.findByProjectName(name)
                .orElseThrow(() -> new RuntimeException()); // TODO: 예외 구현 시 orElseThrow 처리
        return new ProjectDto(found);
    }

    @Transactional(readOnly = true)
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectDto::new)
                .collect(Collectors.toList());
    }
}
