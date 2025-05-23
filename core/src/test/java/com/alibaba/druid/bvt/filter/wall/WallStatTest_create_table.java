package com.alibaba.druid.bvt.filter.wall;

import com.alibaba.druid.wall.spi.*;
import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.wall.WallProvider;
import com.alibaba.druid.wall.WallTableStat;


public class WallStatTest_create_table extends TestCase {
    private String sql = "create table t (fid int, fname varchar(50))";

    public void testMySql() throws Exception {
        WallProvider provider = new MySqlWallProvider();
        provider.getConfig().setCreateTableAllow(true);

        Assert.assertTrue(provider.checkValid(sql));
        WallTableStat tableStat = provider.getTableStat("t");
        Assert.assertEquals(1, tableStat.getCreateCount());
    }

    public void testOracle() throws Exception {
        WallProvider provider = new OracleWallProvider();
        provider.getConfig().setCreateTableAllow(true);

        Assert.assertTrue(provider.checkValid(sql));
        WallTableStat tableStat = provider.getTableStat("t");
        Assert.assertEquals(1, tableStat.getCreateCount());
    }

    public void testPG() throws Exception {
        WallProvider provider = new PGWallProvider();
        provider.getConfig().setCreateTableAllow(true);

        Assert.assertTrue(provider.checkValid(sql));
        WallTableStat tableStat = provider.getTableStat("t");
        Assert.assertEquals(1, tableStat.getCreateCount());
    }

    public void testGaussDB() throws Exception {
        WallProvider provider = new GaussDBWallProvider();
        provider.getConfig().setCreateTableAllow(true);

        Assert.assertTrue(provider.checkValid(sql));
        WallTableStat tableStat = provider.getTableStat("t");
        Assert.assertEquals(1, tableStat.getCreateCount());
    }

    public void testSQLServer() throws Exception {
        WallProvider provider = new SQLServerWallProvider();
        provider.getConfig().setCreateTableAllow(true);

        Assert.assertTrue(provider.checkValid(sql));
        WallTableStat tableStat = provider.getTableStat("t");
        Assert.assertEquals(1, tableStat.getCreateCount());
    }

}
