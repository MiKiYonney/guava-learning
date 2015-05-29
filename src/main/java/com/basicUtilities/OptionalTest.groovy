package com.basicUtilities

import com.google.common.base.Objects
import com.google.common.base.Optional

/**
 * Created by yonney.yang on 2015/5/26.
 */
//使用和避免null
Optional<Integer> possible = Optional.of(null);
possible.isPresent();
possible.get();
possible.or(5);
//处理null
Objects.firstNonNull(2,null);
Optional.of(2).or(3);


public static void main(String[] args) {

}