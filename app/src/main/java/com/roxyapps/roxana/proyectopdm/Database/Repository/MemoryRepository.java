package com.roxyapps.roxana.proyectopdm.Database.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.roxyapps.roxana.proyectopdm.Database.Dao.MemoryDao;
import com.roxyapps.roxana.proyectopdm.Database.Entities.Memory;
import com.roxyapps.roxana.proyectopdm.Database.RoomDb;

import java.util.List;

public class MemoryRepository {
    private MemoryDao memoryDao;
    private LiveData<List<Memory>> obtenerImagnenes;

    public MemoryRepository(Application application) {
        RoomDb db = RoomDb.getDatabase(application);
        memoryDao = db.memoryDao();
        obtenerImagnenes = memoryDao.getAll();
    }

    public LiveData<List<Memory>> getAll() {
        return obtenerImagnenes;
    }

    public void insert(Memory memory) {
        new insertAsyncTask(memoryDao).execute(memory);
    }

    private static class insertAsyncTask extends AsyncTask<Memory, Void, Void> {

        private MemoryDao mAsyncTaskDao;

        insertAsyncTask(MemoryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Memory... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
