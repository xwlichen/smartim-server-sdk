package com.smart.im.server.sdk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
//    static  String regex1="((\\[\\d\\d:\\d\\d\\.\\d\\d\\])+)(.+)";


    static String regex = "(<p:>\\[+)(\\d{4,7}+)(,+)(\\d{4,7}+)(\\]+)(.+)<:p>";


    static Pattern patternLrc = Pattern.compile(regex);


    public static void main(String[] args) {

//        regex = "<p:>([\\s\\S]*?)<:p>";
        regex="<p:>([^<]*)<:p>";
        patternLrc = Pattern.compile(regex);

        String text = "<p:>[3000,2000]你姓什么？ 我姓李。<:p>";
        text = "<p:>[3000,2000]你姓什么？ 我姓李。<:p><p:>[5500,2000]什么李？ 木子李。<:p><p:>[8000,2500]他姓什么？ 他姓张。<:p><p:>[11000,2000]什么张？ 弓长张。<:p><p:>[14000,2000]古月胡， 口天吴，<:p><p:>[17000,2000]双人徐， 言午许。<:p><p:>[20000,2000]中国姓氏有很多，<:p><p:>[22000,2000]赵、钱、孙、李，<:p><p:>[24000,2000]周、吴、郑、王，<:p><p:>[26000,2000]诸葛、东方，<:p><p:>[28000,2000]上官、欧阳……<:p>";
        Matcher matcher = patternLrc.matcher(text);
        if (!matcher.matches()) {
            System.out.println("no matcher");

        }

        while(matcher.find()) {
            System.out.println(matcher.group(1));
        }

//        while (matcher.find()){
//        String text0 = matcher.group(2);
//        String text1 = matcher.group(4);
//        String text2 = matcher.group(6);
//
//        String text3 = matcher.group(0);
//        System.out.println(text0);
//        System.out.println(text1);
//        System.out.println(text2);
//        System.out.println(text3);

//        }

//        boolean rs = matcher.find();
//        while (matcher.find()) {
//        for (int i = 0; i < matcher.groupCount(); i++) {
//            String text1 = matcher.group(i);
//            System.out.println(text1);
//        }

//        }



        String  str = "<a href=\" ,5094.1\"> weblogic日志编码大全 </a>";
        Pattern p = Pattern.compile("<a[^>]*>([^<]*)</a>");
        Matcher m = p.matcher(str);
        while(m.find()) {
            System.out.println(m.group(1));
        }


    }
}
