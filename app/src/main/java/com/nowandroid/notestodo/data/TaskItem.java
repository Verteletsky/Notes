package com.nowandroid.notestodo.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Project: NotesToDo
 * Created: Vendetta
 * Date: 10.08.2016
 */
@DatabaseTable
public class TaskItem {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String message;

    @DatabaseField
    private int done;

}
