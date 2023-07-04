package com.project.db.mju.webserver.web.v2.controller;

import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewDto;
import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationViewRequestDto;
import com.project.db.mju.webserver.web.v2.service.ProjectPMEvalutaionViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v2")
@RestController(value = "v2ProjectPMEvaluationViewController")
public class ProjectPMEvalutaionViewController {

    @Autowired
    ProjectPMEvalutaionViewService service;

    @PostMapping("/view/evalutaion")
    public List<ProjectPMEvaluationViewDto> viewEvaluation(@RequestBody ProjectPMEvaluationViewRequestDto requestDto) {

        List<ProjectPMEvaluationViewDto> allEvals = service.getAllEvals(requestDto);

        return allEvals;
    }
}
