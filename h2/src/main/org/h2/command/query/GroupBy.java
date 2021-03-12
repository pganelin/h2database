/*
 * Copyright 2004-2021 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (https://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.command.query;

import org.h2.expression.Expression;

/**
 * Describes one element of the GROUP BY clause of a query.
 */
public class GroupBy {

    /**
     * The order by expression.
     */
    public Expression expression;

    /**
     * The column index number (1 meaning the first column of the select list).
     */
    public Expression columnIndexExpr;

    public GroupBy() {
    }

    public GroupBy(Expression expression) {
        this.expression = expression;
    }

    /**
     * Appends the group by expression to the specified builder.
     *
     * @param builder the string builder
     * @param sqlFlags formatting flags
     */
    public void getUnenclosedSQL(StringBuilder builder, int sqlFlags) {
        (expression != null ? expression : columnIndexExpr).getUnenclosedSQL(builder, sqlFlags);
    }

}
