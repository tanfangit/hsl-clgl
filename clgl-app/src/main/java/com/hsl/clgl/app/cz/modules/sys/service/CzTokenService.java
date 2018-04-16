package com.hsl.clgl.app.cz.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.hsl.clgl.app.cz.modules.sys.entity.CzTokenEntity;
import com.hsl.clgl.common.utils.PageUtils;

import java.util.Map;

/**
 * 用户Token
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.cn
 * @date 2018-03-29 11:43:28
 */
public interface CzTokenService extends IService<CzTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CzTokenEntity queryByToken(String token);

    /**
     * 生成token
     * @param userId  用户ID
     * @return        返回token信息
     */
    CzTokenEntity createToken(String userId);

    /**
     * 设置token过期
     * @param userId 用户ID
     */
    void expireToken(String userId);
}

