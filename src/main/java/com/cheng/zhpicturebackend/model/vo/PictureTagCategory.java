package com.cheng.zhpicturebackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PictureTagCategory implements Serializable {
    List<String> TagList;

    List<String> CategoryList;
}
