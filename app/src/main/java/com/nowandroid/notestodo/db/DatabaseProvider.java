package com.nowandroid.notestodo.db;

import android.content.Context;

import java.util.Collection;
import java.util.Observer;

/**
 * Project: NotesToDo
 * Created: Vendetta
 * Date: 10.08.2016
 */

public interface DatabaseProvider<ITEM_TYPE, ID_TYPE> {

    void init(Context context, int version);

    void addObject(ITEM_TYPE object);

    void deleteObject(ID_TYPE id);

    void addList(Collection<ITEM_TYPE> collection);

    int count();

    ITEM_TYPE getItem(ID_TYPE id);

    Collection<ITEM_TYPE> getAll();

    void addObserver(Observer observer);

}
