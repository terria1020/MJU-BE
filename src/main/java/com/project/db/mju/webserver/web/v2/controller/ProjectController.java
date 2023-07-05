package com.project.db.mju.webserver.web.v2.controller;

import com.project.db.mju.webserver.web.v1.dto.ProjectDetailViewResponseDto;
import com.project.db.mju.webserver.web.v1.dto.ProjectDto;
import com.project.db.mju.webserver.web.v2.service.ProjectDetailService;
import com.project.db.mju.webserver.web.v2.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "v2ProjectController")
@RequestMapping("/api/v2")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectDetailService projectDetailService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectDetailService projectDetailService) {
        this.projectService = projectService;
        this.projectDetailService = projectDetailService;
    }

    @GetMapping("/projects")
    @ApiOperation("모든 프로젝트를 돌려준다")
    public List<ProjectDto> projects() {
        return projectService.getAllProjects();
    }


    @GetMapping("/projects/{projectName}")
    @ApiOperation(value = "일치하는 프로젝트를 찾아서 돌려준다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "해당 프로젝트 이름 없음")
    })
    @ResponseBody
    public ProjectDto project(@PathVariable(value = "projectName") String name) {
        return projectService.findProjectByProjectName(name);
    }

    @GetMapping("/projects/{projectName}/details")
    @ApiOperation(value = "일치하는 프로젝트의 모든 세부 인원 정보를 찾아서 돌려준다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "해당 프로젝트 없음")
    })
    public List<ProjectDetailViewResponseDto> details(@PathVariable(value = "projectName") String name) {
        return projectDetailService.getAllDetailsByProjName(name);
    }
}
