package com.cheng.zhpicturebackend.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheng.zhpicturebackend.model.dto.picture.PictureQueryRequest;
import com.cheng.zhpicturebackend.model.dto.space.SpaceAddRequest;
import com.cheng.zhpicturebackend.model.dto.space.SpaceQueryRequest;
import com.cheng.zhpicturebackend.model.entity.Picture;
import com.cheng.zhpicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.zhpicturebackend.model.entity.User;
import com.cheng.zhpicturebackend.model.vo.PictureVO;
import com.cheng.zhpicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 6992
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-04-20 22:56:58
*/
public interface SpaceService extends IService<Space> {
    /**
     * 空间数据校验
     * @param space
     * @param add 是否为创建时校验
     */
    void validSpace(Space space,Boolean add);

    /**
     *  获取空间(单条)
     * @param spaceVO
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space spaceVO, HttpServletRequest request);


    /**
     * 获取空间(多条)
     * @param SpacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> SpacePage, HttpServletRequest request);

    /**
     * 获取查询条件
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 自动填充限额
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 增加空间
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 空间权限校验
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}
