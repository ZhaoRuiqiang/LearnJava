/**
 * 
 */
package org.qqiang.test.config;

import org.qqiang.test.parser.JsonParser;
import org.qqiang.test.parser.ParserFactory;
import org.qqiang.test.parser.XMLParser;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author QQiang
 *
 */
@Configuration
public class AppConfig {
	@Bean
	public FactoryBean serviceLocatorFactoryBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(ParserFactory.class);
		return factoryBean;
	}

	@Bean(name = "jsonParser")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JsonParser jsonParser() {
		return new JsonParser();
	}

	@Bean(name = "xmlParser")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public XMLParser xmlParser() {
		return new XMLParser();
	}
}
