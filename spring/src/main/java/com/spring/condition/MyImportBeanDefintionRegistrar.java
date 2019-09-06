package com.spring.condition;

import com.spring.pojo.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefintionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata :当前类的注解信息
     * BeanDefinitionRegistry ：BeanDefintion注册类
     *      把所有需要添加的容器中的bean,调用BeandefinitionRegistry.registerBeanDefinition手工注册进来
     *
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.spring.pojo.Red");
        boolean definition2 = registry.containsBeanDefinition("com.spring.pojo.Blue");
        if(definition&&definition2){
            //指定Bean定义信息，(Bean的类型信息，Bean...)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Rainbow.class);
            //注册一个Bean,指定Bean的名称。
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }


    }
}
