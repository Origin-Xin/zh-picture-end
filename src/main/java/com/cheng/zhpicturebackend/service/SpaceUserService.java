package com.cheng.zhpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cheng.zhpicturebackend.model.dto.spaceuser.SpaceUserAddRequest;
import com.cheng.zhpicturebackend.model.dto.spaceuser.SpaceUserQueryRequest;
import com.cheng.zhpicturebackend.model.entity.SpaceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.zhpicturebackend.model.entity.User;
import com.cheng.zhpicturebackend.model.vo.SpaceUserVO;
import com.cheng.zhpicturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 6992
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2025-05-12 17:10:53
*/
public interface SpaceUserService extends IService<SpaceUser> {
    /**
     * 空间成员数据校验
     * @param spaceUser
     * @param add 是否为创建时校验
     */
    void validSpaceUser(SpaceUser spaceUser, Boolean add);

    /**
     *  获取空间成员单条
     * @param spaceUser
     * @return
     */
    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser);


    /**
     * 获取空间成员(多条)
     * @param spaceUserList
     * @return
     */
    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);

    /**
     * 获取查询条件
     * @param spaceUserQueryRequest
     * @return
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);


    /**
     * 增加空间成员
     * @param spaceUserAddRequest
     * @return
     */
    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);
}
