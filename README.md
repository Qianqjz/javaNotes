//TypeScript是什么？ 简称ts. 
    // TS是JS的类型化超集，可编译为普通JS。
    // 主要提供了类型系统和对ES6的支持，它由 Microsoft开发，代码开源于GitHub上。

//TS的优势
    // 增加了代码的可读性和可维护性
        //通过函数类型名称就可以知道作用
        //在编译阶段就能发现错误，比在运行时出错要好一些。
        //对编译器良好的增强，代码补全，接口提示等等。
    // 包容性
        // TS是JS的超集，.js文件可以直接重命名为.ts 即可
        // 即使不显式的定义类型，也能够自动做出类型推论
        // 即使TS编译报错，也可以生成JS文件
        // 兼容第三方库，即使第三方库不是用TS写的，也可以编写单独的类型文件供TS读取   
    // 活跃的社区
        // 大部分第三方库都有提供给TS的类型定义文件
        // Angular、Vue等等项目都是使用TS编写的
        // TypeScript拥抱了ES6规范。

// ES6是什么?
    // ECMAScript 6.0（以下简称ES6）是JS语言（现在是遵循ES5标准）的下一代标准，
    // 已经在2015年6月正式发布了。它的目标，是使得JS语言可以用来编写复杂的大型应用程序，成为企业级开发语言。

// ES6的新特性
    // ES6中的let命令，声明变量，用法和var差不多，但是let是为JS新增了块级作用域，
        // ES5中是没有块级作用域的，并且var有变量提升的概念，但是在let中，使用的变量一定要进行声明。
    // ES6中变量的解构赋值，比如：var [a,b,c] = [0,1,2];
    // ES6中不再像ES5一样使用原型链实现继承，而是引入Class这个概念，
        // 听起来和Java中的面向对象编程的语法有些像，但是二者是不一样的。
    // ES6中的函数定义也不再使用关键字function，而是利用了=>来进行定义；
    // ES6中可以设置默认函数参数，如function A（x,y=9）{};

// ECMAScript和JS的关系
    // 由于JS的创造者Netscae公司的版权问题，ECMAScript不能叫JS。
    // ECMAScript是JS的语言规范，JS是ECMAScript的一种实现。


////////////
//布尔类型 (boolean)  true false

    // let flag: boolean = true
    // flag=false
    // flag='2343' //报错

//数字类型 (number)

    // var a: number=123
    // a=123.3
    // console.log(a)
    // a='213'

//字符串 (string)

    // let str :string ='this is ts'
    // str='this is str'
    // console.log(str)

//数组类型 (array)  定义数组的两种方式

    // 1.第一种方式

    // let  arr:number[]=[1,2,3]
    // console.log(arr)

    // let str: string[]=['java','ts','go']
    // console.log(str)
    
    // 2.第二种方式

    // let arr: Array<number> = [1,2,3,4]
    // console.log(arr) 

    // let str: Array<string> =['this.a','23434']
    // console.log(str)

    // 3.第三种

    // let arr:any
    // arr =['java',123,true]
    // console.log(arr)

 //元组类型 (tuple)  数组类型的一种 可以执行数组中没有元素的类型

    // let arr:[string,number,boolean] = ['ts',123,true]
    // console.log(arr)

//枚举类型 (enum)

    // pay_status  0  未支付 1 支付 2 交易成功
    // flag  1 true 2 false 
    
    // enum Flag{
    //     success = 1,
    //     error = -1
    // }
    
    // let f:Flag=Flag.success
    // console.log(f)

    // 不赋值时，默认打印出索引
    // enum Color{
    //     red,
    //     blue,
    //     yellow
    // }

    // let c:Color=Color.red
    // console.log(c)

// 任意类型 (any) 表示允许赋值为任意类型。

    // let num:number=123
    // let str:any = '123'
    // str=123
    // str=false

// null 和 undefined   其他数据类型   

    // let num:number
    // console.log(num)  //输出undefined   报错

    // let num1:undefined
    // console.log(num1)  //输出undefined

    // let  num: number | undefined
    // num=123
    // console.log(num)  //输出123

    //定义为赋值
    // let  num: number | undefined
    // console.log(num)      //输出undefined

    // 定义空类型
    // let num:null
    // num=null

    //如果一个值是number ,undefined 和null
    // let num:number|undefined|null
    // num = 123
    // console.log(num)

//void (没有任何类型) 一般用于定义方法无返回值

    //方法没有返回任何类型 
    // function run():void{
    //     console.log('no void')
    // }

    // run();
   

    // function run(): number {
    //     return 123
    // }

    // run();
   
//never类型 其他类型 (包括null ,undefined)的子类型  代表从不会出现的值
    // 意味着声明never类型的值，只能被never类型赋值

    // let num:undefined
    // num=undefined

    // let num1:null
    // num1=null    

    // let  a:never
    // // a=123 //报错

    // a = (()=>{
    //     throw new Error('error')
    // })() 

///////////
//  函数
    // 1.定义函数
        //ES5函数声明类

            // function run(){
            //     console.log('run')
            // }

        //ES5匿名函数
            // var  r = function(){
            //     console.log('r')
            // }
    
        //ts定义函数

            // function run(): string{
            //       return 'run '
            // }

        //匿名函数
            // let r=function run():string{
            //     return '123'
            // }

    //2.可选参数

        // function  getInfo(name:string,age:number) :string{
        //     return `${name}......${age}`
        // }
        // console.log(getInfo('tom',123))

        // let getInfo = function(name:string,age:number) :string{
        //     return `${name}......${age}`
        // }
        // alert(getInfo('tom',123))

    //3.没有返回值的方法
        // function run():void{
        //     console.log('run')
        // }

    //4.可选参数 必须配置到参数最后面！！！
        // function  getInfo(name:string,age?:number ) :string{
        //     if(age){
        //         return `${name}......${age}`
        //     }else{
        //         return `${name}......年龄不告诉你,>-<`
        //     }
        // }
        // alert(getInfo('tom'))
        // alert(getInfo('tom',123))

    //5.默认参数 无顺序要求
        // function  getInfo(name:string,age:number = 22) :string{
        //     return `${name}......${age}`
        // }
        // console.log(getInfo('tom'))

    //6.剩余参数
        // function sum(a: number,b: number,c:number):number{
        //     return a+b+c ;   
        // }
        // alert(sum(1,3,5));

        //三点运算符
        // function sum(...result:number[]):number{
        //     let sum = 0;
        //     for(let i=0;i<result.length;i++){
        //         sum += result[i]
        //     }
        //     return sum;
        // }   
        // alert(sum(2,4,8,10,1))


        //将2赋值给a
        // function sum(a:number,...result:number[]):number{
        //     let sum = a;
        //     for(let i=0;i<result.length;i++){
        //         sum += result[i]
        //     }
        //     return sum;
        // }   
        // alert(sum(2,4,8))


    //7.ts函数重载
    //java 中的重载 是指两个或者两个以上的同名函数，但是他们的参数不一样，发生重载

    //ts 通过为同一个函数提供多个函数类型定义来实现多种功能

    //ES5
        // function css(config){}
        // function css(config,value){}   //出现同名下面的会替换上面的方法

    //ts 重载
        // function getInfo(name:string):string;
        // function getInfo(age:number):number;
        // function getInfo(str:any):any{
        //     if(typeof str=='string'){
        //         return 'my name .'+str;
        //     }else{
        //         return 'my age .'+ str;
        //     }
        // }   

        // alert(getInfo('jerry'))
        // alert(getInfo(234))
        // alert(getInfo(true))  //错误的写法

   //////////////
   
   
   // 对象：对象是类的一个实例 ,有状态和行为。
    // 例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。
// 类：类是一个模板，它描述一类对象的行为和状态。
// 方法：方法是类的操作的实现步骤


//类
    //ES5 定义类
    /*
        function Person(){
            this.name='Tom'
            this.age=23
            this.run=function(){
                alert(this.name+'在运动')
            }
        }

        var p=new Person()
        alert(p.name)
        p.run();
    */

    // 1.  ts 定义类

    // class Person{
    //     name:string; //属性  忽略public 关键字
        
    //     constructor(name:string){
    //         this.name=name;
    //     }
        
    //     getName() : string {
    //         return this.name;
    //     }
        
    //     setName(name:string) :void {
    //         this.name=name;
    //     }
    // }

    // let p=new Person('TOM');
    // alert(p.getName());
    // p.setName('Jerry')
    // alert(p.getName());

    // 2. ts 继承 extend super

    // class Person{
    //     name:string; //属性  忽略public 关键字
        
    //     constructor(name:string){
    //         this.name=name;
    //     }
        
    //     run():string{
    //         return `${this.name}在运动`;
    //     }
    // }

    // // let p=new Person('TOM');
    // // alert(p.run())

    // class Web extends Person{
    //      constructor(name:string){
    //          super(name);
    //      }   

    //     work():string{
    //         return `${this.name}在工作`;
    //     }

    //     run():string{
    //         return `${this.name}在运动 web`;
    //     } 
    // }

    // let w=new Web('Jim');
    // alert(w.run());  //执行子类的方法

    // 3.ts 修饰符
    /**
     * public : 公有的 类。子类，类外部都能访问
     * protected：保护类型：类，子类，
     * private：类里面访问： 类
     */

     //4. ts静态方法 ,静态属性
     /*
        class Person{
            name:string; //属性  忽略public 关键字
            static sex:number = 20;//静态属性
            
            constructor(name:string){
                this.name=name;
            }
            
            //实例方法
            run():string{
                return `${this.name}在运动`;
            }

            work():string{
                return `${this.name}在工作`;
            }

            static print():void{
                alert('print ()')    
            }
        }

        Person.print();
    */

    //5. ts 多态
    /*
        class Animal{
            name:string;
            constructor(name:string){
                this.name=name;
            }
            eat():void{

            }
        }

        class Dog extends Animal{
            constructor(name:string){
                super(name);
            }
            eat():void{
                console.log('小狗吃粮食');
                alert('小狗吃粮食');
            }
        }    

        let d=new Dog('tom')
        d.eat();
    */
    //6 ts 抽象类，抽象方法 用来定义标准 ,子类里面必须属性父类中的抽象方法
    
    // abstract class Animal {
    //    abstract eat():any;
    // }
//////////////

//7 ts 接口 定义标准

    // interface Person {
    //     name: string;
    //     age: number;
    // }

    // let tom: Person = {
    //     name: 'Tom',
    //     age: 25
    // };

    // 少(多)一个属性会报错
    //  let tom: Person = {
    //     name: 'Tom',
    //     // age: 25
    //     // sex: '男'
    // };

    // 可选属性？
    // interface Person {
    //     name: string;
    //     age?: number;
    // }

    // let tom: Person = {
    //     name: 'Tom',
    // };

    // 任意类型
    // interface Person {
    //     name: string;
    //     age?: number;
    //     [propName: string]: any;
    // }

    // let tom: Person = {
    //     name: 'Tom',
    //     sex: 'm',
    //     id: number,
    // };

    // 只读类型
    // interface Person {
    //     readonly id:number,
    //     name: string;
    //     age?: number;
    //     [propName: string]: any;
    // }

    // let tom: Person = {
    //     id: 1234,
    //     name: 'Tom',
    //     sex: 'm',
    // };

    // tom.id=123455;


// 属性类接口 对json的约束
    // function printlabel(lableinfo:{label:string}):void{
    //     console.log('lable')
    // }
    // printlabel('tom');//错误写法
    // printlabel({name:'tom'});//错误写法
    // printlabel({label:'tom'});//正确写法

// 对批量的方法进行约束
    //属性接口

    // interface FullName{
    //     firstName: string;
    //     secondName: string;
    // }

    // function pringName(name: FullName):void{
    //     console.log(name.firstName+',,'+name.secondName);
    // }

    // let obj={
    //     age:12,
    //     firstName:'tom',
    //     secondName:'jerry'
    // }
    // //参数中必须包含  firstName:string;   secondName:string;
    // pringName(obj);
        
        
//函数类型接口
    //加密接口
        // interface encrypt{
        //     (key:string,value:string):string;
        // }      

        // let md5:encrypt=function(key:string,value:string):string{
        //     return key+',,'+value
        // }
    
        // console.log(md5('name','tom'));         

//可索引接口

    //数组
    // let arr:number[]=[1,23,3];
    // let ar:Array<number> =[12,34,5]

    // interface userArray{
    //     [index:number]:string;
    // }        

    // let arr:userArray=['aaa','bbb'];
    // console.log(arr);

    //对象
    // interface user{
    //     [index:string]:string
    // }

    // let u:user={name:'123',age:'123'}

//类类型接口
    // interface Animal {
    //     name: string;
    //     eat(food: string): void;
    // }

    // class Dog implements Animal {
    //     name: string;
    //     constructor(name: string) {
    //         this.name = name;
    //     }
    //     eat(): void {
    //         console.log('吃粮食');
    //         alert('吃粮食')
    //     }
    // }
    // let d = new Dog('tom');
    // d.eat();

    // class Cat implements Animal {
    //     name: string;
    //     constructor(name: string) {
    //         this.name = name;
    //     }
    //     eat(food: string): void {
    //         console.log('吃老鼠');
    //         alert('吃老鼠')
    //     }
    // }
    // let c = new Cat('tom');
    // c.eat('123');

//接口扩展  接口可以继承接口,

//类可以继承父类，可以实现接口
    // interface Animal{
    //     eat():void;
    // }

    // interface Person extends Animal{
    //     work():void;
    // }

    // class web implements Person{
    //     eat=()=>{

    //     }   
    //     work=()=>{

    //     }
    // }
    
    //////////////////
    
    //泛型 通俗的理解为解决，类，接口，方法的复用性，以及对不确定数据类型的支持

    // function getData(value:string):string{
    //     return value;
    // }

    //放弃类型检查
    // function getData(value:any):any{
    //     return value;
    // }

    //泛型 可以支持不稳定的数据类型 ,要求，输入的类型与输出的类型一致

    // function getData<T>(value:T):T{
    //     return value;
    // }

    // getData<number>(1234);


    //泛型类

    // class MinCls<T>{
    //     public list: T[] = [];
    //     add(value: T): void {
    //         this.list.push(value);
    //     }

    //     getMin(): T {
    //         let min = this.list[0];
    //         for (let index = 0; index < this.list.length; index++) {
    //             if (min > this.list[index]) {
    //                 min = this.list[index];
    //             }
    //         }
    //         return min;
    //     }
    // }

    // let min = new MinCls<String>();
    // min.add('d')
    // min.add('t')
    // min.add('A')
    // alert(min.getMin());

    //泛型接口  

    //函数类型接口
    // interface Configfn{
    //     (value1:string,value2:string):string;
    // }  

    // let setData:Configfn=function(value1:string,value2:string):string{
    //     return value1+value2;
    // }

    // alert(setData('2','34'));


    //定义泛型的方式一
//     interface ConfigFn{
//         <T>(value:T):T;
//     }

//     let getData:ConfigFn=function<T>(value:T):T{
//         return value;
//     }
//     alert(getData<string>('this is tom'));


    //定义泛型的方式二

    // interface ConfigFn<T>{
    //     (value:T):T;
    // }

    // function getData<T>(value:T):T{
    //     return value;
    // }

    // let getData1:ConfigFn<string> = getData;
    // alert(getData1('this is tom'));


    //把类做为泛型类

    // class User{
    //     userName:string|undefined;
    //     passWord:string|undefined;
    // }

    // class MysqlDB{
    //     add(user:User):boolean{
    //         console.log(user.userName)
    //         console.log(user.passWord)
    //         return true;
    //     }
    // }

    // let user=new User();
    // user.userName='tom';
    // user.passWord='123'

    // let db=new MysqlDB();
    // db.add(user);

    //泛型类

    //  class User{
    //     userName:string|undefined;
    //     passWord:string|undefined;
    // }

    // class MysqlDB<T>{
    //     add(info:T):boolean{
    //         return true;
    //     }
    // }

    // let user=new User();
    // user.userName='tom';
    // user.passWord='123'

    // let db=new MysqlDB<User>(); //加入泛型
    // db.add(user);
    


----------------------------
      //js 
        // 1.可以重复声明
            // var a = 12;
            // var a = 35;
            // alert(a);
        // 2.无法限制修改;没有常量的概念，自觉 ，java流行，严谨，死板，越适合开发大型项目；
            // var PI = 3.1415926;
            // var PI = 5.235;
            // alert(PI);
        // 3.没有块作用域
            //{}
            // if(true){var c = 123;}
            // alert(c);
            // for(){}


            // let   
                // 1不能重复声明 
                        // let aa=3;    
                        // let aa=5;
                        // alert(aa);    
                    // 2变量 可以修改 
                        // let b=3;
                        // b=4;
                        // alert(b);
                    // 3块级作用域的
                        // {let aa=3}
                        // alert(aa);
              
            // const 不能重复声明 常量 不可以修改  3块级作用域的 
                    // const b=3;
                    // b=4;
                    // alert(b);

=============

    <script>
     window.onload=function(){
         var aBtn = document.getElementsByTagName('input');
         //函数解决 var只认函数这一层。
         for(let i = 0 ;i<aBtn.length;i++){
             aBtn[i].onclick = function(){
                 alert(i);
             };   
         }
     };  
     //变量冲突 ，块级作用域更容易避免这个问题     
    </script>
    <input type="button" value="按钮1">
    <input type="button" value="按钮2">
    <input type="button" value="按钮3">






