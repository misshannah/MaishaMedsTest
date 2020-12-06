package com.hannah.testmeds.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

    @Database(entities = {PostsListTable.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {

        private static AppDatabase appDatabase;

        public abstract DaoAccess message();

        private Context context;

        private static final Object LOCK = new Object();
        public static AppDatabase getInstance(Context context) {
            if (appDatabase == null) {
                synchronized (LOCK) {
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "posts_db2")
                            .allowMainThreadQueries()
                            .build();
                }
            }

            return appDatabase;
        }


        public static void destroyInstance() {
            appDatabase = null;
        }
    }

