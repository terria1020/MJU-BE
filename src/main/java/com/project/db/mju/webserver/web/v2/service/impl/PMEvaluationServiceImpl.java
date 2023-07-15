package com.project.db.mju.webserver.web.v2.service.impl;

import com.project.db.mju.webserver.web.v1.domain.ProjectPMEvaluation;
import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationDto;
import com.project.db.mju.webserver.web.v1.repository.ProjectPMEvaluationRepository;
import com.project.db.mju.webserver.web.v2.service.PMEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "v2PMEvaluationService")
public class PMEvaluationServiceImpl implements PMEvaluationService {
    private final ProjectPMEvaluationRepository projectPMEvaluationRepository;

    @Autowired
    public PMEvaluationServiceImpl(ProjectPMEvaluationRepository projectPMEvaluationRepository) {
        this.projectPMEvaluationRepository = projectPMEvaluationRepository;
    }

    @Transactional
    public int putProjectPMEvaluation(ProjectPMEvaluationDto projectPMEvaluationDto) {
        ProjectPMEvaluation pmEvaluation = ProjectPMEvaluation.builder()
                .projectId((projectPMEvaluationDto.getProjectId()))
                .communicationRate(projectPMEvaluationDto.getCommunicationRate())
                .communicationComment(projectPMEvaluationDto.getCommunicationComment())
                .businessRate(projectPMEvaluationDto.getBusinessRate())
                .businessComment(projectPMEvaluationDto.getBusinessComment())
                .evaluator(projectPMEvaluationDto.getEvaluator())
                .evaluated(projectPMEvaluationDto.getEvaluated())
                .build();

        return projectPMEvaluationRepository.save(pmEvaluation).getProjectId().intValue();
    }

    @Transactional
    public int updateProjectPMEvalutaion(ProjectPMEvaluationDto projectPMEvaluationDto) {
        ProjectPMEvaluation found = projectPMEvaluationRepository.findByProjectIdAndEvaluated(projectPMEvaluationDto.getProjectId(), projectPMEvaluationDto.getEvaluated())
                .orElseThrow(() -> new RuntimeException());
        if (found.updateAndGetResult(projectPMEvaluationDto)) return 1;
        else return 0;
    }
}
