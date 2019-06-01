package com.lzr.springmvc_deep.view;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-05-31 21:37
 */
public class PdfView extends AbstractPdfView {
    //服务接口
    private PdfExportService pdfExportService = null;

    /**
     * 创建对象时载入这个接口
     * @param pdfExportService
     */
    public PdfView(PdfExportService pdfExportService){
        this.pdfExportService = pdfExportService;
    }

    /**
     * 调用接口实现
     * @param map
     * @param document
     * @param pdfWriter
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //调用接口
        pdfExportService.make(map, document, pdfWriter, httpServletRequest, httpServletResponse);
    }
}
