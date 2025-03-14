/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.sql.ast.expr;

import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.druid.sql.ast.SQLDataTypeImpl;
import com.alibaba.druid.sql.visitor.SQLASTVisitor;

import java.util.Collections;
import java.util.List;

public final class SQLBooleanExpr extends SQLTypeExpr {
    public static final SQLDataType DATA_TYPE = new SQLDataTypeImpl(SQLDataType.Constants.BOOLEAN);

    private boolean value;

    public SQLBooleanExpr() {
        super(new SQLDataTypeImpl(SQLDataType.Constants.BOOLEAN));
    }

    public SQLBooleanExpr(boolean value) {
        this();
        this.value = value;
    }

    public boolean getBooleanValue() {
        return getValue();
    }

    public Boolean getValue() {
        return (Boolean) value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);

        visitor.endVisit(this);
    }

    public void output(StringBuilder buf) {
        buf.append(getValue() ? "true" : "false");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getValue() ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SQLBooleanExpr other = (SQLBooleanExpr) obj;
        if (value != other.value) {
            return false;
        }
        return true;
    }

    public SQLBooleanExpr clone() {
        return new SQLBooleanExpr(getValue());
    }

    @Override
    public List getChildren() {
        return Collections.emptyList();
    }

    public static enum Type {
        ON_OFF
    }
}
