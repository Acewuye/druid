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
package com.alibaba.druid.wall.spi;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.dialect.gaussdb.parser.GaussDbStatementParser;
import com.alibaba.druid.sql.dialect.postgresql.visitor.PGExportParameterVisitor;
import com.alibaba.druid.sql.parser.SQLParserFeature;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.ExportParameterVisitor;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallProvider;
import com.alibaba.druid.wall.WallVisitor;

/**
 * @author Acewuye
 *
 * Notes: Original code of this class based on com.alibaba.druid.wall.spi.PGWallProvider
 */
public class GaussDBWallProvider extends WallProvider {
    public static final String DEFAULT_CONFIG_DIR = "META-INF/druid/wall/gaussdb";

    public GaussDBWallProvider() {
        this(new WallConfig(DEFAULT_CONFIG_DIR));
    }

    public GaussDBWallProvider(WallConfig config) {
        super(config, DbType.gaussdb);
    }

    @Override
    public SQLStatementParser createParser(String sql) {
        return new GaussDbStatementParser(sql, SQLParserFeature.EnableSQLBinaryOpExprGroup);
    }

    @Override
    public WallVisitor createWallVisitor() {
        return new GaussDBWallVisitor(this);
    }

    @Override
    public ExportParameterVisitor createExportParameterVisitor() {
        return new PGExportParameterVisitor();
    }

}
