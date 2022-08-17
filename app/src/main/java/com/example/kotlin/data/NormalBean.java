package com.example.kotlin.data;

import java.util.List;

public class NormalBean {
/*

    {
        "data": [{
        "title": "组件化通信原理，打包",
                "content": "组件化使用的是ARouter 核心实现思路是，我们在代码里加入的@Route注解，会在编译时期通过apt生成一些存储path和activityClass映射关系的类文件，然后app进程启动的时候会拿到这些类文件，把保存这些映射关系的数据读到内存里(保存在map里)，然后在进行路由跳转的时候，通过build()方法传入要到达页面的路由地址，ARouter会通过它自己存储的路由表找到路由地址对应的Activity.class(activity.class = map.get(path))，然后new Intent()，当调用ARouter的withString()方法它的内部会调用intent.putExtra(String name, String value)，调用navigation()方法，它的内部会调用startActivity(intent)进行跳转，这样便可以实现两个相互没有依赖的module顺利的启动对方的Activity了。\n\n打包的时候，可以通过gradle中的plugin来切换它是application还是library"
    }, {
        "title": "ARouter拦截器的处理",
                "content": "自定义拦截器需要实现IInterceptor接口，并且添加@Interceptor的注解，其中priority为拦截器的优先级，值越小，优先级越高；然后实现pocess()和init()方法。\n\n @Override\n    public void process(Postcard postcard, InterceptorCallback callback) {\n        Log.e(\"testService\", Test1Interceptor.class.getName() + \" has process.\");\n        //拦截跳转，进行一些处理\n        if (postcard.getPath().equals(\"/test/test1\")) {\n            Log.e(\"testService\", Test1Interceptor.class.getName() + \" 进行了拦截处理！\");\n        }\n        callback.onContinue(postcard);\n    }\n\n\nif (postcard.getExtra() == ConstantMap.LOGIN_EXTRA) {\n    boolean isLogin = postcard.getExtras().getBoolean(ConstantMap.IS_LOGIN);\n    if (!isLogin) {\n        ARouter.getInstance().build(RouterMap.INTER_MIDDLE_ACTIVITY).navigation();\n    } else {\n        postcard.withString(ConstantMap.IS_LOGIN_EXTRA, \"登录了!\");\n        callback.onContinue(postcard);\n    }\n}\n"
    }, {
        "title": "ARouter的使用",
                "content": "path的规则：/group/child…至少两个“/”；和Activity的@Route注解值匹配，Route主要有两个属性，path和group，在RouteProcessor中处理这个注解，在注解处理的方法中会根据注解的类型创建上面使用过的RouteMeta\n\n// 标准路由\nARouter.getInstance().build(\"/home/main\").navigation();\n\n// 标准分组路由\nARouter.getInstance().build(\"/home/main\", \"ap\").navigation();\n\n// Uri跳转\nARouter.getInstance().build(uri).navigation();\n\n// startActivityForResult  在navigation后加入\nARouter.getInstance().build(\"/home/main\", \"ap\").navigation(this, 5);\n\n跳转activity的时候，但凡涉及activity的任务栈，必须使用navigation(context)并且context只能是activity。建议，如果当前可以获取activity，最好传了。\n\n// 使用方式同Activity，navigation()方法会返回要跳到的对象实例，跳转Fragment可以拿到Fragment实例操作。\nFragment fragment = (Fragment) ARouter.getInstance().build(\"/test/fragment\").navigation();\nfragmentList.add(fragment);\n\n\n直接传bundle\t\t.with(bundle)\n\n指定flag\t\t\t.withFlags();\n\n传对象\t\t\t.withObject(\"key\", new Obj(“”))\n\n转场动画\t\t\t.withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)\n\n还提供了int、long、short等基本变量和String、Object、Serializable、Parcelable和对应的数组、List\n"
    }, {
        "title": "组件化跳转流程及关键类",
                "content": "1、获取ARouter实例\n2、构造路由信息的容器postcard\n3、如果需要拦截，就进行拦截器的处理，否则就调用_navigation方法。\n\n所有的Url/Intent跳转信息都使用Postcard邮戳进行信息封装。\n\n\nWarehouse\u2028存储跳转Path所对应的activity/fragment/url/provider，通过APT解析出来的映射关系存储在Warehouse中。\n\nLogisticsCenter\u2028负责解析注解并构造Postcard。以懒加载的方式从Warehouse中获取信息，包括class/url/extras/params等跳转信息。构造Postcard的信息储存对象为HashMap形式的RouteMeta。\n\n_ARouter\u2028负责根据Postcard进行页面跳转。Native采用startActivity形式。\n"
    }, {
        "title": "组件化资源冲突",
                "content": "在app模块引用greet字符串就会出现资源冲突问题。就是给每个子模块给资源名添加前缀，然后在子模块的build.gradle文件的android块内添加resourcePrefix “资源名前缀”。AS会约束我们定义资源。\n\nresourcePrefix \"me_\""
    }]
    }

    */
    private List<DataInFo> data;
    public List<DataInFo> getData() {
        return data;
    }

    public void setData(List<DataInFo> data) {
        this.data = data;
    }

    public static class DataInFo {
        private String title;
        private String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
