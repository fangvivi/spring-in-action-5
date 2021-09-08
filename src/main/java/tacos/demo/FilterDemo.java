package tacos.demo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterDemo {
    private String name;
    private CharType type;

    public FilterDemo(String name, CharType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharType getType() {
        return type;
    }

    public void setType(CharType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FilterDemo{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    public static enum CharType {
        A, B, C, D, E;
    }

    public static void main(String[] args) {
        List<FilterDemo> demos = new ArrayList<>();
        demos.add(new FilterDemo("张三",FilterDemo.CharType.A));
        demos.add(new FilterDemo("王重阳",FilterDemo.CharType.E));
        demos.add(new FilterDemo("李四",FilterDemo.CharType.B));
        demos.add(new FilterDemo("王五",FilterDemo.CharType.C));
        demos.add(new FilterDemo("赵六",FilterDemo.CharType.D));
        demos.add(new FilterDemo("杜甫",FilterDemo.CharType.B));
        demos.add(new FilterDemo("马克",FilterDemo.CharType.C));

        Map<String, List<FilterDemo>> map = new HashMap<>();
        CharType[] values = CharType.values();
        for (CharType type : values) {
            map.put(type.toString(), demoFilter(demos,type));
        }
        Set<Map.Entry<String, List<FilterDemo>>> entries = map.entrySet();
        Iterator<Map.Entry<String, List<FilterDemo>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<FilterDemo>> next = iterator.next();
            System.out.println(next.getKey() +" : " +next.getValue());
        }

    }

    public static List<FilterDemo> demoFilter(List<FilterDemo> list, CharType type){
        Stream<FilterDemo> filterDemoStream = list.stream().filter(new Predicate<FilterDemo>() {
            @Override
            public boolean test(FilterDemo filterDemo) {
                return filterDemo.getType().equals(type);
            }
        });
        List<FilterDemo> collect = filterDemoStream.collect(Collectors.toList());
        return collect;
        // return list.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
