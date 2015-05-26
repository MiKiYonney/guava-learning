package com.basicUtilities

import com.google.common.base.Preconditions

/**
 * Created by yonney.yang on 2015/5/26.
 */
//前置条件
def i = 0;
def j = 1;
Preconditions.checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
Preconditions.checkArgument(i < j, "Expected i < j, but %s > %s", i, j);
Preconditions.checkNotNull(1, "is null");
Preconditions.checkState(i != 1);
Preconditions.checkElementIndex(1,2);
Preconditions.checkPositionIndexes(1,2,3)
