package org.example.n6.cas;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAccount {

    public static void main(String[] args) {
        Account acount = new AccountUnsafe(10000);
        // demo是静态的方法
        Account.demo(acount);


        Account acount1 = new AccountCas(10000);
        // demo是静态的方法
        Account.demo(acount1);
    }

}






// synchronized  0 cost: 78 ms
class AccountUnsafe implements Account {

    private Integer balance;

    public AccountUnsafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        return this.balance;
    }

    @Override
    public void withdraw(Integer amount) {

        // 线程安全问题
//        this.balance -= amount;
        synchronized (this) { // 加锁。
            this.balance -= amount;
        }
    }
}




//CAS   0 cost: 42 ms
//如上代码加锁会造成线程堵塞，堵塞的时间取决于临界区代码执行的时间，这使用加锁的性能不高，我们可以使用无锁来解决此问题。
class AccountCas implements Account{

    private AtomicInteger balance ;

    public AccountCas(Integer balance){
        this.balance =  new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        // 核心代码
        while (true){
            int pre = getBalance();
            int next = pre - amount;
            if (balance.compareAndSet(pre,next)){
                break;
            }
        }
    }
}




interface Account {

    // 获取金额的方法
    Integer getBalance();

    // 取款的方法
    void withdraw(Integer amount);


    // 此外，接口还定义了一个静态方法demo(Account account)。这个方法接受一个Account类型的参数account，并在方法内部进行了一些操作。
    // 具体来说，它创建了一个包含1000个线程的List集合，并通过循环将每个线程添加到集合中。
    // 每个线程的执行内容是调用account对象的withdraw(10)方法，即每个线程都会从账户中取款10元。
    // 然后，使用forEach方法依次启动每个线程，使用forEach方法和join方法等待所有线程执行完毕。

    // 最后，它记录了整个过程的开始时间和结束时间，并输出账户余额和执行过程的耗时（以毫秒为单位）。
    // 总的来说，这段代码是通过多线程模拟对账户进行并发取款操作，并计算整个操作的耗时。

    static void demo(Account account) {
        List<Thread> list = new ArrayList<>();
        long start = System.nanoTime();
        for(int i = 0; i < 1000; i++) {
            list.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        list.forEach(Thread::start);

        list.forEach(t -> {
            try {t.join();}
            catch (InterruptedException e) {e.printStackTrace();}
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance() + " cost: " + (end-start)/1000_000 + " ms");
    }
}





