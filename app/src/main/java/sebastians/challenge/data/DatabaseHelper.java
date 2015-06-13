package sebastians.challenge.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import sebastians.challenge.data.interfaces.TitleDescriptionColumns;

/**
 * Created by sebastian on 13/06/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String LOG_TAG = "DB";

    private SQLiteDatabase writableDatabase;
    private SQLiteDatabase readableDatabase;


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        writableDatabase = super.getWritableDatabase();
        readableDatabase = super.getReadableDatabase();

        //create tables:
        db.execSQL(Contract.SQL_CREATE_TABLE_CHALLENGES);


        this.createDefaultData();

    }

    /**
     * populate database with default Challenges etc.
     */
    private void createDefaultData(){
        ContentValues cv = new ContentValues();
        cv.put(Contract.ChallengeEntry.TITLE, "Smoothie Challenge");
        cv.put(Contract.ChallengeEntry.DESCRIPTION, "Smoothie Challenge <b>Description</b>");
        long id = writableDatabase.insert(Contract.ChallengeEntry.TABLE_NAME,null,cv);

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(Contract.SQL_DROP_TABLE_CHALLENGES);

    }




    private static class Contract {
        private static final String TYPE_TEXT = " TEXT ";
        private static final String TYPE_INTEGER = " INTEGER ";
        private static final String TYPE_FLOAT = " FLOAT ";
        private static final String COMMA_SEP = ",";
        private static final String DEFAULT = " DEFAULT ";
        private static final String NOT_NULL = " NOT NULL ";




        // Challenges


        protected static final String SQL_CREATE_TABLE_CHALLENGES =
                "CREATE TABLE " + ChallengeEntry.TABLE_NAME + " (" +
                        ChallengeEntry._ID + " INTEGER PRIMARY KEY, " +
                        ChallengeEntry.TITLE + TYPE_TEXT + NOT_NULL  + COMMA_SEP +
                        ChallengeEntry.DESCRIPTION + TYPE_TEXT + NOT_NULL  +
                        " )";

        protected static final String SQL_DROP_TABLE_CHALLENGES =
                "DROP TABLE IF EXISTS " + ChallengeEntry.TABLE_NAME;

        protected static abstract class ChallengeEntry implements BaseColumns, TitleDescriptionColumns {
            public static final String TABLE_NAME = "challenges";

        }

        //ChallengeItem

        protected static abstract class ChallengeItemEntry implements BaseColumns, TitleDescriptionColumns {
            public static final String TABLE_NAME = "challengeitems";
        }




    }


}
