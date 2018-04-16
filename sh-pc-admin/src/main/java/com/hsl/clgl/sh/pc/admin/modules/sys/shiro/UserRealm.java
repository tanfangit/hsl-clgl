package com.hsl.clgl.sh.pc.admin.modules.sys.shiro;


import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShMenuDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShRoleDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.dao.ShUserDao;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShMenuEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShRoleEntity;
import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserEntity;
import com.hsl.clgl.sh.pc.admin.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 认证
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.com
 */
@SuppressWarnings("all")
@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private ShUserDao shUserDao;
    @Autowired
    private ShMenuDao shMenuDao;

	@Autowired
	private ShRoleDao shRoleDao;
    
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShUserEntity user = (ShUserEntity)principals.getPrimaryPrincipal();
		String userId = user.getUserId();
		//根据用户id查询用户角色
		List<ShRoleEntity> userRoles = this.shRoleDao.queryUserRoleListByUserId(userId);
		boolean isAdmin = false;
		List<String> permsList;

		for (ShRoleEntity role : userRoles) {
			//判断用户是否是超级管理员
			if (Constant.SUPER_ADMIN.equalsIgnoreCase(role.getRoleName())){
				isAdmin = true;
				break;
			}
		}
		
		//系统管理员，拥有最高权限
		if(isAdmin){
			List<ShMenuEntity> menuList = this.shMenuDao.selectList(null);
			permsList = new ArrayList<>(menuList.size());
			for(ShMenuEntity menu : menuList){
				permsList.add(menu.getPerms());
			}
		}else{ //否则根据用户id获取用户权限
			permsList = shUserDao.queryAllPerms(userId);
		}

		//用户权限列表
		Set<String> permsSet = new HashSet<>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;

        //查询用户信息
		ShUserEntity user = new ShUserEntity();
		//user.setUsername(token.getUsername());
		//user = sysUserDao.selectOne(user);
		//修改：2018-3-22  自带查询用户信息方法没有加状态筛选
		user = this.shUserDao.selectUserByUsername(token.getUsername());
        
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return info;
	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
