package com.cheng.zhpicturebackend.aop;

import com.cheng.zhpicturebackend.annotation.AuthCheck;
import com.cheng.zhpicturebackend.exception.BusinessException;
import com.cheng.zhpicturebackend.exception.ErrorCode;
import com.cheng.zhpicturebackend.model.entity.User;
import com.cheng.zhpicturebackend.model.enums.UserRoleEnum;
import com.cheng.zhpicturebackend.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthInterceptor {

    @Resource
    private UserService userService;

    /**
     * 执行拦截
     *
     * @param joinPoint 切入点
     * @param authCheck 权限校验注解
     */
    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        //获取执行方法前必须拥有的权限
        String mustRole = authCheck.mustRole();
        //获取request
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        //获取登录用户
        User loginUser = userService.getLoginUser(request);
        UserRoleEnum mustRoleEnum  = UserRoleEnum.getEnumByValue(mustRole);
        //不需要权限
        if (mustRoleEnum==null){
            //放行
            return joinPoint.proceed();
        }
        //以下为：必须有权限才能放行
        //获取登录用户的权限
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());
        //无权限，拒绝
        if (userRoleEnum==null){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        //要求必须有管理员权限，但用户没有管理员权限，拒绝
        if (UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(userRoleEnum)){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        return joinPoint.proceed();
    }
}

