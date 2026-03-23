package com.example.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public static List<Map<String, String>> getData(String path, String sheetName) {

        List<Map<String, String>> data = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(path)) {

            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row currentRow = sheet.getRow(i);
                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {

                    String key = headerRow.getCell(j).toString();
                    String value = currentRow.getCell(j).toString();

                    rowData.put(key, value);
                }

                data.add(rowData);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error leyendo Excel", e);
        }

        return data;
    }
}