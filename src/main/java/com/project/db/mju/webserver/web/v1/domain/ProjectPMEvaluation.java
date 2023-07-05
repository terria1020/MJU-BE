package com.project.db.mju.webserver.web.v1.domain;

import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "project_pm_evaluation")
public class ProjectPMEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private Long projectId;
    @Column(name = "communication_rate")
    private Long communicationRate;
    @Column(name = "business_rate")
    private Long businessRate;

    @Column(name = "evaluator", nullable = false)
    private Long evaluator;
    @Column(name = "evaluated", nullable = false)
    private Long evaluated;

    @Column(name = "communication_comment")
    private String communicationComment;

    @Column(name = "business_comment")
    private String businessComment;

    public boolean updateAndGetResult(ProjectPMEvaluationDto dto) {
        if (this.evaluator.equals(dto.getEvaluator()) && evaluated.equals(dto.getEvaluated())) {
            this.businessComment = dto.getBusinessComment();
            this.businessRate = dto.getBusinessRate();
            this.communicationComment = dto.getCommunicationComment();
            this.communicationRate = dto.getCommunicationRate();
            return true;
        }
        return false;
    }
}
