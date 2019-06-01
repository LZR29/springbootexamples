package com.lzr.springmvc_deep.view;




import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 只要控制器实现这个接口就能自定义的导出PDF视图的逻辑
 */
public interface PdfExportService {
    public void make(Map<String, Object> model, Document document,
                     PdfWriter writer, HttpServletRequest request, HttpServletResponse response);
}
