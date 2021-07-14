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
        const val android_configChanges_answer = "程序在运行时，一些设备的配置可能会发生改变，如：横竖屏切换、键盘的可用性等这样的事情发生的时候，activity在没有配置android:configChanges属性时会重新启动\n" + "生命周期：onSaveInstanceState-->onPause-->onStop-->onDestroy-->onCreate-->onStart-->onRestoreInstanceState-->onResume\n" + "\n" + "但如果给configChanges配置了orientation|keyboardHidden|screenSize这些属性后，再发生屏幕改变会调用onConfigurationChanged方法，我们可以通过Configuration里的orientation属性判断是横向还是纵向。"
        const val ProfileUrl = "profileUrl"
        const val GifData = "gifData"
    }
}

