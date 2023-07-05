package com.project.db.mju.webserver.web.v1.dto;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.domain.ProjectPMEvaluation;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPMEvaluationViewDto {
    private Long projectId;

    private String evaluator;
    private String evaluated;

    private String communicationComment;
    private String businessComment;

    private Long communicationRate;
    private Long businessRate;

    public static ProjectPMEvaluationViewDto of(ProjectPMEvaluation pmEval, Employee evaluator, Employee evaluated) {
        return ProjectPMEvaluationViewDto.builder()
                .projectId(pmEval.getProjectId())
                .evaluator(evaluator.getName())
                .evaluated(evaluated.getName())
                .communicationComment(pmEval.getCommunicationComment())
                .businessComment(pmEval.getBusinessComment())
                .communicationRate(pmEval.getCommunicationRate())
                .businessRate(pmEval.getBusinessRate())
                .build();
    }
}
