package com.basicUtilities

import com.google.common.base.Throwables

import java.sql.SQLException

/**
 * Created by yonney.yang on 2015/5/26.
 */
try {
    1/0;
} catch (Throwable t) {
    Exception
    Error
    Throwables.propagateIfInstanceOf(t, IOException.class);
    Throwables.propagateIfInstanceOf(t, SQLException.class);
    println Throwables.getRootCause(t);
    println Throwables.getCausalChain(t)
    println Throwables.getStackTraceAsString(t);
    throw Throwables.propagate(t);
}
