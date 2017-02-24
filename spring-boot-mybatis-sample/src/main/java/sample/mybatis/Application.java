package sample.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 程序的入口
 *
 * @author 小翼
 * @version 1.0.0
 */
@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("这是一个MyBatis和Spring-Boot整合的Demo,通过JPA连接默认数据库，通过Mybatis连接自定义增加的数据库");
	}
}