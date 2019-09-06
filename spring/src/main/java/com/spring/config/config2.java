package com.spring.config;

import com.spring.condition.LinuxCondition;
import com.spring.condition.MyImportBeanDefintionRegistrar;
import com.spring.condition.MyImportSelector;
import com.spring.condition.WindowsCondition;
import com.spring.pojo.Color;
import com.spring.pojo.ColorFactoryBean;
import com.spring.pojo.Person;
import com.spring.pojo.Red;
import org.springframework.context.annotation.*;


@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefintionRegistrar.class})
public class config2 {

//    @Scope("prototype")

    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("注入bean");
        return new Person("lisi",12);
    }

    @Conditional({WindowsCondition.class })
    @Bean("bill")
    public Person person01(){
        return new Person("bill gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person03(){
        return new Person("linus",48);
    }

    /**
     * 给容器中注册注解
     * 1，包扫描+组件注解（@Controller，@Service）
     * 2, @Bean (导入的第三方包里面的组件)
     * 3，@Import[快速的给容器导入一个组件]
     *      1)@Import({color.class,red.class})
     *      2)@ImportSelector :返回需要导入的全类名数组
     *      3)@ImportBeanDefintionRegistrar：手动注册bean到容器中。
     * 4,使用spring提供的factoryBean(工厂Bean)
     *      1),默认获取的是工厂Bean调用的GetObject创建的对象
     *      2),要获取工厂bean对象，我们需要给id前面加一个&
     *          &colorFactoryBean
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
