package com.MongoDb.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MongoDb.Entity.UserBean;
import com.MongoDb.Service.UserService;

@RestController
public class UserControler {
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserBean> insert(@RequestBody UserBean bean) {
		System.out.println(bean);
		return new ResponseEntity<UserBean>(userService.insert(bean), HttpStatus.OK);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<UserBean> update(@PathVariable("id") int id, @RequestBody UserBean bean) {
		return new ResponseEntity<UserBean>(userService.update(id, bean), HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<UserBean> delete(@PathVariable("id") int id) {
		userService.delete(id);
		return new ResponseEntity<UserBean>(HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserBean> show(@PathVariable("id") int id) {
		return new ResponseEntity<UserBean>(userService.show(id), HttpStatus.OK);

	}

	@GetMapping("/user")
	public ResponseEntity<List<UserBean>> showAll() {
		return new ResponseEntity<List<UserBean>>(userService.showAll(), HttpStatus.OK);

	}
}
