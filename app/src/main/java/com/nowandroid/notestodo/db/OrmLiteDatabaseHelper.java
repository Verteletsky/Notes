package com.nowandroid.notestodo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Project: NotesToDo
 * Created: Vendetta
 * Date: 10.08.2016
 */

public class OrmLiteDatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static String DATABASE_NAME = "database.db";

    private Class<?>[] mClass;

    public OrmLiteDatabaseHelper(Context context, int databaseVersion, Class<?>[] classes) {
        this(context, DATABASE_NAME, databaseVersion, classes);
    }

    public OrmLiteDatabaseHelper(Context context, String databaseName, int databaseVersion, Class<?>[] classes) {
        super(context, databaseName == null ? DATABASE_NAME : databaseName, null, databaseVersion);
        mClass = classes.clone();
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        for (Class<?> clazz : mClass) {
            try {
                TableUtils.createTable(connectionSource, clazz);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          ConnectionSource connectionSource,
                          int oldVersion,
                          int newVersion) {
        for (Class<?> clazz: mClass){
            try {
                TableUtils.dropTable(connectionSource, clazz, true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        onCreate(database, connectionSource);
    }

    /**
     * Удалить базу данных
     */
    public void dropDatabase() {
        for (Class<?> clazz: mClass){
            try {
                TableUtils.dropTable(getConnectionSource(), clazz, true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        onCreate(getWritableDatabase(), getConnectionSource());
    }
}
