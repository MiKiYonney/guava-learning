package com.collections

import com.google.common.collect.Iterables
import com.google.common.collect.Lists
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
println Iterables.getOnlyElement(concatenated)

//##FluentIterable  把自己拷贝到不可变集合


