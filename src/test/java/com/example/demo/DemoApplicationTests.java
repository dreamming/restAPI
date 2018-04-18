package com.example.demo;

import com.example.demo.dao.IUser;
import com.example.demo.domain.UserDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private IUser user;

	@Test
	public void testSaveUser() {
		UserDocument userDocument = new UserDocument();
		userDocument.setUserId(2);
		userDocument.setContent("Hello,Mark");
		userDocument.setSsid("54321");
		user.saveUser(userDocument);
	}

	@Test
	public void testGetUsers() {
		List<UserDocument> users = user.getUserByAny("content", "Hello,Mark");
		Assert.notNull(users,"Users Is Null");
	}


}
