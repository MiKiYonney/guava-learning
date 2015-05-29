package com.collections

import com.google.common.base.Function
import com.google.common.base.Strings
import com.google.common.base.Supplier
import com.google.common.collect.*
import com.google.common.primitives.Ints

/**
 * Created by yonney.yang on 2015/5/29.
 */
//java.util.Collections中未包含的集合工具
//## Collections2
//## Lists
List<Integer> exactly100 = Lists.newArrayListWithCapacity(100);

//## Iterables
Iterable<Integer> concatenated = Iterables.concat(Ints.asList(1, 2, 3), Ints.asList(4, 5, 6))
println concatenated
println Iterables.getLast(concatenated)
//println Iterables.getOnlyElement(concatenated)

//##FluentIterable  把自己拷贝到不可变集合
//##Lists
List countUp = Ints.asList(1, 2, 3, 4, 5);
println countUp
List countDown = Lists.reverse(countUp);
println countDown
List<List> parts = Lists.partition(countUp, 2)
println parts

//##sets
Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
Sets.SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength);
Set<String> immutableCopy = intersection.immutableCopy();
//intersection.add("eight")
println intersection
println immutableCopy

Set<String> animals = ImmutableSet.of("gerbil", "hamster");
Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");
Set<List<String>> product = Sets.cartesianProduct(animals, fruits); //笛卡尔
println product  //[[gerbil, apple], [gerbil, orange], [gerbil, banana], [hamster, apple], [hamster, orange], [hamster, banana]]
Set<Set<String>> animalSets = Sets.powerSet(animals); //所有子集
println animalSets //[[], [gerbil], [hamster], [gerbil, hamster]]

//##Maps
List<String> strList = Lists.newArrayList("a","bb","ooo");
ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(strList,
        new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        });
println stringsByIndex;

Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 4, "c", 3);
MapDifference<String, Integer> diff = Maps.difference(left, right);
println diff
println diff.entriesInCommon();
println diff.entriesOnlyOnLeft();
println diff.entriesOnlyOnRight();

//##Multisets
//##Multimaps
ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
Function<String, Integer> lengthFunction = new Function<String, Integer>() {
    public Integer apply(String string) {
        return string.length();
    }
};
ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
println digitsByLength;

ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
multimap.putAll("b", Ints.asList(2, 4, 6));
multimap.putAll("a", Ints.asList(4, 2, 1));
multimap.putAll("c", Ints.asList(2, 5, 3));
//TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap<String, Integer>a.create());

//##Tables
Table<String, Character, Integer> table = Tables.newCustomTable(
    Maps<String, Map<Character, Integer>>newLinkedHashMap(),
    new Supplier<Map<Character, Integer>>() {
        public Map<Character, Integer> get() {
            return Maps.newLinkedHashMap();
        }
    });
println table;









