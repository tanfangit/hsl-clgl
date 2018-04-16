package com.hsl.clgl.app.cz.modules.sys.service.impl;

import com.hsl.clgl.app.cz.modules.sys.dao.CzTokenDao;
import com.hsl.clgl.app.cz.modules.sys.entity.CzTokenEntity;
import com.hsl.clgl.app.cz.modules.sys.service.CzTokenService;
import com.hsl.clgl.app.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.PageUtils;



@Service("czTokenService")
public class CzTokenServiceImpl extends ServiceImpl<CzTokenDao, CzTokenEntity> implements CzTokenService {

    /**
     * 12小时后过期
     */
    private final static int EXPIRE = 3600 * 12;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CzTokenEntity> page = this.selectPage(
                new Query<CzTokenEntity>(params).getPage(),
                new EntityWrapper<CzTokenEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public CzTokenEntity queryByToken(String token) {
        return this.selectOne(new EntityWrapper<CzTokenEntity>().eq("token", token));
    }

    @Override
    public CzTokenEntity createToken(String userId) {
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //生成token
        String token = generateToken();

        //保存或更新用户token
        CzTokenEntity tokenEntity = new CzTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        tokenEntity.setUpdateTime(now);
        tokenEntity.setExpireTime(expireTime);
        this.insertOrUpdate(tokenEntity);

        return tokenEntity;
    }

    @Override
    public void expireToken(String userId) {
        Date now = new Date();
        CzTokenEntity tokenEntity = new CzTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setUpdateTime(now);
        tokenEntity.setExpireTime(now);
        this.insertOrUpdate(tokenEntity);
    }

    private String generateToken(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
