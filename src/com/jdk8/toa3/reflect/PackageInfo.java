package com.jdk8.toa3.reflect;

/**
 * Created by kobe on 2019/6/19.23:45
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class PackageInfo {
    public static void main(String[] args) {
        Package p = Package.getPackage("java.lang");
        System.out.println(p.getName());
        //p.getXxx()

        // 得到所有包。
        Package[] ps = Package.getPackages();
        for (Package p1 : ps) {
            System.out.println(p1.getName());
        }
    }
}
