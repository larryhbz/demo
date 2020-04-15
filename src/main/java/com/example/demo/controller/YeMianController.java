package com.example.demo.controller;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping("/yemian/")
public class YeMianController {
    @RequestMapping("index")
    public String index(Map<String,String> map){
        return "yemian/index";
    }

    //手动自己设计excel文档方式下载
    @RequestMapping("download")
        public void downloadExcel(HttpServletResponse response) {
        // 创建工作空间
        XSSFWorkbook  wb = new XSSFWorkbook();
        // 创建工作表
        XSSFSheet sheet = wb.createSheet("员工成绩");
        // 创建标题行（第一行）
        XSSFRow row = sheet.createRow(0);
        XSSFCell cellB2 = row.createCell(0); // 在A1位置创建一个单元格
        cellB2.setCellValue("项目需求方案专家评分汇总"); // A1单元格填充内容


        XSSFRow row2 = sheet.createRow(2); // 创建一行,参数2表示第一行
        XSSFCell cellB3 = row2.createCell(0); // 在B3位置创建一个单元格
        cellB3.setCellValue("项目需求方案专家组评分评审意见表"); // B3单元格填充内容

        XSSFRow row4 = sheet.createRow(4);//第四行
        XSSFCell cellB4 = row4.createCell(0);
        cellB4.setCellValue("项目申报单位");
        XSSFCell cellB5 = row4.createCell(2);
        cellB5.setCellValue("上城区党政办");
        XSSFCell cellB6 = row4.createCell(4);
        cellB6.setCellValue("项目编号");
        XSSFCell cellB7 = row4.createCell(5);
        cellB7.setCellValue("JH-00-9527-35");

        XSSFRow row5 = sheet.createRow(5);//第五行
        XSSFCell cellC4 = row5.createCell(0);
        cellC4.setCellValue("评审人");
        XSSFCell cellC5 = row5.createCell(2);
        cellC5.setCellValue("高级专家");
        XSSFCell cellC6 = row5.createCell(4);
        cellC6.setCellValue("评审时间");
        XSSFCell cellC7 = row5.createCell(5);
        cellC7.setCellValue("2019年12月10日15:30:12");


        XSSFCellStyle cellStyle = wb.createCellStyle(); // 单元格样式
        Font fontStyle = wb.createFont(); // 字体样式
        fontStyle.setBold(true); // 加粗
        fontStyle.setFontName("黑体"); // 字体
        fontStyle.setFontHeightInPoints((short) 11); // 大小
        // 将字体样式添加到单元格样式中
        cellStyle.setFont(fontStyle);
        // 边框，居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellB2.setCellStyle(cellStyle); // 为B2单元格添加样式
        cellB3.setCellStyle(cellStyle);
        // 合并单元格
        CellRangeAddress cra =new CellRangeAddress(0, 1, 0, 6);
        CellRangeAddress cra2 =new CellRangeAddress(2, 3, 0, 6); // 起始行, 终止行, 起始列, 终止列
        CellRangeAddress cra3 =new CellRangeAddress(4, 4, 0, 1);
        CellRangeAddress cra4 =new CellRangeAddress(4, 4, 2, 3);
        CellRangeAddress cra5 =new CellRangeAddress(4, 4, 5, 6);
        CellRangeAddress cra6 =new CellRangeAddress(5, 5, 0, 1);
        CellRangeAddress cra7 =new CellRangeAddress(5, 5, 2, 3);
        CellRangeAddress cra8 =new CellRangeAddress(5, 5, 5, 6);
        sheet.addMergedRegion(cra);
        sheet.addMergedRegion(cra2);
        sheet.addMergedRegion(cra3);
        sheet.addMergedRegion(cra4);
        sheet.addMergedRegion(cra5);
        sheet.addMergedRegion(cra6);
        sheet.addMergedRegion(cra7);
        sheet.addMergedRegion(cra8);
        // 使用RegionUtil类为合并后的单元格添加边框
        RegionUtil.setBorderBottom(1, cra, sheet); // 下边框
        RegionUtil.setBorderLeft(1, cra, sheet); // 左边框
        RegionUtil.setBorderRight(1, cra, sheet); // 有边框
        RegionUtil.setBorderTop(1, cra, sheet); // 上边框



        // 设置生成的Excel的文件名，并以中文进行编码
        response.setHeader("Content-Disposition", "attachment;filename=test表.xlsx");
        // 响应类型,编码
        response.setContentType("application/octet-stream;charset=UTF-8");
        // 形成输出流
        OutputStream osOut = null;
        try {
            osOut = response.getOutputStream();
            // 将指定的字节写入此输出流
            wb.write(osOut);
            // 刷新此输出流并强制将所有缓冲的输出字节被写出
            osOut.flush();
            // 关闭流
            osOut.close();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("modeldownload")
    public void modeldownloadExcel(HttpServletResponse response){

        try {
            //excel模板路径
            File cfgFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/model/1.xlsx");
            InputStream in = new FileInputStream(cfgFile);
            //读取excel模板
            XSSFWorkbook wb = null;
            wb = new XSSFWorkbook(in);
            XSSFSheet sheet = null;
            try{
                sheet = wb.getSheetAt(0);
                //先将获取的单元格设置为String类型，下面使用getStringCellValue获取单元格内容
                //如果不设置为String类型，如果单元格是数字，则报如下异常
                //java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell
                sheet.getRow(2).getCell(2).setCellType(CellType.STRING);
                //读取单元格内容
                String cellValue = sheet.getRow(2).getCell(2).getStringCellValue();

                //添加数据
                XSSFRow row =sheet.getRow(4);
                row.createCell(2).setCellValue("这是单位");
                row.createCell(6).setCellValue("这是项目");
                //添加数据
                XSSFRow row1 =sheet.getRow(6);
                row1.createCell(2).setCellValue("larry");
                row1.createCell(6).setCellValue("2019年12月11日17:07:59");

                // 设置生成的Excel的文件名，并以中文进行编码
                response.setHeader("Content-Disposition", "attachment;filename=test表.xlsx");
                // 响应类型,编码
                response.setContentType("application/octet-stream;charset=UTF-8");
                // 形成输出流
                OutputStream osOut = null;
                try {
                    osOut = response.getOutputStream();
                    // 将指定的字节写入此输出流
                    wb.write(osOut);
                    // 刷新此输出流并强制将所有缓冲的输出字节被写出
                    osOut.flush();
                    // 关闭流
                    osOut.close();
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("doc")
    public void docDownloadExcel(HttpServletResponse response) throws IOException{
        //excel模板路径
        File cfgFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/model/1.xlsx");
        InputStream in = new FileInputStream(cfgFile);

    }
}
