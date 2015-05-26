package com.basicUtilities

import com.google.common.base.Function
import com.google.common.collect.Ordering
import com.google.common.primitives.Ints

/**
 * Created by yonney.yang on 2015/5/26.
 */
//排序: "流畅风格比较器”
Ordering<String> byLengthOrdering = new Ordering<String>() {
    @Override
    public int compare(String left, String right) {
        return Ints.compare(left.length(), right.length());
    }
}
Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo,String>() {
    @Override
    public String apply( Foo input) {
        return input.sortedBy;
    }
})

def str = "aqdewqeqww";
Ordering<String> stringOrdering = new Ordering<String>() {
    @Override
    int compare(String left, String right) {
        return str;
    }
}

Ordering.usingToString();