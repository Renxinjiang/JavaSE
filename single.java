// 饿汉式
class SingleHungary{
	private SingleHungary(){}
	private static final SingleHungary instance = new SingleHungary();
	public static SingleHungary getInstance(){
		return instance;
	}
}

// 懒汉式
// 1. 单线程版懒汉
class SingleLazy1{
	private SingleLazy1(){}
	private static SingleLazy1 instance = null;
	public static SingleLazy1 getInstance(){
		if(instance == null){
			instance = new SingleLazy1();
		}
		return instance;
	}
}

// 2. 多线程---低性能
class SingleLazy2{
	private SingleLazy2(){}
	private static SingleLazy2 instance = null;
	public static synchronized SingleLazy2 getInstance(){
		if(instance == null){
			instance = new SingleLazy2();
		}
		return instance;
	}
}

// 3. 双重判断---高性能
class SingleLazy3{
	private SingleLazy3(){}
	private static volatile SingleLazy3 instance = null;
	public static SingleLazy1 getInstance(){
		if(instance == null){
			synchronized(SingleLazy3.class){
				if(instance == null){
					instance = new SingleLazy3();
				}
			}
		}
		return instance;
	}
}