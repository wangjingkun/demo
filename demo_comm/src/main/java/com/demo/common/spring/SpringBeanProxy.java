package com.demo.common.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

public class SpringBeanProxy {

	private static ApplicationContext applicationContext;

	private static Log log = LogFactory.getLog(SpringBeanProxy.class);

	public synchronized static void setApplicationContext(ApplicationContext arg0) {
		log.info("=======================SpringBeanProxy void");
		applicationContext = arg0;
	}

	/**
	 * 获取bean的方法
	 * 
	 * @param <T>
	 * @param clazz
	 * @param beanName
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz, String beanName) {
		return applicationContext.getBean(beanName, clazz);
	}

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	/**
	 * 动态添加BEAN
	 * 
	 * @param beanName
	 * @param beanClass
	 */
	public static Object addBeanService(String beanName, Class<?> beanClass) {
		if (StringUtils.isEmpty(beanName) || beanClass == null) {
			return null;
		}
		if (!applicationContext.containsBean(beanName)) {
			Class<?> serviceClass = beanClass;
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
					.genericBeanDefinition(serviceClass);
			// 依赖注入getter setter
			// beanDefinitionBuilder.addPropertyValue("servicename", beanName);
			registerBean(beanName, beanDefinitionBuilder.getRawBeanDefinition());
		}
		return SpringBeanProxy.getBean(beanName);
	}

	/**
	 * 向spring容器注册bean
	 * 
	 * @param beanName
	 * @param beanDefinition
	 */
	private static void registerBean(String beanName, BeanDefinition beanDefinition) {
		ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
		BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext
				.getBeanFactory();
		beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinition);
	}
}