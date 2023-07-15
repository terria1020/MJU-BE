package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationDto;

public interface PMEvaluationService {
    public int putProjectPMEvaluation(ProjectPMEvaluationDto projectPMEvaluationDto);
    public int updateProjectPMEvalutaion(ProjectPMEvaluationDto projectPMEvaluationDto);
}
