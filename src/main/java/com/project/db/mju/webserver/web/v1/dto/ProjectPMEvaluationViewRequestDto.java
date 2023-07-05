package com.project.db.mju.webserver.web.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectPMEvaluationViewRequestDto {
    private Long projectId;
    private String evaluatorName;

    public static ProjectPMEvaluationViewRequestDto of(Long projectId, String evaluatorName) {
        return new ProjectPMEvaluationViewRequestDto(projectId, evaluatorName);
    }
}
