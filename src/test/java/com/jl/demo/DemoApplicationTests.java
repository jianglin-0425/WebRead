package com.jl.demo;

import org.junit.jupiter.api.Test;

class DemoApplicationTests {

    @Test
    void contextLoads() {
       String time="2021-01-03 14:36:48";
       String[] times=time.split(" ");
       String[] datas=times[0].split("-");
        System.out.println(datas[1]+"-"+datas[2]);
        System.out.println();
    }

}
