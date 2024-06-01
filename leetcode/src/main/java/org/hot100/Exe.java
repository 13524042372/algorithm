package org.hot100;

import java.util.jar.JarOutputStream;

public class Exe {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++){
            sb.append("('王").append(i).append("','").append("高桥" + i).append("'),");
        }
        System.out.println(sb);

    }
}
