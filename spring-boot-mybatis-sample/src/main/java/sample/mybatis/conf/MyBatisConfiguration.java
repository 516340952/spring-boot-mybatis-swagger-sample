package sample.mybatis.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 获取第二个数据库的连接信息，在application.properties中配置，并指定特定的前缀
 *
 * @author 小翼
 * @version 1.0.0
 */
@Configuration
public class MyBatisConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisConfiguration.class);

	@Autowired
	CustomDataSourceProperties properties;
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	SqlSessionTemplate sessionTemplate;
    @Autowired
    private UserMapper userMapper;
    
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	    
    @Bean  
    public UserMapper userMapper() {    
    	return sessionTemplate.getMapper(UserMapper.class); 
    }
    
	@Bean
	public SqlSessionFactory sqlSessionFactory(){
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		DataSourceBuilder builder = DataSourceBuilder
				.create(this.properties.getClassLoader())
				.driverClassName(this.properties.getDriverClassName())
				.url(this.properties.getUrl())
				.username(this.properties.getUsername())
				.password(this.properties.getPassword());
		bean.setDataSource(builder.build());
		ClassPathResource classPathResource = new ClassPathResource("UserMapper.xml");
		Resource[] resources = {classPathResource};
		bean.setMapperLocations(resources);
		SqlSessionFactory factory = null;
         try {
			 factory = bean.getObject();
         }catch (Exception e) {  
                logger.error(e.getMessage(),e);
         }
         return factory;
	}
}
