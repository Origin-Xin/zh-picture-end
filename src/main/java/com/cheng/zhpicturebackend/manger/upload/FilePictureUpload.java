package com.cheng.zhpicturebackend.manger.upload;

import cn.hutool.core.io.FileUtil;
import com.cheng.zhpicturebackend.exception.ErrorCode;
import com.cheng.zhpicturebackend.exception.ThrowUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class FilePictureUpload extends PictureUploadTemplate{

    @Override
    protected void validPicture(Object inputSource) {
        MultipartFile multipartFile = (MultipartFile) inputSource;
        ThrowUtils.throwIf(multipartFile==null, ErrorCode.PARAMS_ERROR,"文件不能为空");
        //校验图片大小
        long fileSize = multipartFile.getSize();
        final long ONE_M  = 1024 * 1024L;
        ThrowUtils.throwIf(fileSize>ONE_M*2,ErrorCode.PARAMS_ERROR,"文件大小不能超过 2M");
        //获取图片后缀
        String fileSuffix  = FileUtil.getSuffix(multipartFile.getOriginalFilename());
        //校验图片格式
        final List<String> ALLOW_FORMAT_LIST= Arrays.asList("jpeg", "jpg", "png", "webp");
        ThrowUtils.throwIf(!ALLOW_FORMAT_LIST.contains(fileSuffix),ErrorCode.PARAMS_ERROR,"文件类型错误");
    }

    @Override
    protected String getOriginFilename(Object inputSource) {
        MultipartFile multipartFile = (MultipartFile) inputSource;
        String originFilename = multipartFile.getOriginalFilename();
        return originFilename;
    }

    @Override
    protected void processFile(Object inputSource, File file) throws Exception {
        MultipartFile multipartFile = (MultipartFile) inputSource;
        multipartFile.transferTo(file);
    }
}
