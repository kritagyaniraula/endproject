package com.example.myproject.service;

import com.example.myproject.model.ExelModel;
import com.example.myproject.repository.ExelRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExelService {
    @Autowired
    private ExelRepository exelRepository;

    public void generateExel(HttpServletResponse response) throws IOException {
        List<ExelModel> models = exelRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
      HSSFSheet sheet =  workbook.createSheet("exel database");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Roll");
        row.createCell(3).setCellValue("Address");

        int dataRowIndex = 1;
        for (ExelModel exelModel : models){
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(exelModel.getID());
            dataRow.createCell(1).setCellValue(exelModel.getName());
            dataRow.createCell(2).setCellValue(exelModel.getRoll());
            dataRow.createCell(3).setCellValue(exelModel.getAddress());
            dataRowIndex ++;
        }

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
