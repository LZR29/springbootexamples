package com.lzr.springmvc_deep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-05-31 23:09
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    /**
     * 处理返回结果
     * @param msg
     * @param success
     * @return
     */
    private Map<String, Object> deal(String msg, boolean success){
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("msg", msg);
        return map;
    }

    /**
     * 推荐使用文件上传的方法
     * 因为这是基于servlet的api
     * @param file
     * @return
     */
    @PostMapping("/part")
    @ResponseBody
    public Map<String, Object> uploadPart(Part file){
        //获取名称,这里获取的名称是有后缀的
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return deal("上传失败", false);
        }
        return deal("上传成功", true);
    }

    /**
     *DispatcherServlet会将HttpServletRequest转换为MultipartHttpServletRequest对象
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/request")
    public Map<String, Object> uploadRequest(HttpServletRequest request){
        boolean flag = false;
        MultipartHttpServletRequest mreq = null;
        if(request instanceof MultipartHttpServletRequest){
            mreq = (MultipartHttpServletRequest) request;
        }else {
            return deal("上传失败", false);
        }
        //获取文件信息
        MultipartFile mf = mreq.getFile("file");
        //获取名称
        String fileName = mf.getOriginalFilename();
        File file = new File(fileName);
        try {
            //保存文件
            mf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return deal("上传失败", false);
        }
        return deal("上传成功", true);
    }

    /**
     *直接使用MultipartFile，spring mvc的类
     * @param file
     * @return
     */
    @ResponseBody
    @PostMapping("/multipartFile")
    public Map<String, Object> uploadMultipartFile(MultipartFile file){
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return deal("上传失败", false);
        }
        return deal("上传成功", true);
    }
}
