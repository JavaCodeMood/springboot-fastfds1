package com.lhf.springbootfastfds1.controller;

import com.lhf.springbootfastfds1.utils.CommonFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: FileController
 * @Desc:
 * @Author: liuhefei
 * @Date: 2018/12/24 20:11
 */
@Controller
public class FileController {

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private CommonFileUtil fileUtil;

    @RequestMapping("/index")
    public String goIndex(){
        logger.info("进入主页面");
        return "/file";
    }

    /**
     * 上传文件到本地
     * @param file
     * @return
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("fileName") MultipartFile file){
        System.out.println("file = " + file);
        String targetFilePath = "E:/";

        if(file.isEmpty()){
            logger.info("this file is empty");
        }

        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        //获取原来文件名称
        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        if(fileSuffix.equals(".jpg") || fileSuffix.equals(".png")){
            logger.info("文件格式正确");
        }else{
            logger.info("文件格式不正确");
        }
        //拼装新的文件名
        String targetFileName = targetFilePath + newFileName + fileSuffix;
        System.out.println("targetFileName = " + targetFileName);
        //上传文件
        try {
            FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(targetFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/success";
    }

    /**
     * 使用fastdfs进行文件上传
     * 上传到远程服务器
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadFileToFast")
    public String uoloadFileToFast(@RequestParam("fileName")MultipartFile file) throws IOException {
        System.out.println("file = "  + file);
        if(file.isEmpty()){
            logger.info("文件不存在");
        }
        String path = fileUtil.uploadFile(file);
        System.out.println(path);
        return "success";
    }

}
