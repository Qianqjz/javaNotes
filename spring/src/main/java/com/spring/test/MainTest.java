package com.spring.test;

import com.spring.config.config;
import com.spring.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring容器的refresh() 创建刷新；
 * 1、prepareRefresh();刷新钱的预处理；
 *      1)、initPropertySources();初始化一些属性，子类自定义属性，个性化的属性设置方法；
 *      2)、getEnvironment().validateRequiredProperties();检验属性的合法性等
 *      3）、this.earlyApplicationEvents = new LinkedHashSet<>();保存容器中的一些早期的事件；
 * 2、obtainFreshBeanFactory(); 获取BeanFactory()
 *      1)、refreshBeanFactory(); 刷新BeanFactory()
 *              创建了一个this.beanFactory = new DefaultListableBeanFactory()
 *              设置id
 *      2)、getBeanFactory(); 返回刚才GenericApplicationContext 创建的BeanFactory对象；
 *      3)、将创建的BeanFactory（DefaultListableBeanFactory）返回；
 * 3、prepareBeanFactory(beanFactory); 对BeanFactory的预准备工作（BeanFactory进行一些设置）
 *      1、设置beanFactory类加载器，支持表达式解析器、、、、
 *      2、添加前置处理器BeanPostProcessor（ApplicationContextAwareProcessor）
 *      3、设置忽略的自动装配的接口
 *          EnvironmentAware、EmbeddedValueResolverAware、、、、
 *      4、注册可以解析的自动装配，我们能直接在任何组件中自动注入；
 *          BeanFactory、ResourceLoader、ApplicationEventPublisher、ApplicationContext
 *      5、添加后置处理器BeanPostProcessor（ApplicationListenerDetector）
 *      6、添加编译时的aspectJ
 *      7、给beanFactory中注册一些能用的组件
 *          environment（ConfigurableEnvironment）
 *          SystemProperties（Map<String, Object>）
 *          SystemEnvironment（Map<String, Object>）
 * 4、postProcessBeanFactory(beanFactory);beanFactory准备工作完成后进行的后置处理工作；
 *      1、子类通过重写这个方法来postProcessBeanFactory创建预准备完成以后做进一步的设置
 *
 *  ====================以上是beanFactory的创建与预准备工作===========================
 * 5、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessors
 *      BeanFactoryPostProcessor；beanFactory的后置处理器，在beanFactory标准初始化之后执行的
 *      两个接口：
 *      BeanFactoryPostProcessor；
 *      BeanDefinitionRegistryPostProcessor ;给容器中额外添加组件的接口
 *      1 执行BeanFactoryPostProcessor的方法
 *          1、获取所有的BeanDefinitionRegistryPostProcessor
 *
 *
 */
public class MainTest {
    public static void main(String[] args){

        ApplicationContext applicationgcontext=new AnnotationConfigApplicationContext(config.class);
        Person person=applicationgcontext.getBean(Person.class);
        System.out.print(person);
    }
}
