package com.project.db.mju.webserver.web.v2.dto;

import com.project.db.mju.webserver.web.v1.domain.Employee;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name; // 이름
    private String userId; // 아이디
    private String education; // 학력
    private Long departmentType; // 부서 타입
    private Long career; // 커리어 레벨

    public static EmployeeDto of(Employee e) {
        return EmployeeDto.builder()
                .name(e.getName())
                .userId(e.getUserId())
                .education(e.getEducation())
                .departmentType(e.getDepartmentType())
                .career(e.getCareer())
                .build();
    }
}
