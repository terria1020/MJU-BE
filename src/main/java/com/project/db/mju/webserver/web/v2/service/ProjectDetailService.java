package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.dto.ProjectDetailViewResponseDto;

import java.util.List;

public interface ProjectDetailService {
    public List<ProjectDetailViewResponseDto> getAllDetails(Long projectId);

    public List<ProjectDetailViewResponseDto> getAllDetailsByProjName(String projectName);
}
