package com.kun.interfaceDemo2;

public class Test {
    public static void main(String[] args) {
        PingPangSporter ps = new PingPangSporter("小明", 12);
        PingPangTeacher pt = new PingPangTeacher("老明", 40);
        BaseketBallSporter bs = new BaseketBallSporter("小华", 13);
        BaseketBallTeacher bt = new BaseketBallTeacher("老华", 50);
        ps.study();
        ps.english();
        bt.teach();
    }
}
