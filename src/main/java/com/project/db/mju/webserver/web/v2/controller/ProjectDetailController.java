package com.project.db.mju.webserver.web.v2.controller;

import com.project.db.mju.webserver.web.v1.dto.ProjectDetailViewResponseDto;
import com.project.db.mju.webserver.web.v2.service.ProjectDetailService;
import com.project.db.mju.webserver.web.v2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v2")

@RestController(value = "v2ProjectDetailController")
public class ProjectDetailController {

    @Autowired
    ProjectDetailService detailService;

    @Autowired
    ProjectService projectService;

    @GetMapping("/view/{projectName}/detail/")
    public List<ProjectDetailViewResponseDto> projectDetailView(@PathVariable(name = "projectName") String name) {

        Long projectId = projectService.findProjectByProjectName(name).getId();

        List<ProjectDetailViewResponseDto> allDetails = detailService.getAllDetails(projectId);
        return allDetails;
    }
}
