package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    public ProjectDto findProjectByProjectName(String name);
    public List<ProjectDto> getAllProjects();
}
