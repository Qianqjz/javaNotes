package com.spring.test;

import com.spring.config.config;
import com.spring.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring容器的refresh() 创建刷新；
 * 1、prepareRefresh();刷新前的预处理；
 *      1)、initPropertySources();初始化一些属性，子类自定义属性，个性化的属性设置方法；
 *      2)、getEnvironment().validateRequiredProperties();检验属性的合法性等
 *      3)、this.earlyApplicationEvents = new LinkedHashSet<>();保存容器中的一些早期的事件；
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
 * 5、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessors的方法
 *      BeanFactoryPostProcessor；beanFactory的后置处理器，在beanFactory标准初始化之后执行的
 *      两个接口：
 *      BeanFactoryPostProcessor；
 *      BeanDefinitionRegistryPostProcessor ;给容器中额外添加组件的接口
 *      1 执行BeanFactoryPostProcessor的方法 优先执行实现了的子接口的方法
 *          先来执行BeanDefinitionRegistryPostProcessor的方法
 *              1、获取所有的BeanDefinitionRegistryPostProcessor
 *              2、看先执行实现了PriorityOrdered 的优先级接口的BeanDefinitionRegistryPostProcessor
 *                  postProcessor.postProcessBeanDefinitionRegistry(registry);
 *              3、在执行实现了Ordered顺序接口的的BeanDefinitionRegistryPostProcessor
 *                  postProcessor.postProcessBeanDefinitionRegistry(registry);
 *              4、最后执行没有实现任何优先级或者的接口的BeanDefinitionRegistryPostProcessors
 *                  postProcessor.postProcessBeanDefinitionRegistry(registry);
 *
 *           在来执行BeanFactoryPostProcessor 的方法
 *               1、获取所有的BeanFactoryPostProcessor
 *               2、看先执行实现了PriorityOrdered 的优先级接口的BeanFactoryPostProcessor
 *                   postProcessor.postProcessBeanFactory(beanFactory);
 *               3、在执行实现了Ordered顺序接口的的BeanFactoryPostProcessor
 *                   postProcessor.postProcessBeanFactory(beanFactory);
 *               4、最后执行没有实现任何优先级或者的接口的BeanFactoryPostProcessor
 *                   postProcessor.postProcessBeanFactory(beanFactory);
 *
 * 6、registerBeanPostProcessors(beanFactory);注册BeanPostProcessor（bean的后置处理器）拦截bean的创建过程intercept bean creation.
 *      不同接口类型的BeanPostProcessor、在Bean创建前后的执行时机是不一样的
 *      BeanPostProcessor、
 *      DestructionAwareBeanPostProcessor、
 *      InstantiationAwareBeanPostProcessor、
 *      SmartInstantiationAwareBeanPostProcessor、
 *      MergedBeanDefinitionPostProcessor（记录在internalPostProcessors）
 *
 *      1、获取所有的BeanPostProcessor后置处理器都默认可以通过priorityOrdered、ordered接口来指定优先级
 *      2、先注册priorityOrdered优先级接口的BeanPostProcessor
 *          把每一个BeanPostProcessor添加到BeanFactory中
 *          beanFactory.addBeanPostProcessor(postProcessor);
 *      3、在注册ordered接口的
 *      4、最后注册没有实现任何优先级接口的；
 *      5、最后注册MergedBeanDefinitionPostProcessor（记录在internalPostProcessors）
 *      6、注册一个ApplicationListenerDetector；在Bean创建完成后检查是否是ApplicationListener监听器，如果是就
 *          this.applicationContext.addApplicationListener((ApplicationListener<?>) bean);
 * 7、initMessageSource()；初始化MessageSource组件（做国际化功能，消息绑定，消息解析）
 *      1、获取beanFactory
 *      2、看容器中是否有id为MessageSource的，类型为MessageSource的组件
 *          如果有就赋值给MessageSource
 *          如果没有就创建一个DelegatingMessageSource
 *               MessageSource：取出国际化配置文件中的某个key的值，能按照区域消息来获取
 *      3、把创建好的MessageSource注册在容器中，以后获取国际化配置文件值的时候，可以自动注入MessageSource
 *          beanFactory.registerSingleton(MESSAGE_SOURCE_BEAN_NAME, this.messageSource)
 *          MessageSource.getMessage（）；调用这个方法。
 * 8、initApplicationEventMulticaster();初始化时间派发器
 *      1、获取beanFactory
 *      2、从BeanFactory中获取applicationEventMulticaster的ApplicationEventMulticaster;
 *      3、如果从上一步没有设置，创建一个SimpleApplicationEventMulticaster
 *      4、将创建的ApplicationEventMulticaster 添加到beanfactory中，以后其他组件自动注入
 * 9、onRefresh()；留给子容器（子类）
 *      1、子类重写这个方法，在容器刷新的时候自定义逻辑
 * 10、registerListeners();给容器中将所有项目里面的ApplicationListener注册进来
 *      1、从容器中拿到所有的ApplicationListener
 *      2、将每个监听器添加到事件派发器中；
 *          getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *      3、派发之前步骤产生的事件；
 * 11、finishBeanFactoryInitialization();初始化所有剩下的单实例bean;
 *      1、beanFactory.preInstantiateSingletons(); 初始化剩下的单实例bean
 *          1.获取容器中的所有Bean,以此进行初始化和创建对象
 *          2.获取bean的定义信息，RootBeanDefinition
 *          3.bean不是抽象的，是单实例的，是懒加载的；
 *              1.判断是factoryBean;是否是实现factoryBean接口的bean;
 *              2.不是工厂bean,利用getBean(beanname)创建对象
 *                  0.getBean(beanname)；IOC,getbean()方法；
 *                  1.doGetBean(name, null, null, false);
 *                  2.先获取缓存中保存的单实例bean,如果能获取，说明该bean之前被创建过（所有创建过得单实例bean都会本缓存起来）
 *                      private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
 *                  3.缓存中获取不到，开始bean的创建对象流程
 *                  4.标记当前bean已经被创建
 *                      markBeanAsCreated(beanName);
 *                  5.获取bean的定义信息；final RootBeanDefinition mbd = getMergedLocalBeanDefinition(beanName);
 *                  6.获取当前bean依赖的其他bean，如果有按照getBean(dep);的方法，把依赖的bean创建出来
 *                  7.启动单实例bean的创建流程
 *                      1.createBean(beanName, mbd, args);
 *                      2.拿到bean的定义信息，RootBeanDefinition
 *                      3.解析bean的类型Class<?> resolvedClass = resolveBeanClass(mbd, beanName);
 *                      4.让beanPostPrecessor先返回代理对象，使用的是这个InstantiationAwareBeanPostProcessor
 *                          正常的bean的前置处理器都是在bean创建完成之后，执行的，当时InstantiationAwareBeanPostProcessor是在创建之前就执行了
 *                          Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
 *                          InstantiationAwareBeanPostProcessor先执行
 *                          先触发：postProcessBeforeInstantiation（）；
 *                          如果有返回值，触发postProcessAfterInitialization();
 *                      5.如果前面的InstantiationAwareBeanPostProcessor没有返回代理对象；调用4.
 *                      6.Object beanInstance = doCreateBean(beanName, mbdToUse, args);
 *                          1.创建bean实例instanceWrapper = createBeanInstance(beanName, mbd, args);
 *                              利用工厂方法instantiateUsingFactoryMethod(beanName, mbd, args);
 *                              bean的构造方法 new ConstructorResolver(this).instantiateUsingFactoryMethod(beanName, mbd, explicitArgs);
 *                          2.执行后置处理器applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
 *                              调用MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition()
 *                          3.bean的属性赋值populateBean(beanName, mbd, instanceWrapper);
 *                             赋值之前：
 *                              3.1调用后置处理器InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation();
 *                              3.2调用后置处理器InstantiationAwareBeanPostProcessor.postProcessPropertyValues();
 *                             开始赋值
 *                              3.3应用bean属性的值，为属性利用setter方法等进行赋值
 *                                  applyPropertyValues(beanName, mbd, bw, pvs);
 *                          4.bean的初始化exposedObject = initializeBean(beanName, exposedObject, mbd);
 *                              4.1 （执行aware接口方法）invokeAwareMethods(beanName, bean);执行xxxawareMethos方法
 *                                  BeanNameAware、BeanClassLoaderAware、BeanFactoryAware 实现xxxaware接口，在这里进行回调处理
 *                              4.2 （执行后置处理器初始化之前的方法）wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *                                   BeanPostProcessor.postProcessBeforeInitialization()
 *                              4.3 (执行初始化方法)invokeInitMethods(beanName, wrappedBean, mbd);
 *                                    1.是否是InitializingBean接口的实现，是就执行规定初始化方法AccessController.doPrivileged（）
 *                                    2.是否是自定义初始化方法invokeCustomInitMethod(beanName, bean, mbd);
 *                              4.4 （后置处理器执行初始化之后的方法）wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *                                    BeanPostProcessor.postProcessAfterInitialization()
 *                          5.注册bean的销毁方法registerDisposableBeanIfNecessary(beanName, bean, mbd);
 *                      7.将已经创建的bean添加到缓存中。singletonObjects 注意：：这一步是在12.finishRefresh()里面执行的。
 *               ===== IOC容器就是这些map;很多Map里面保存了单实例bean,环境信息。。。。=========
 *               3.所有的bean都利用getBean创建完成以后：检查所有的bean是否是SmartInitializingSingleton 接口的，如果是，就执行
 *                      smartSingleton.afterSingletonsInstantiated();
 * 12.完成容器的创建工作。finishRefresh();IOC容器就创建成了。
 *      1.initLifecycleProcessor();初始化和生命周期有关的后置处理器；LifecycleProcessor
 *         默认从容器中找是否有 LifecycleProcessor的组件（LifecycleProcessor）如果没有创建一个new DefaultLifecycleProcessor();
 *         加入到容器中；
 *
 *         写一个LifecycleProcessor的实现类，可以在beanfactory的
 *         void onFresh();
 *         void onClose();
 *      2.getLifecycleProcessor().onRefresh();
 *          拿到前面定义的生命周期处理器（beanfactory）。回调onRefresh();
 *      3.publishEvent(new ContextRefreshedEvent(this));发布容器刷新完成事件
 *      4.LiveBeansView.registerApplicationContext(this);
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
