package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=iUserDao.findByUsername(username);

        //处理自己的用户对象封装成UserDetails
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,true,true,
                true,getAuthorities(userInfo.getRoles()));
        return user;
    }

    //返回一个list集合集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){

        List<SimpleGrantedAuthority> lists=new ArrayList<>();
        for(Role r:roles){
            lists.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName()));
        }

        return lists;

    }

    @Override
    public List<UserInfo> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserDao.save(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserDao.update(userInfo);
    }
}
