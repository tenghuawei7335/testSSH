package cn.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * @PROJECT_NAME: TenghwSSMDemo
 * @PACKAGE_NAME: cn.zookeeper
 * @ClassName: WatchTest
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/6/1 0001 14:42
 * @Day: 星期一
 */
//继承这个接口Watcher，当zookeeper节点或者节点里数据有变化时，会调用；
public class WatchTest implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
       /**节点或者数据没改变时，输出这个：
        * ========================
        path:null
        type:None
        state:SyncConnected*/
        System.out.println("========================");
        System.out.println("path:"+watchedEvent.getPath());
        System.out.println("type:"+watchedEvent.getType());
        System.out.println("state:"+watchedEvent.getState());
    }

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        //创建一个Zookeeper实例，第一个参数为目标服务器地址和端口，第二个参数为Session超时时间，第三个为节点变化时的回调方法
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183", 30000, new WatchTest());

        String node = "/node2";
        String node1 = "/nodethw";
        String node2 = "/thw";
        //判断该根节点是否已存在？初始化根节点，有就别创建，没有就创建，仅限根节点！
        Stat stat = zk.exists(node, false);
        Stat stat1 = zk.exists(node1, false);
        Stat stat2 = zk.exists(node2, false);

        if( stat==null){
            //创建一个节点，数据为test,不进行ACL权限控制，节点为永久性的
            String createNode = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createNode);//打印的是根节点，eg:/node2
        }

        if(stat1==null){
            String createNode1 = zk.create(node1, "坂井泉水".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createNode1);
        }

        if(stat2==null){
            String createNode1 = zk.create(node2, "sakai izumi ".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createNode1);
        }

        //取得/node2节点下的数据,返回byte[]
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        //取得/nodethw节点下的数据,返回byte[]
        byte[] b1 = zk.getData(node1, false, stat1);
        System.out.println(new String(b1));
        //取得/thw节点下的数据,返回byte[]
        byte[] b2 = zk.getData(node2, false, stat2);
        System.out.println(new String(b2));
        List<String> children = zk.getChildren("/", false);
        System.out.println(children);

        //在zookeeper节点下创建一个"provider"临时节点，连接断开是，临时节点消除--非根节点，不用加stat==null判断，直接创建！
        String provider = zk.create("/zookeeper/procider", "127.0.0.1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("provider==="+provider);//provider===/zookeeper/procider

        zk.close();
    }
}
