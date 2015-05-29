package com.collections

import com.google.common.collect.*
import groovy.lang.Range
import sun.security.provider.certpath.Vertex

/**
 * Created by yonney.yang on 2015/5/29.
 */
//使用不可变集合
ImmutableSet<String> foo = ImmutableSet.copyOf("1", "2", "3");
ImmutableSet.of("a", 1, "b", 2);
/*ImmutableSet<Color> GOOGLE_COLORS =
        ImmutableSet.<Color>builder().addAll(WEBSAFE_COLORS).add(new Color(0, 191, 255)).build();

assert ImmutableSortedSet.of("a", "b", "c", "a", "d", "b") == ["a","b","c","d"]*/

//新集合类型
//##MultiSet 没有元素顺序限制的ArrayList<E>  Map<E, Integer>，键为元素，值为计数
//统计单词出现的次数
List<String> words = Lists.newArrayList("a", "b", "c", "a", "a")
Map<String, Integer> counts = new HashMap<String, Integer>();
for (String word : words) {
    Integer count = counts.get(word);
    if (count == null) {
        counts.put(word, 1);
    } else {
        counts.put(word, count + 1);
    }
}
println counts

Multiset<String> multiset = HashMultiset.create();
multiset.addAll(Lists.newArrayList("a", "b", "c", "a", "a"));
println "a count:" + multiset.count("a");
println "elementSet:" + multiset.elementSet()
println "entrySet:" + multiset.entrySet()
println "size:" + multiset.size()
multiset.setCount("b", 0)  //移除b
println "entrySet:" + multiset.entrySet()

//##
HashMultiset
TreeMultiset
LinkedHashMultiset
ConcurrentHashMultiset
ImmutableMultiset
SortedMultiset

//##Multimap  一个键映射到多个值
//a -> [1, 2, 4] b -> 3 c -> 5
Map<String, List<Integer>> map = new HashMap<String, List<Integer>>()
Multimap<String, List<Integer>> multimap = ArrayListMultimap.create();
multimap.put("test1", Lists.newArrayList())
multimap.put("test2", Lists.newArrayList(1, 2, 3))
println multimap.asMap()
println multimap.keySet()

//##BiMap
//双向映射
BiMap<String, Integer> userId = HashBiMap.create();
userId.put("1", 100);
userId.put("2", 200);
//userId.put("3",200);
//BiMap.forcePut("3",200)
println userId.inverse()

//##Table
Table<Vertex, Vertex, Double> weightedGraph = HashBasedTable.create();
//weightedGraph.put(v1, v2, 4);

//##ClassToInstanceMap 键是类型，而值是符合键所指类型的对象
ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
println numberDefaults;

//## RangeSet  不相连的、非空的区间
RangeSet<Integer> rangeSet = TreeRangeSet.create();
rangeSet.add(Range.closed(1, 10)); // {[1,10]}
rangeSet.add(Range.closedOpen(11, 15));//不相连区间:{[1,10], [11,15)}
rangeSet.add(Range.closedOpen(15, 20)); //相连区间; {[1,10], [11,20)}
rangeSet.add(Range.openClosed(0, 0)); //空区间; {[1,10], [11,20)}
rangeSet.remove(Range.open(5, 10)); //分割[1, 10]; {[1,5], [10,10], [11,20)}

//##RangeMap 不相交的、非空的区间
RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}





























