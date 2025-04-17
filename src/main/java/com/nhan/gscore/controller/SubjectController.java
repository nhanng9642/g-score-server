package com.nhan.gscore.controller;

import com.nhan.gscore.domain.Subject;
import com.nhan.gscore.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public BaseResponse<?> getScore() {
        return BaseResponse.of(Subject.getAllSubject());
    }
}
