package com.example.kotlin.data

import com.example.kotlin.R

/**
 * Author: sym
 * Date: 2021/7/13 8:11 PM
 * Describe:
 */
 class QA{

    companion object {
        const val performance_optimization = "性能优化"
        const val performance_optimization_answer = "性能优化：Android的性能优化，主要是从以下几个方面进行优化的：\n" + " \n" + "一是稳定性，是否有内存溢出、崩溃的情况\n" + "\n" + "二是流畅性，有没有卡顿，冷启动时间长不长\n" + "\n" + "三是耗损是否严重，耗电、流量多不多啊\n" + "\n" + "四是安装包体积等，有没有冗余可优化空间"
        const val tcp_shake_hands = "Tcp握手过程"
        const val tcp_shake_hands_answer = "TCP三次握手：\n" + "\n" + "1：客户端发送syn包(syn=j)到服务器，并进入SYN_SEND状态，等待服务器确认；\n" + "\n" + "2：服务器收到syn包，必须确认客户的SYN（ack=j+1），同时自己也发送一个SYN包（syn=k），即SYN+ACK包，此时服务器进入SYN_RECV状态；\n" + "\n" + "3：客户端收到服务器的SYN＋ACK包，向服务器发送确认包ACK(ack=k+1)，此包发送完毕，客户端和服务器进入ESTABLISHED状态，完成三次握手。\n" + "\n" + "四次挥手：\n" + "1、主动关闭方会发一个长度为0的数据包以及FIN关闭标识。\n" + "\n" + "2、被动方收到FIN后，会发一个ACK确认包，确认序号+1。\n" + "\n" + "3、确认无需要发送数据后，被动关闭方也会发一个FIN包，告诉主动关闭方，我也不会再发数据了。\n" + "\n" + "4主动关闭方发ACK确认，确认序号+1。\n\n" + "两次不行，为了防止出现失效的连接请求报文段被服务端接收的情况，从而产生错误。\n" + "\n" + "确认号要加1，因为报文不一定会按发送的时序到达目标，为了区分所以要加1\n" + "\n" + "出现大量的close_wait是因为被动关闭方没有发送FIN包确认关闭，是程序的问题。\n" + "如果是server主动关闭链接,那么Client则有可能进入CLOSE_WAIT,如果Client不发送FIN包，该关不关,那么client就一直会处在CLOSE_WAIT状态\n" + "\n" + "为什么是4次握手，因为被动方收到FIN后，需要先确认，防止主动方因等待时间过长再发FIN，被动方处理完数据后再发FIN"
        const val draw_view = "View的绘制流程"
        const val draw_view_answer = "我们触发一个焦点请求绘制布局时，这个请求是由安卓的framwork层来处理的，绘制会从根视图 ViewRoot 的 performTraversals() 方法开始，从上到下遍历整个视图树，具体操作是分发给 ViewGroup 的，ViewGroup 通过遍历自身所有的子 View，并逐个调用子 View 的 measure 方法实现测量操作。measure方法是final的所以这个方法也不可重写，如果想自定义View的测量，需要重写onMeasure()方法，我们可以通过mesureSpec获取到view的尺寸，改写过后还需要调用setmeasuredimension方法来配置他的宽高。(布局文件是warp，但我们想改成固定值就可以用onMesure)\n" + "\n" + "layout的作用就是为整个View树计算实际的位置，他和mesure一样，需要递归的去计算每一个子视图的位置。如果需要重写，可以调用onLayout方法，要传入标识，还有左上右下这4个相对于父view的距离参数。\n" + "\n" + "draw作用就是绘制View 的背景、子View、还有前景跟滚动条等。还有一个onDraw空方法，自定义View的话需要重写，在里面绘制自己需要添加的内容"
        const val lock_type_use = "锁的分类及用法"
        const val lock_type_use_answer = "Synchronized的用法 ：\n" + "锁主要有三种\n" + "\n" + "类锁:像synchronized(class)或是锁静态方法，这种都是类锁，作用范围比较大，类的所有对象都会被作用到。\n" + "\n" + "第二种是对象锁，像普通方法锁就是，他的作用范围就是一个对象，不同线程不能同时执行一个对象的不同synchronized方法。\n" + "\n" + "还是就是同步代码块，synchronized（obj），这个的作用范围就是被作用的代码块上。"
        const val activity_life = "Activity生命周期及跳转"
        const val activity_life_answer = "onCreate:create表示创建\n" + "onStart:start表示启动\n" + "onResume:resume表示继续、重新开始\n" + "onPause:pause表示暂停\n" + "onStop：stop表示停止\n" + "onDestroy：destroy表示销毁\n" + "onRestart：restart表示重新开始\n" + "\n" + "当A跳转到B的时候，A先执行onPause，然后居然是B再执行onCreate -> onStart -> onResume，最后才执行A的onStop!!!\n" + "\n" + "当B按下返回键，B先执行onPause，然后是A再执行onRestart -> onStart -> onResume，最后才是B执行onStop  -> onDestroy\n" + "\n" + "如果B是dialog或透明的，A只会执行onPause，不会执行onStop。当A跳转到B的时候，A先执行onPause，然后居然是B再执行onCreate -> onStart -> onResume。（注意：A的 onStop 不会执行）\n" + "\n" + "当B按下返回键，B先执行onPause，然后是A只会执行 onResume，最后 B 执行onStop  -> onDestroy。"
        const val android_configChanges = "activity横纵向切换，或页面发生改变时"
        const val android_configChanges_answer = "程序在运行时，一些设备的配置可能会发生改变，如：横竖屏切换、键盘的可用性等这样的事情发生的时候，activity在没有配置android:configChanges属性时会重新启动\n" + "生命周期：onSaveInstanceState-->onPause-->onStop-->onDestroy-->onCreate-->onStart-->onRestoreInstanceState-->onResume\n" + "\n" + "但如果给configChanges配置了orientation|keyboardHidden|screenSize这些属性后，再发生屏幕改变会调用onConfigurationChanged方法，我们可以通过Configuration里的orientation属性判断是横向还是纵向。\n" +"\n"+"onNewIntent 什么时候调用\n"+"如果此次启动不创建该Activity的新实例,则系统会调用原有实例的onNewIntent()方法来处理此intent"
        const val fragment_life = "Fragment生命周期"
        const val service_life_stop = "Service生命周期与终止方法"
        const val service_life_stop_answer = "startService   生命周期       \n" + "onCreate()：创建服务  、\n" + "onStartCommand()：服务开始运行、\n" + "onDestroy() ：服务被停止\n" + "\n" + "bindService     生命周期\n" + " onCreate()：创建服务  、\n" + "onBind()：绑定服务，服务开始运行   、\n" + "onUnbind()：取消绑定   、\n" + "onDestroy() ：服务被停止\n" + "\n" + "终止的话使用stopSelf()或stopService(intent)\n" + "\n" + "混合启动如何停止：同时使用 startService 与 bindService Service 的终止，需要unbindService与stopService同时调用，才能终止 Service。不管 startService 与 bindService 的调用顺序"
        const val activity_launchMode = "Activity启动模式"
        const val activity_launchMode_answer = "Task是指将相关的Activity组合到一起，以Activity Stack的方式进行管理。一个Task是可以有一个或多个Android Application组成的\n" + "\n" + "\n" + "standard 模式:这是默认模式，每次激活Activity时都会创建Activity实例，并放入任务栈中。\n" + "\n" + "singleTop 模式:如果在任务的栈顶正好存在该Activity的实例，就重用该实例( 会调用实例的 onNewIntent() )，否则就会创建新的实例并放入栈顶，即使栈中已经存在该Activity的实例，只要不在栈顶，都会创建新的实例。适合接收通知启动的内容显示页面。例如，某个新闻客户端的新闻内容页面，如果收到10个新闻推送，每次都打开一个新闻内容页面是很烦人的\n" + "\n" + "\n" + "singleTask 模式:如果在栈中已经有该Activity的实例，就重用该实例(会调用实例的 onNewIntent() )。重用时，会让该实例回到栈顶，因此在它上面的实例将会被移出栈。如果栈中不存在该实例，将会创建新的实例放入栈中。适合作为程序入口点。例如浏览器的主界面。不管从多少个应用启动浏览器，只会启动主界面一次，其余情况都会走onNewIntent，并且会清空主界面上面的其他页面。之前打开过的页面，打开之前的页面就ok，不再新建\n" + "\n" + "\n" + "singleInstance 模式\n" + "     在一个新栈中创建该Activity的实例，并让多个应用共享该栈中的该Activity实例。一旦该模式的Activity实例已经存在于某个栈中，任何应用再启动该Activity时都会重用该栈中的实例( 会调用实例的 onNewIntent() )。其效果相当于多个应用共享一个应用，不管谁激活该 Activity 都会进入同一个应用中。\n" + "设置启动模式的位置在 AndroidManifest.xml 文件中 Activity 元素的 Android:launchMode 属性。singleInstance适合需要与程序分离开的页面。例如闹铃提醒，将闹铃提醒与闹铃设置分离。singleInstance不要用于中间页面，如果用于中间页面，跳转会有问题，比如：A -> B (singleInstance) -> C，按返回会直接从C跳到A"
        const val http_https = "Http与Https的区别"
        const val http_https_answer = "主要有3点不同\n" + "1、安全性：HTTPS不是明文传输的，会通过SSL数据加密、TLS验证身份，以及数据完整性保护（收方或非法者不能伪造、篡改报文，运营商加广告）而HTTP是明文传输无状态的（比较独立，服务器与客户端都不会记录信息），所以安全性要高于HTTP\n" + "2、HTTPS需要申请CA证书，而HTTP不需要\n" + "3、用的端口也不一样，HTTP是80，HTTPS是443"
        const val jvm_model = "JVM模型"
        const val jvm_model_answer = "程序计数器\n" + "一块较小的内存空间，是字节码解释器的行为指示器。程序执行的过程中会有分支、循环、跳转、异常处理、线程恢复等基础功能，也就是程序运行碰到了关键字或特殊行为，字节码解释器就需要进行特殊处理，而字节码需要怎么做正是由程序计数器去通知。程序计数器是线程私有的\n" + "\n" + "虚拟机栈\n" + "Java 方法执行的内存模型，每个方法执行的时候，都会创建一个栈帧用于保存局部变量表，操作数栈，动态链接，方法出口信息等。一个方法调用的过程就是一个栈帧从 VM 栈入栈到出栈的过程。VM 栈主要用于存储方法包含的信息如，基本数据类型、局部变量等，VM 栈也是线程私有的\n" + "\n" + " 本地方法栈\n" + "执行 Native 方法的栈，与 VM 栈发挥的作用非常相似，VM 栈执行Java 方法（字节码）服务，Native 方法栈执行的是 Native 方法服务。Native 栈也是线程私有的\n" + "\n" + "Java 堆 \n" + "所有线程共享的一块内存区域，在虚拟机启动时创建。此内存区域唯一的目的就是存放对象实例，几乎所有的对象都在这分配内存。Java 堆是线程共享的。\n" + "\n" + "方法区 \n" + "存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码数据等。这部分区域包含「运行时常量池」，所以这个区域主要存储常量。方法区是线程共享的\n"
        const val jvm_gc_root = "GC root 对象"
        const val jvm_gc_root_answer = "1.虚拟机栈(栈帧中的本地变量表)中引用的对象\n" + "2.方法区中类静态属性引用的对象\n" + "3.方法区中常量引用的对象\n" + "4.本地方法栈中 JNI(一般说的 Native 方法)引用的对象"
        const val volatile_synchronize_use = "volatile特性、与synchronize区别"
        const val volatile_synchronize_use_answer = "Volatile关键字可以修饰变量，用于多线程的访问\n\nvolatile的作用，保证内存可见性和有序性，但不能保证原子性\n\n" + "内存可见性：如果对变量加上volatile关键字修饰的话，它可以保证当有线程对变量值做了变动之后，会立即刷回到主内存中，所有线程都能读到相同的值\n" + "\n" + "有序性：JVM为了保证执行上的效率，可能会对指令进行重排序，而加上volatile关键字修饰后，在指令间插入一个屏障点，就告诉JVM和CPU，不能进行重排优化。其实volatile有序性是通过内存屏障实现的\n" + "\n" + "不保证原子性：有个例子，1000个线程同时去对被volatile修饰过的变量进行+1操作，但值确肯定不是1000，也就是说volatile并不能保证一个线程执行完，另一个线程才开始执行，不能保证操作并不是不可分割的。\n\n区别：\n" + "1、volatile本质上是直接从主内存中读取值，无法保证同步\n" + "2、volatile只能实现变量的修改可见性，并不能保证原子性；而synchronizedl则因为能保证线程安全，可以保证变量的修改可见性和原子性。\n" + "3、volatile只能使用在变量级别；synchronized则可以使用在变量、方法、和类级别的。\n" + "4、volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞。"

    }
}

