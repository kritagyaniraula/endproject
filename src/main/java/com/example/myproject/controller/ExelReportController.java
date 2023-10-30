package com.example.myproject.controller;

import com.example.myproject.service.ExelService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExelReportController {
@Autowired
    private ExelService exelService;

@GetMapping("/exel")

public void generteExelReport(HttpServletResponse response) throws IOException {

    response.setContentType("application/octet-stream");
    String headerkey = "Content-Disposition";
    String headerValue = "attachment;filename=courses.xls";

    response.setHeader(headerkey,headerValue);

    exelService.generateExel(response);
    response.flushBuffer();

}
}
