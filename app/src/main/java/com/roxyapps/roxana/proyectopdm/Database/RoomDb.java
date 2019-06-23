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
import com.roxyapps.roxana.proyectopdm.Database.Dao.WordsDao;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Player;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Memory;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Words;
import com.roxyapps.roxana.proyectopdm.R;

import javax.xml.parsers.SAXParser;

@Database(entities = {Player.class, Memory.class, Words.class}, version = 4)
public abstract class RoomDb extends RoomDatabase {
    public abstract PlayerDao playerDao();
    public abstract MemoryDao memoryDao();
    public abstract WordsDao wordsDao();

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
            new PopAsync2(INSTANCE).execute();
        }
    };

    private static class PopAsync extends AsyncTask<Void, Void, Void> {

        private final MemoryDao memoryDao;

        PopAsync(RoomDb db) {
            memoryDao = db.memoryDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

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

    private static class PopAsync2 extends AsyncTask<Void, Void, Void> {

        private final WordsDao wordsDao;

        PopAsync2(RoomDb db) {
            wordsDao = db.wordsDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            Words words = new Words(1,R.drawable.apple_icon,"SA","ZA","CA","MANZANA","MAN__NA","ZA");
            wordsDao.insert(words);
            words = new Words(2,R.drawable.avocado_icon,"KA","QA","CA","AGUACATE","AGUA__TE","CA");
            wordsDao.insert(words);
            words = new Words(3,R.drawable.banana_icon,"VA","BA","DA","BANANA","__NANA","BA");
            wordsDao.insert(words);
            words = new Words(4,R.drawable.blueberry_icon,"RAN","RÁN","RÁM","ARÁNDANOS","A___DANOS","RÁN");
            wordsDao.insert(words);
            words = new Words(5,R.drawable.broccoli_icon,"BRO","VRO","BRÓ","BRÓCOLI","___COLI","BRÓ");
            wordsDao.insert(words);
            words = new Words(6,R.drawable.carrot_icon,"HO","O","OH","ZANAHORIA","ZANA__RIA","HO");
            wordsDao.insert(words);
            words = new Words(7,R.drawable.cherry_icon,"SE","CE","ZE","CEREZA","__REZA","CE");
            wordsDao.insert(words);
            words = new Words(8,R.drawable.corn_icon,"HE","EE","E","ELOTE","_LOTE","E");
            wordsDao.insert(words);
            words = new Words(9,R.drawable.grape_icon,"SAV","BAS","VAS","UVAS","U___","VAS");
            wordsDao.insert(words);
            words = new Words(10,R.drawable.lemon_icon,"MÓN","NON","MON","LIMÓN","LI___","MÓN");
            wordsDao.insert(words);
            words = new Words(11,R.drawable.letucce_icon,"SHEU","SHU","CHU","LECHUGA","LE___GA","CHU");
            wordsDao.insert(words);
            words = new Words(12,R.drawable.mango_icon,"MA","NAN","MAN","MANGO","___GO","MAN");
            wordsDao.insert(words);
            words = new Words(13,R.drawable.mushroom_icon,"HON","ON","HOM","HONGOS","___GOS","HON");
            wordsDao.insert(words);
            words = new Words(14,R.drawable.orange_icon,"NA","RAN","RRAN","NARANJA","__RANJA","NA");
            wordsDao.insert(words);
            words = new Words(15,R.drawable.watermelon_icon,"BI","DÍ","DI","SANDÍA","SAN__A","DÍ");
            wordsDao.insert(words);
            words = new Words(16,R.drawable.tomato_icon,"TO","TOU","TE","TOMATE","__MATE","TO");
            wordsDao.insert(words);
            words = new Words(17,R.drawable.strawberry_icon,"SOS","SAS","ZAZ","FRESAS","FRE___","SAS");
            wordsDao.insert(words);
            words = new Words(18,R.drawable.potato_icon,"PA","PÁ","PAA","PAPA","PA__","PA");
            wordsDao.insert(words);
            words = new Words(19,R.drawable.pineapple_icon,"NA","NAN","ÑA","PIÑA","PI__","ÑA");
            wordsDao.insert(words);
            return null;
        }
    }
}
