package com.hsl.clgl.pc.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hsl.clgl.common.utils.ColumnConstant;
import com.hsl.clgl.common.utils.PageUtils;
import com.hsl.clgl.pc.admin.modules.sys.dao.SysDeptDao;
import com.hsl.clgl.pc.admin.modules.sys.entity.SysDeptEntity;
import com.hsl.clgl.pc.admin.modules.sys.service.SysDeptService;
import com.hsl.clgl.pc.admin.utils.Constant;
import com.hsl.clgl.pc.admin.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements SysDeptService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String deptName=(String)params.get("deptname");
        Page<SysDeptEntity> page = this.selectPage(
                new Query<SysDeptEntity>(params).getPage(),
                new EntityWrapper<SysDeptEntity>().eq(ColumnConstant.STATUS, Constant.STATUS_USED)
                        .like(StringUtils.isNotBlank(deptName),ColumnConstant.DEPT_NAME, deptName)
        );
        List<SysDeptEntity> deptList=new ArrayList<>();
        for(SysDeptEntity sysDeptEntity : page.getRecords()){
            SysDeptEntity parentDeptEntity =  this.selectById(sysDeptEntity.getParentId());
            if(parentDeptEntity != null){
                sysDeptEntity.setParentName(parentDeptEntity.getName());
            }
            deptList.add(sysDeptEntity);
        }
          page.setRecords(deptList);
        return new PageUtils(page);
    }


    public List<SysDeptEntity> getDeptAll(){
        List<SysDeptEntity> deptList =
                this.selectList(new EntityWrapper<SysDeptEntity>());
       // List<SysDeptTreeEntity > nodeList = new ArrayList();
        List<SysDeptEntity > nodeList = new ArrayList();
        for(SysDeptEntity node1 : deptList){//taskDTOList 是数据库获取的List列表数据或者来自其他数据源的List
            boolean mark = false;
            for(SysDeptEntity node2 : deptList){
                if(node1.getParentId()!=null && node1.getParentId().equals(node2.getDeptId())){
                    mark = true;
                    if(node2.getChildren() == null)
                        node2.setChildren(new ArrayList<SysDeptEntity>());
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
