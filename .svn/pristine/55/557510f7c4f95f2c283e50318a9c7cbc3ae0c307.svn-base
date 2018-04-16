package com.hsl.clgl.sh.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShDeptDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShDeptEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.service.ShDeptService;
import com.hsl.clgl.sh.pc.admin.modules.sys.shiro.ShiroUtils;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import com.hsl.clgl.sh.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("shDeptService")
public class ShDeptServiceImpl extends ServiceImpl<ShDeptDao, ShDeptEntity> implements ShDeptService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String deptName=(String)params.get("deptname");
        String  shId=ShiroUtils.getShId();
        Page<ShDeptEntity> page = this.selectPage(
                new Query<ShDeptEntity>(params).getPage(),
                new EntityWrapper<ShDeptEntity>().eq(ColumnConstant.STATUS, Constant.STATUS_USED)
                        .like(StringUtils.isNotBlank(deptName),ColumnConstant.DEPT_NAME, deptName)
                        .eq(ColumnConstant.SH_ID,shId)
        );
        List<ShDeptEntity> deptList=new ArrayList<>();
        for(ShDeptEntity sysDeptEntity : page.getRecords()){
            ShDeptEntity parentDeptEntity =  this.selectById(sysDeptEntity.getParentId());
            if(parentDeptEntity != null){
                sysDeptEntity.setParentName(parentDeptEntity.getName());
            }
            deptList.add(sysDeptEntity);
        }
        page.setRecords(deptList);
        return new PageUtils(page);
    }

    public List<ShDeptEntity> getDeptAll(){
        //商户id
        String shId= ShiroUtils.getShId();
        List<ShDeptEntity> deptList =
                this.selectList(new EntityWrapper<ShDeptEntity>()
                        .eq(ColumnConstant.STATUS, Constant.STATUS_USED)
                        .eq(ColumnConstant.SH_ID,shId));

        List<ShDeptEntity > nodeList = new ArrayList();
        for(ShDeptEntity node1 : deptList){//taskDTOList 是数据库获取的List列表数据或者来自其他数据源的List
            boolean mark = false;
            for(ShDeptEntity node2 : deptList){
                if(node1.getParentId()!=null && node1.getParentId().equals(node2.getDeptId())){
                    mark = true;
                    if(node2.getChildren() == null)
                        node2.setChildren(new ArrayList<ShDeptEntity>());
                    node2.getChildren().add(node1);
                    break;
                }
            }
            if(!mark){
                nodeList.add(node1);
            }
        }
        return nodeList;
    }


    @Override
    public List<String> queryDetpIdList(String parentId) {
        return baseMapper.queryDetpIdList(parentId);
    }
}
