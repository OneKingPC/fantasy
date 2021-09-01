package com.venchi.dark.annotation;

import com.alibaba.fastjson.JSON;
import com.venchi.dark.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

/**
 * @author liwc
 * @date 2021/09/01
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    private final static String LOG_PREFIX_STRING="[系统日志]--------------------------------";
    private final static String ERROR_LOG_PREFIX_STRING="[异常日志]******************************";

    @Pointcut("@annotation(com.venchi.dark.annotation.Log)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Log annotation = method.getAnnotation(Log.class);
        if(null == annotation){
            return joinPoint.getArgs();
        }
        String value = annotation.value();
        long startTime = System.currentTimeMillis();
        log.info(LOG_PREFIX_STRING+"方法[{}]开始执行,开始时间{}", value, startTime);
        HttpServletRequest request = getRequest();
        log.info(LOG_PREFIX_STRING+"请求方法路径为:{}", request.getRequestURL());
        StringBuilder params = new StringBuilder();
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        if (argValues != null) {
            for (int i = 0; i < argValues.length; i++) {
                params.append(argNames[i]).append(":").append(argValues[i]);
            }
        }
        log.info(LOG_PREFIX_STRING+"请求参数为:[{}]", params + "");
        Object proceed = joinPoint.proceed();
        log.info(LOG_PREFIX_STRING+"响应参数为: [{}]", JSON.toJSON(proceed));
        log.info(LOG_PREFIX_STRING+"执行完毕耗时 :{}", (System.currentTimeMillis() - startTime));
        return proceed;
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void throwIng(JoinPoint joinPoint, Throwable e) {
        log.info(ERROR_LOG_PREFIX_STRING+"开始进行记录");
        String stackTrace = stackTrace(e);
        HttpServletRequest request = getRequest();
        String ipAddr = IPUtil.getIPAddr(request);
        log.info(ERROR_LOG_PREFIX_STRING+"当前请求的Ip地址为:{}", ipAddr);
        log.info(ERROR_LOG_PREFIX_STRING+"错误信息为:{}", stackTrace);
        log.info(ERROR_LOG_PREFIX_STRING+"异常日志记录完毕");
        // TODO: 2021/1/31 未做数据库存储
    }

    private static String stackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

    private HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        assert servletRequestAttributes != null;
        return servletRequestAttributes.getRequest();
    }

}
