package com.example.notesapp.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.notesapp.model.Notes;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NotesDao_Impl implements NotesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Notes> __insertionAdapterOfNotes;

  private final EntityDeletionOrUpdateAdapter<Notes> __deletionAdapterOfNotes;

  private final EntityDeletionOrUpdateAdapter<Notes> __updateAdapterOfNotes;

  public NotesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotes = new EntityInsertionAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `notes-table` (`id`,`noteTitle`,`noteContent`,`noteTimeStamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        stmt.bindLong(1, value.getId());
        if (value.getNoteTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNoteTitle());
        }
        if (value.getNoteContent() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNoteContent());
        }
        if (value.getNoteTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNoteTimeStamp());
        }
      }
    };
    this.__deletionAdapterOfNotes = new EntityDeletionOrUpdateAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `notes-table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfNotes = new EntityDeletionOrUpdateAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `notes-table` SET `id` = ?,`noteTitle` = ?,`noteContent` = ?,`noteTimeStamp` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        stmt.bindLong(1, value.getId());
        if (value.getNoteTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNoteTitle());
        }
        if (value.getNoteContent() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNoteContent());
        }
        if (value.getNoteTimeStamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNoteTimeStamp());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object insert(final Notes note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNotes.insert(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Notes note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNotes.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Notes note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNotes.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Notes>> retrieveAllNotes() {
    final String _sql = "Select * from `notes-table`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"notes-table"}, false, new Callable<List<Notes>>() {
      @Override
      public List<Notes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNoteTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "noteTitle");
          final int _cursorIndexOfNoteContent = CursorUtil.getColumnIndexOrThrow(_cursor, "noteContent");
          final int _cursorIndexOfNoteTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "noteTimeStamp");
          final List<Notes> _result = new ArrayList<Notes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Notes _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNoteTitle;
            if (_cursor.isNull(_cursorIndexOfNoteTitle)) {
              _tmpNoteTitle = null;
            } else {
              _tmpNoteTitle = _cursor.getString(_cursorIndexOfNoteTitle);
            }
            final String _tmpNoteContent;
            if (_cursor.isNull(_cursorIndexOfNoteContent)) {
              _tmpNoteContent = null;
            } else {
              _tmpNoteContent = _cursor.getString(_cursorIndexOfNoteContent);
            }
            final String _tmpNoteTimeStamp;
            if (_cursor.isNull(_cursorIndexOfNoteTimeStamp)) {
              _tmpNoteTimeStamp = null;
            } else {
              _tmpNoteTimeStamp = _cursor.getString(_cursorIndexOfNoteTimeStamp);
            }
            _item = new Notes(_tmpId,_tmpNoteTitle,_tmpNoteContent,_tmpNoteTimeStamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
