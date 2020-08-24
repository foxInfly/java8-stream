package com.pupu.demo02.Optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8Tester {
   public static void main(String args[]){
   


      ArrayList<String> list = new ArrayList<>();
      list.add("张无忌");
      list.add("周芷若");
      list.add("赵敏");
      list.add("张强");
      list.add("张三丰");

      Integer value1 = null;
      Integer value2 = new Integer(10);

      //返回空的 Optional 实例。
      Optional<Object> empty = Optional.empty();
      // 此方式不可为null
      Optional<String> optionalStr = Optional.of("Hello Optional.isPresent");
      // 此方式不可为null,是null 会报空指针
//      Optional<String> optionalNul = Optional.of(null);
      // 此方式不可为null
      Optional<List<String>> optionalListStr = Optional.of(list);
      // 此方式可以为null
      Optional<Object> optional1 = Optional.ofNullable(null);
      System.out.println("optionalStr:"+optionalStr);
//      System.out.println("optionalNul:"+optionalNul);
      System.out.println("optionalListStr:"+optionalListStr);
      System.out.println("optional1:"+optional1);

      testIsPresent(optionalStr);
      testIfPresent(Optional.of("Hello Optional.ifPresent"));

      testOrElse(Optional.of("Hello Optional.orElse"));
      testOrElse(Optional.ofNullable(null));

      testOrElseGet(Optional.ofNullable(null));

//      testOrElseThrow(Optional.ofNullable(null));

      testMap(Optional.of("Hello Optional.map"));
      testMap(Optional.ofNullable(null));
      testMapList(Optional.ofNullable(list));

      testFilter(Optional.of("Hello Optional.filter"));
      testFilter(Optional.ofNullable(null));


   }
    

   private static void testIsPresent(Optional<String> optional){
      if (optional.isPresent()) {
         System.out.println("testIsPresent:"+optional.get());
      }
   }

   private static void testIfPresent(Optional<String> optional){
      optional.ifPresent(System.out::println);
   }

   private static void testOrElse(Optional<String> optional){
      String s = optional.orElse("你不存在呀");
      System.out.println(s);
   }

   private static void testOrElseGet(Optional<String> optional){
      String s = optional.orElseGet(Java8Tester::getName);
      System.out.println(s);
   }

   private static String getName(){
      return "pupu";
   }


 /*  private static void testOrElseThrow(Optional<String> optional){
      String s = optional.orElseThrow(()->{throw new RuntimeException("xxx不存在");});
   }*/


   private static void testMap(Optional<String> optional){
      Optional<String> s = optional.map((a) -> {return a.toLowerCase();});
      System.out.println(s.orElse("No value found"));
   }

   private static void testMapList(Optional<List<String>> optional){
      Optional<List<String>> s1 = optional.map((a) -> {
         a.add("sss");
         return a;
      });
      System.out.println("lst;;;;"+s1.orElse(null));
   }


   private static void testFilter(Optional<String> optional){
      Optional<String> s = optional.filter(a -> a.length()>9);
      System.out.println(s.orElse("empty"));
   }

   private static void testFilterList(Optional<List<String>> optional){
      Optional<List<String>> s = optional.filter(a -> {
         return a.size()>9;
      });
      System.out.println(s.orElse(null));
   }

}