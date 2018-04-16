
package com.hsl.clgl.sh.pc.admin.modules.sys.controller;

import com.hsl.clgl.sh.pc.admin.modules.sys.entity.ShUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 * @author zhoucheng
 * @email zhoucheng@hsl56.com
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected ShUserEntity getUser() {
		return (ShUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected String getUserId() {
		return getUser().getUserId();
	}

	protected String getShId() {
		return getUser().getShId();
	}

}
