package com.universal.stream;

import com.universal.model.user.AppUser;
import io.netty.handler.codec.AsciiHeadersEncoder;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.springframework.security.core.userdetails.User;
import sun.misc.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    @org.junit.Test
    public void testList() {
        AppUser appUser = new AppUser();
        appUser.setPassword("wz");
        appUser.setNickname("aa");
        ArrayList<AppUser> users = new ArrayList<>();
        users.add(appUser);
        users.stream().onClose(() -> {
            System.out.println("close");
        }).count();
        Set<String> collect = users.stream().map(u -> u.getNickname()).collect(Collectors.toSet());
        System.out.println(collect);
        Map<String, List<AppUser>> collect1 = users.stream().collect(Collectors.groupingBy(u -> u.getNickname()));
        users.stream().map(u -> {
            AppUser appUser1 = new AppUser();
            if (appUser.getNickname().equals("aa")) {
                String change = "";
                change += "cc";

                appUser1.setNickname(change);
                return change;
            } else {
                return appUser1;
            }

        }).forEach(user->{
            System.out.println(user);
        });
    }

    @org.junit.Test
    public void testUser() {
        List<Integer> collect = Stream.of("1", "2", "3", "4").map(str -> Integer.parseInt(str)).collect(Collectors.toList());
        ConcurrentMap<String, String> collect1 = Stream.of("aa", "bb", "cc").collect(Collectors.toConcurrentMap(s -> s, s -> s + "dd"));
        String join = StringUtils.join(collect, ",");
        Integer integer = collect.stream().parallel().reduce((a, b) -> a + b).get();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(collect);
        lists.stream().flatMapToLong(s -> collect.stream().mapToLong(g -> g.longValue()));
        System.out.println(integer);

    }


    @org.junit.Test
    public void testIOUtils() {


    }


}
