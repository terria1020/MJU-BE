package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewDto;
import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewRequestDto;

import java.util.List;

public interface ProjectPMEvalutaionViewService {
    public List<ProjectPMEvaluationViewDto> getAllEvals(ProjectPMEvaluationViewRequestDto requestDto);
}
