package sample.mybatis.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sample.mybatis.domain.User;
import sample.mybatis.service.UserService;
import sample.mybatis.service.UserServiceImpl;

@Component
public class TaskJob {


	@Autowired
	UserService userService;
	

	/**
	 * Job
	 */
	/*@Scheduled(cron="0/2 * *  * * ? ")*/
	//@Scheduled(fixedDelay = 2000)
	public void queryUser() {
		User user = userService.selectUser("zhangshuang");
		System.out.printf("User info:"+user.getUsername()+"="+user.getPassword());
		System.out.println("1111111");
	}


}
