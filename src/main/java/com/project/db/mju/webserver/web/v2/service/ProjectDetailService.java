package com.project.db.mju.webserver.web.v2.service;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import com.project.db.mju.webserver.web.v1.domain.Job;
import com.project.db.mju.webserver.web.v1.domain.Project;
import com.project.db.mju.webserver.web.v1.domain.ProjectDetail;
import com.project.db.mju.webserver.web.v1.dto.ProjectDetailViewResponseDto;
import com.project.db.mju.webserver.web.v1.repository.EmployeeRepository;
import com.project.db.mju.webserver.web.v1.repository.JobRepository;
import com.project.db.mju.webserver.web.v1.repository.ProjectDetailRepository;
import com.project.db.mju.webserver.web.v1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "v2ProjectDetailService")
public class ProjectDetailService {

    private final ProjectDetailRepository detailRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    @Autowired
    public ProjectDetailService(ProjectDetailRepository detailRepository, ProjectRepository projectRepository, EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.detailRepository = detailRepository;
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @Transactional(readOnly = true)
    public List<ProjectDetailViewResponseDto> getAllDetails(Long projectId) {
        List<ProjectDetail> details = detailRepository.findAllByProjectId(projectId);
        return details.stream()
                .map(this::getDetailViewResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProjectDetailViewResponseDto> getAllDetailsByProjName(String projectName) {
        Project found = projectRepository.findByProjectName(projectName)
                .orElseThrow(() -> new RuntimeException());
        return getAllDetails(found.getId());
    }

    @Transactional(readOnly = true)
    private ProjectDetailViewResponseDto getDetailViewResponseDto(ProjectDetail detail) {
        Project project = projectRepository.findById(detail.getProjectId())
                .orElseThrow(() -> new RuntimeException());

        Employee employee = employeeRepository.findById(detail.getEmployeeNumber())
                .orElseThrow(() -> new RuntimeException());
        Job job = jobRepository.findById(detail.getEmployeeJob()).orElseThrow(() -> new RuntimeException());

        return ProjectDetailViewResponseDto.of(detail, project, employee, job);
    }
}
