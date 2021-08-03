package com.venchi.dark.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwc
 * @date 2021/07/07
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 配置Druid的监控
     * 1.配置一个管理后台的servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String,String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "admin");
        map.put("allow", "127.0.0.1");
        map.put("deny", "10.16.13.69");
        bean.setInitParameters(map);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        map.put("exclusions", "*.js,*.css,/druid/*");
        bean.setUrlPatterns(Arrays.asList("/*"));
        bean.setInitParameters(map);
        return bean;
    }

}
