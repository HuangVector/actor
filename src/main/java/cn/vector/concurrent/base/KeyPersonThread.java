package cn.vector.concurrent.base;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-20 8:11
 */
public class KeyPersonThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName() + "开始战斗！");
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "左突右杀， 攻击隋军...");
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗！");
    }
}
