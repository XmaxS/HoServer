package com.horizon.server.upload.service.impl;

import com.horizon.server.common.enums.ExceptionEnums;
import com.horizon.server.common.exception.HoException;
import com.horizon.server.upload.config.UploadProperties;
import com.horizon.server.upload.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadProperties properties;

    @Override
    public String uploadImage(MultipartFile file) {
        //对文件进行校验
        //对文件格式进行校验
        String contentType = file.getContentType();
        if (!properties.getAllowTypes().contains(contentType)) {
            throw new HoException(ExceptionEnums.INVALID_FILE_FORMAT);
        }

        //检验文件内容
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                log.info("【文件上传】上传文件格式错误");
                throw new HoException(ExceptionEnums.INVALID_FILE_FORMAT);
            }
        } catch (IOException e) {
            log.info("【文件上传】文件上传失败", e);
            throw new HoException(ExceptionEnums.INVALID_FILE_FORMAT);
        }

        //保存图片
        //1. 接受上传的文件  @RequestParam("file") MultipartFile file
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = "E:/JetBrains/IdeaProjects/HoServer/ho-upload/src/main/resources/upload" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把上传的文件复制到希望的位置
            file.transferTo(destFile);

            return properties.getBaseUrl() + destFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
    }

}
