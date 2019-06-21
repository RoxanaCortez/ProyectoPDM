package com.roxyapps.roxana.proyectopdm.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.roxyapps.roxana.proyectopdm.Database.Dao.PlayerDao;
import com.roxyapps.roxana.proyectopdm.Database.Dao.MemoryDao;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Player;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Memory;
import com.roxyapps.roxana.proyectopdm.R;

@Database(entities = {Player.class, Memory.class}, version = 1)
public abstract class RoomDb extends RoomDatabase {
    public abstract PlayerDao playerDao();
    public abstract MemoryDao memoryDao();

    private static volatile RoomDb INSTANCE;

    public static RoomDb getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RoomDb.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDb.class, "jugador_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(Callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback Callback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopAsync(INSTANCE).execute();
        }
    };

    private static class PopAsync extends AsyncTask<Void, Void, Void> {

        private final MemoryDao memoryDao;

        PopAsync(RoomDb db) {
            memoryDao = db.memoryDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //memoryDao.deleteAll();

            Memory memory = new Memory(1, R.drawable.fish_icon);
            memoryDao.insert(memory);
            memory = new Memory(2, R.drawable.dog_icon);
            memoryDao.insert(memory);
            memory = new Memory(3, R.drawable.flamingo_icon);
            memoryDao.insert(memory);
            memory = new Memory(4, R.drawable.cat_icon);
            memoryDao.insert(memory);
            memory = new Memory(5, R.drawable.gorilla_icon);
            memoryDao.insert(memory);
            memory = new Memory(6, R.drawable.snail_icon);
            memoryDao.insert(memory);
            memory = new Memory(7, R.drawable.snake_icon);
            memoryDao.insert(memory);
            memory = new Memory(8, R.drawable.guacamaya_icon);
            memoryDao.insert(memory);
            memory = new Memory(9, R.drawable.elephant_icon);
            memoryDao.insert(memory);
            memory = new Memory(10,R.drawable.panda_icon);
            memoryDao.insert(memory);
            memory = new Memory(11, R.drawable.jaguar_icon);
            memoryDao.insert(memory);
            memory = new Memory(12, R.drawable.pig_icon);
            memoryDao.insert(memory);
            memory = new Memory(13, R.drawable.hippo_icon);
            memoryDao.insert(memory);
            memory = new Memory(14, R.drawable.monkey_icon);
            memoryDao.insert(memory);
            memory = new Memory(15, R.drawable.lion_icon);
            memoryDao.insert(memory);
            memory = new Memory(16, R.drawable.frog_icon);
            memoryDao.insert(memory);
            return null;
        }
    }
}
