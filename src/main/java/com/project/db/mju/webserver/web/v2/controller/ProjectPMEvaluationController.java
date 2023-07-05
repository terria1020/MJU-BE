package com.project.db.mju.webserver.web.v2.controller;

import com.project.db.mju.webserver.web.v1.dto.ProjectPMEvaluationDto;
import com.project.db.mju.webserver.web.v2.service.PMEvaluationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v2")
@RestController(value = "v2ProjectPMEvaluationController")
public class ProjectPMEvaluationController {
    @Autowired
    PMEvaluationService pmEvaluationService;

    @PostMapping("/evaluations/pm")
    @ApiOperation(value = "pm 평가를 등록한다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "업로드 실패")
    })
    @ResponseBody
    public int evaluation(@RequestBody ProjectPMEvaluationDto requestDto) {
        return pmEvaluationService.putProjectPMEvaluation(requestDto);
    }

    @PutMapping("/evaluations/pm")
    @ApiOperation(value = "존재하는 pm 평가에 대해 값을 업데이트한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "404", description = "업로드 실패")
    })
    @ResponseBody
    public int updateEvaluation(@RequestBody ProjectPMEvaluationDto requestDto) {
        return pmEvaluationService.updateProjectPMEvalutaion(requestDto);
    }
}
