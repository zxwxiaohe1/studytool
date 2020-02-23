/**
 * Copyright &copy; 2015-2020 <a href="http://www.sinux.com.cn/">JFusion</a> All rights reserved.
 */
package com.study.en.support.holder;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候取出ApplicaitonContext.
 *
 * @author hryong
 * @date 2020-5-29 下午1:25:40
 */
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 * @return ApplicationContext对象
	 * @throws
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * @param name String类型
	 * @return ApplicationContext对象
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		Object obj = null;
		try {
			obj = applicationContext.getBean(name);
			if (obj == null) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return (T) obj;
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * @param requiredType Class<T>类型
	 * @return T 对象
	 * @throws
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		T obj = null;
		try {
			obj = applicationContext.getBean(requiredType);
			if (obj == null) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return obj;
	}

	/**
	 * 清除Holder
	 * @return void
	 * @throws
	 */
	public static void clearHolder() {
		if (logger.isDebugEnabled()){
			logger.debug("Clean SpringContextHolder ApplicationContext:" + applicationContext);
		}
		applicationContext = null;
	}

	/**
	 * 实现ApplicationContextAware接口, 注入Context到静态变量中.
	 * @param  applicationContext ApplicationContext类型
	 * @return void
	 * @throws
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;

		if(SpringContextHolder.applicationContext!=null){
			try {
				ConfigurableApplicationContext context = (ConfigurableApplicationContext)SpringContextHolder.applicationContext;
				if(context!=null){
					context.registerShutdownHook();
				}
			}catch (Throwable e){}

		}
	}

	/**
	 * 实现DisposableBean接口, 在Context关闭时清理静态变量.
	 * @return void
	 * @throws
	 */
	@Override
	public void destroy() throws Exception {
		SpringContextHolder.clearHolder();
	}

	/**
	 * 检查ApplicationContext不为空.
	 * @return void
	 * @throws
	 */
	private static void assertContextInjected() {
		Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
	}
}