package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.domain.ProjectPMEvaluation;
import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewDto;
import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewRequestDto;
import com.project.db.mju.webserver.web.v1.repository.ProjectPMEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service(value = "v2ProjectPMEvaluationService")
public class ProjectPMEvalutaionViewService {

    private final ProjectPMEvaluationRepository pmEvaluationRepository;
    private final EmployeeService employeeService;

    @Autowired
    public ProjectPMEvalutaionViewService(ProjectPMEvaluationRepository pmEvaluationRepository, EmployeeService employeeService) {
        this.pmEvaluationRepository = pmEvaluationRepository;
        this.employeeService = employeeService;
    }

    public List<ProjectPMEvaluationViewDto> getAllEvals(ProjectPMEvaluationViewRequestDto requestDto) {
        Employee evaluator = employeeService.getByName(requestDto.getEvaluatorName());

        Collection<ProjectPMEvaluation> eval = pmEvaluationRepository.getAllPmEvaluations(requestDto.getProjectId(), evaluator.getId());
        List<ProjectPMEvaluationViewDto> dtos = new ArrayList<>();

        for (ProjectPMEvaluation c: eval) {
            dtos.add(new ProjectPMEvaluationViewDto(
                    c.getProjectId(),
                    employeeService.getById(c.getEvaluator()).getName(),
                    employeeService.getById(c.getEvaluated()).getName(),
                    c.getCommunicationComment(),
                    c.getBusinessComment(),
                    c.getCommunicationRate(),
                    c.getBusinessRate()
            ));
        }

        return dtos;

    }
}
