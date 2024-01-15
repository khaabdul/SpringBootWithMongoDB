package com.MongoDb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.MongoDb.Entity.UserBean;
import com.MongoDb.Exception.UserNotFoundException;
import com.MongoDb.Repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public UserBean insert(UserBean bean) {
		Optional<UserBean> findByNumber = userRepo.findByNumber(bean.getNumber());
		if (findByNumber.isPresent()) {
			throw new DuplicateKeyException("Number Already Exist");
		}
		return userRepo.save(bean);
	}

	public UserBean show(int id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Id Not Present"));
	}

	public List<UserBean> showAll() {
		return userRepo.findAll();

	}

	public UserBean update(int id, UserBean bean) {
		UserBean user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Id Not Present"));
		bean.setUserId(id);
		if (bean.getName() == null) {
			bean.setName(user.getName());
		}
		if (bean.getAddress() == null) {
			bean.setAddress(user.getAddress());
		}
		if (bean.getNumber() == 0) {
			bean.setNumber(user.getNumber());
		}
		return userRepo.save(bean);

	}

	public void delete(int id) {
		userRepo.delete(userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Id Not Present")));
	}
}
