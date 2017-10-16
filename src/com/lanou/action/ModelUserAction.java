package com.lanou.action;

import com.lanou.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by dllo on 17/10/11.
 */
public class ModelUserAction extends ActionSupport implements ModelDriven<User>{

    private User user; // 承接表单提供的数据
    private String[] hobbies; // 爱好, 接收多个值


    public String login(){
//        从实体类的属性判断是否登录成功
        if (user.getUsername().equals("text")){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }


    public String regist(){
        System.out.println(hobbies);

        if (!user.getUsername().equals("text")){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }


    @Override
    public User getModel() {
        // 创建一个空对象,并传递给模型驱动接口对其进行赋值
        user = new User();
        return user;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
