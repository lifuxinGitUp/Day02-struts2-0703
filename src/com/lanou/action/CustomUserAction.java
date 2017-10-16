package com.lanou.action;

import com.lanou.domain.User;
import com.lanou.service.UserService;
import com.lanou.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * Created by dllo on 17/10/11.
 */
public class CustomUserAction extends ActionSupport implements ModelDriven<User>{

    private User user; // 接收页面数据的实体类对象
//    用户业务层对象
    private UserService service = new UserServiceImpl();
    private String[] hobbies;// 存放表单传递过来的数组


    /**
     * 登录
     * @return
     */
    public String login_UI(){
//        调用业务层对象中的登录方法 如果能正常返回 则进入登录页面
        if (service.login(user) != null){
            return SUCCESS;
        }
        return ERROR;
    }

    /**
     * 注册
     * @return
     */
    public String register_UI(){
//        将表单中的爱好数组转换为实体类中的字符串对象
//        user.setHobbies(Arrays.toString(hobbies));
//        循环遍历加入间隔符
//        StringBuilder sb = new StringBuilder();
//        for (String hobby :
//                hobbies) {
//            sb.append(hobby).append(",");
//        }

        if (service.register(user) != -1){
            return "login"; // 注册成功进入等了界面
        }
        return "register"; // 注册失败返回注册界面
    }


    /**
     * 模型驱动
     * @return
     */
    @Override
    public User getModel() {
        user = new User();
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
