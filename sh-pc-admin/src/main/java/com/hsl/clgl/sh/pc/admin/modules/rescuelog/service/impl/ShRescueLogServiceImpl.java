package com.hsl.clgl.sh.pc.admin.modules.rescuelog.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.sh.pc.admin.modules.rescuelog.dao.ShRescueLogDao;
import com.hsl.clgl.sh.pc.admin.modules.rescuelog.entity.ShRescueLogEntity;
import com.hsl.clgl.sh.pc.admin.modules.rescuelog.service.ShRescueLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("shRescueLogService")
public class ShRescueLogServiceImpl extends ServiceImpl<ShRescueLogDao, ShRescueLogEntity> implements ShRescueLogService {
    @Autowired
    private ShRescueLogDao shRescueLogDao;
    @Override
    public List<ShRescueLogEntity> queryLogListById(String params) {
        List<ShRescueLogEntity>  list= shRescueLogDao.queryLogListById(params);
        return list;
    }

    /**
     * 新增日志
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShRescueLogEntity shRescueLogEntity){
        this.insert(shRescueLogEntity);
    }
}
