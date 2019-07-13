package threadgroup;

/**
 * 
 * @类名: ThreadGroupName
 * @说明:线程组使用 
 *
 * @author   liugh
 * @Date	 2019年6月29日 下午3:16:49
 * 修改记录：
 *
 * @see
 */
public class ThreadGroupName implements Runnable{

	@Override
	public void run() {
		String groupAndName=Thread.currentThread().getThreadGroup().getName()+"_"+Thread.currentThread().getName();
		while(true) {
			System.out.println("I am"+groupAndName);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		//创建线程组，并且命名组名
		ThreadGroup tg=new ThreadGroup("PrintGroup");
		//创建线程，加入线程组
		Thread t1=new Thread(tg,new ThreadGroupName(),"T1");
		Thread t2=new Thread(tg,new ThreadGroupName(),"T2");
		t1.start();
		t2.start();
		//线程数
		System.out.println(tg.activeCount());
		//线程信息
		tg.list();
		
	}

}
