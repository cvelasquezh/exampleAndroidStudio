package com.example.teclalabs.myapplication.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by teclalabs on 29/12/14.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private Dao<Contacto,Integer> contactoDao = null;
    private RuntimeExceptionDao<Contacto , Integer> contactoRuntimeDao = null;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agenda.db";

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(DataBaseHelper.class.getSimpleName(),"oncreate()");
            TableUtils.createTable(connectionSource,Contacto.class);
        } catch (SQLException ex) {
            Log.e(DataBaseHelper.class.getSimpleName(), "imposible crear la base de datos", ex);
            throw new RuntimeException(ex);
        }
    }



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        // TODO
    }

    public Dao<Contacto, Integer> getContactoDao() throws SQLException {

        if(contactoDao == null)contactoDao = getDao(Contacto.class);
        return contactoDao;
    }

    public RuntimeExceptionDao<Contacto, Integer> getContactoRuntimeDao() {
        if (contactoRuntimeDao == null) contactoRuntimeDao = getRuntimeExceptionDao(Contacto.class);
        return contactoRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        contactoDao = null;
        contactoRuntimeDao = null;
    }
}
