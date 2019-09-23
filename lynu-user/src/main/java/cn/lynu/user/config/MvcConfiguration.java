package cn.lynu.user.config;

import cn.lynu.user.interceptors.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//声明这是一个配置类，代替原来的xml配置文件
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;

    //重写接口中的addInterceptors方法，添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  /**代表拦截所有请求
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
