package cn.gaoz.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CMSServletContextListener implements ServletContextListener {
    private final Logger logger = LoggerFactory.getLogger(CMSServletContextListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //由于测试时在tomcat正常shutdown以后,仍然没有执行此操作,暂时换成@PreDestroy和@PostConstruct
        logger.info("contextDestroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("contextInitialized");
    }

}
