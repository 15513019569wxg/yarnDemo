package com.wxg.yarn;/*
    @author wxg
    @date 2021/5/31-0:42
    */
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import java.util.Arrays;

public class WordCountDriver {
    //这里的数组包含集群命令中全类名之后的参数: wordcount、指定的队列、输入路径和输出路径
    public static void main(String[] args) throws Exception {
        // 1. 创建配置文件
        Configuration conf = new Configuration();
        // 2. 判断是否有tool 接口
        Tool tool;
        if ("wordcount".equals(args[0])) tool = new WordCount();
        else throw new RuntimeException("no such tool" + args[0]);
        // 3. 用 Tool 执行程序
        // Arrays.copyOfRange 将老数组的元素放到新数组里面
        /*
            这里会调用手写的WordCount类，启用WordCound的run(),此时传递的数组参数包含三个（指定队列、输入路径、输出路径）；
            由于为了保证输入路径和输出路径的正确性，必须传递后两个参数，此时可以使用Arrays.copyOfRange(args, 1, args.length)方法解决。
         */
        int run = ToolRunner.run(conf, tool, Arrays.copyOfRange(args, 1, args.length));
        System.exit(run);

    }
}
