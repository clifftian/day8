package com.day8.pattern;

interface ServiceProvider {

	public void customHint();
}

// 一个ChinaTelecom类，即class B；
class ChinaTelecom {
	private ServiceProvider sp;// callback接口作为属性

	public void setSp(ServiceProvider sp) {
		this.sp = sp;
	}

	public void init() {
		System.out.println("Welcome, This is ChinaTelecom! ");
		sp.customHint();// sp自定义的操作
	}
}

// 一个KongNet类，即 class A
public class KongNet implements ServiceProvider {

	public void customHint() {
		System.out.println("优惠活动开始啦，即日起登陆空中网就有好礼送！ 详情见网站公告。");
	}

	public void init() {
		ChinaTelecom ct = new ChinaTelecom();
		ct.setSp(new KongNet());// 告诉ChinaTelecom这是哪家sp
		// KongNet（也就是当前类）实现了ServiceProvider，因此就能把当前类作为适合
		// ChinaTelecom.setSp()的参数，可以修改为ct.setSP(this);
		ct.init();
	}

	public static void main(String[] args) {
		KongNet sp = new KongNet();
		sp.init();
	}
}

/*这是网上最多见到的说明：   
1.class   A,class   B   
2.class   A实现接口callback
3.class   B拥有一个参数为callback接口类型的函数
4.class   A运行时调用class   B中的函数,以自身传入参数   
5.class   B已取得A，就可以随时回调A所实现的callback接口中的方法   */
