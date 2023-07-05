package com.project.db.mju.webserver.web.v1.dto;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.domain.Job;
import com.project.db.mju.webserver.web.v1.domain.Project;
import com.project.db.mju.webserver.web.v1.domain.ProjectDetail;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetailViewResponseDto {
    private String employeeName;
    private String jobType;
    private LocalDateTime joinDate;
    private LocalDateTime quitDate;

    public static ProjectDetailViewResponseDto of(ProjectDetail detail, Project project, Employee employee, Job job) {
        return ProjectDetailViewResponseDto.builder()
                .employeeName(employee.getName())
                .jobType(job.getType())
                .joinDate(detail.getJoinDate())
                .quitDate(detail.getQuitDate())
                .build();
            }
}
