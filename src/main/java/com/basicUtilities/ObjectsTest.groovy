package com.basicUtilities

import com.google.common.base.Objects
import com.google.common.collect.ComparisonChain
import com.google.common.collect.Ordering

/**
 * Created by yonney.yang on 2015/5/26.
 */

//常见Object方法
def x = 1;
def y = 2;
println Objects.equal("a", "a");
println Objects.equal(null, "a");
println Objects.equal(null, null);
//hashCode
println Objects.hashCode(x,y)
//tostring
println Objects.toStringHelper(this).add("x", 1).toString();

//compare/compareTo
public int compareTo(Foo that) {
    //Fluent接口风格
    return ComparisonChain.start()
            .compare(this.aString, that.aString)
            .compare(this.anInt, that.anInt)
            .compare(this.anEnum, that.anEnum, Ordering.natural().nullsLast())
}