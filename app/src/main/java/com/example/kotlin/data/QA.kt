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
        const val YDEncryptionToken = "YDEncryptionToken"
        const val SearchHistory = "searchHistory"
        const val ProtocolIsAgree = "protocolIsAgree"
        const val ChameleonDebugRemote = "ChameleonDebugRemote"
        const val Username = "username"
        const val Nickname = "nickname"
        const val ProfileUrl = "profileUrl"
        const val GifData = "gifData"
    }
}

