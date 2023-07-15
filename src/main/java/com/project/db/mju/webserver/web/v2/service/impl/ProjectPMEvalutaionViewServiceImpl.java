package com.project.db.mju.webserver.web.v2.service.impl;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.domain.ProjectPMEvaluation;
import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewDto;
import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewRequestDto;
import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import com.project.db.mju.webserver.web.v1.repository.ProjectPMEvaluationRepository;
import com.project.db.mju.webserver.web.v2.service.ProjectPMEvalutaionViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "v2ProjectPMEvaluationService")
public class ProjectPMEvalutaionViewServiceImpl implements ProjectPMEvalutaionViewService {

    private final ProjectPMEvaluationRepository pmEvaluationRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ProjectPMEvalutaionViewServiceImpl(ProjectPMEvaluationRepository pmEvaluationRepository, EmployeeRepository employeeRepository) {
        this.pmEvaluationRepository = pmEvaluationRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<ProjectPMEvaluationViewDto> getAllEvals(ProjectPMEvaluationViewRequestDto requestDto) {
        Employee evaluator = employeeRepository.findByName(requestDto.getEvaluatorName())
                .orElseThrow(() -> new RuntimeException()); // TODO: 예외 구현 시 orElseThrow 처리

        List<ProjectPMEvaluation> allEval = pmEvaluationRepository.getAllByProjectIdAndEvaluator(
                requestDto.getProjectId(),
                evaluator.getId()
        );

        List<ProjectPMEvaluationViewDto> dtos = new ArrayList<>();

        allEval.forEach(evaluation -> {
            Employee evaluated = employeeRepository.findById(evaluation.getEvaluated())
                    .get();
            dtos.add(ProjectPMEvaluationViewDto.of(evaluation, evaluator, evaluated));

        });
        return dtos;

    }
}
