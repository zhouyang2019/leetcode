package com.zy.backtracking;

import org.junit.Test;

public class PartitionTest {

    Partition obj = new Partition();

    @Test
    public void partition() {
        System.out.println(obj.partition("aab"));
        System.out.println(obj.partition("a"));
        System.out.println(obj.partition("ababab"));
    }

    @Test
    public void restoreIpAddresses() {
        System.out.println(obj.restoreIpAddresses("25525511135"));
        System.out.println(obj.restoreIpAddresses("0000"));
        System.out.println(obj.restoreIpAddresses("1111"));
        System.out.println(obj.restoreIpAddresses("010010"));
        System.out.println(obj.restoreIpAddresses("111111111111111111111111111111111111111111")); // 注意剪枝处理，避免处理超时
    }
}