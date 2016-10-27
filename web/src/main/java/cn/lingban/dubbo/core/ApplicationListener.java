package cn.lingban.dubbo.core;

import cn.lingban.dubbo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by chao on 2016/10/27.
 */
public class ApplicationListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);

    /**
     * * Notification that the web application initialization process is starting.
     * All ServletContextListeners are notified of context initialization before
     * any filter or servlet in the web application is initialized.
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 因为加载方式不同，故不能直接使用注解
        // 具体原因搜索
        UserService userService = (UserService) WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(UserService.class);

        logger.info(">>>>>>>>>>>>>>>>>>>>>>> 项目正在启动....");
    }

    /**
     * * Notification that the servlet context is about to be shut down. All
     * servlets and filters have been destroy()ed before any
     * ServletContextListeners are notified of context destruction.
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        logger.info(">>>>>>>>>>>>>>>>>>>>>>> 项目正在关闭....");
    }
}
