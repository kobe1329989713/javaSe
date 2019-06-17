package com.jdk8.io.nio2;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by kobe on 2019/6/17.19:38
 *
 * @author kobe
 * <br/>
 * Description:
 * 如：百度网盘：你在共享目录下创建了一个 文件，它马上就上传到云端去了。这个就是监视的作用。
 */
public class WatchDemo {
    public static void main(String[] args) throws Exception {
        String path = "D:\\kobe\\xx\\watch";
        WatchService ws = FileSystems.getDefault().newWatchService();
        Path p = Paths.get(path);
        // 你在 path 这个路径下 增删改，它都能监控到。从而执行什么操作。
        // 那些事件，如：你增加了一个文件，你删除了一个文件，修改,这些都是事件，
        // 都需要注册。它是枚举。
        WatchKey k = p.register(
                ws,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
        );
        while (true) {
            WatchKey key = ws.take();
            for (WatchEvent<?> e : key.pollEvents()) {
                // king 是事件的一个类型。
                WatchEvent.Kind<?> kind = e.kind();
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
                // 当前发生的事件。
                WatchEvent<Path> currEvent = (WatchEvent<Path>) e;
                Path path1 = currEvent.context();
                System.out.println(path1+"发生："+kind);
            }
            key.reset();
        }
        //ws.close();
    }
}
