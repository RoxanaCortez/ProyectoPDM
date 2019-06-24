package com.roxyapps.roxana.proyectopdm.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.roxyapps.roxana.proyectopdm.Database.Dao.WordsDao;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Words;
import com.roxyapps.roxana.proyectopdm.Database.RoomDb;

import java.util.List;

public class WordsRepository {
    private WordsDao wordsDao;
    private LiveData<List<Words>> obtenerPalabras;

    public WordsRepository(Application application) {
        RoomDb db = RoomDb.getDatabase(application);
        wordsDao = db.wordsDao();
        obtenerPalabras = wordsDao.getAll();
    }

    public LiveData<List<Words>> getAll() {
        return obtenerPalabras;
    }

    public void insert(Words words) {
        new insertAsyncTask2(wordsDao).execute(words);
    }

    private static class insertAsyncTask2 extends AsyncTask<Words, Void, Void> {

        private WordsDao mAsyncTaskDao;

        insertAsyncTask2(WordsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Words... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
