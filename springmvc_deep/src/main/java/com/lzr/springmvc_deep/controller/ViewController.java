package com.lzr.springmvc_deep.controller;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lzr.springmvc_deep.bean.User;
import com.lzr.springmvc_deep.view.PdfExportService;
import com.lzr.springmvc_deep.view.PdfView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-05-31 21:43
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    /**
     * 导出pdf视图
     * @return
     */
    @RequestMapping("/pdf")
    public ModelAndView exportPdf(){
        ModelAndView mv = new ModelAndView();
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("userName_" + i);
            user.setNote("note_" + i);
            userList.add(user);
        }
        View view = new PdfView(exportService());
        mv.setView(view);
        mv.addObject("userList", userList);
        return mv;
    }

    /**
     * 自定义导出pdf
     * @return
     */
    private PdfExportService exportService(){
        return new PdfExportService() {
            @Override
            public void make(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) {
                try {
                    //A4纸大小
                    document.setPageSize(PageSize.A4);
                    //标题
                    document.addTitle("用户信息");
                    //换行
                    document.add(new Chunk("\n"));
                    //表格，3列
                    PdfPTable table = new PdfPTable(3);
                    //单元格
                    PdfPCell cell = null;
                    //字体，定义蓝色加粗
                    Font f8 = new Font();
                    f8.setColor(Color.BLUE);
                    f8.setStyle(Font.BOLD);
                    //标题
                    cell = new PdfPCell(new Paragraph("id", f8));
                    //居中
                    cell.setHorizontalAlignment(1);
                    //将单元格加入表格
                    table.addCell(cell);
                    //把另外的用户属性也加入，name，note
                    cell = new PdfPCell(new Paragraph("name", f8));
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph("note", f8));
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                    //获取数据模型中的用户列表
                    List<User> userList = (List<User>) model.get("userList");
                    for(User user : userList){
                        //在表格中添加数据
                        document.add(new Chunk("\n"));
                        cell = new  PdfPCell(new Paragraph(user.getId() + ""));
                        table.addCell(cell);
                        cell = new  PdfPCell(new Paragraph(user.getName()));
                        table.addCell(cell);
                        cell = new  PdfPCell(new Paragraph(user.getNote()));
                        table.addCell(cell);
                    }
                    //在文档中加入表格
                    document.add(table);
                }catch (DocumentException e){
                    e.printStackTrace();
                }
            }
        };
    }

}
