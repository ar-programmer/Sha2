package b.programmer.sha;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alexanderrabau on 29.10.17.
 */

public class DatumBooleanHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DatumRegister";
    private static final int DATABASE_VERSION = 1;



    private static final String CREATE_QUELLEN = "CREATE TABLE Quellen( kurzbezeichnung TEXT PRIMARY KEY, titel TEXT NOT NULL, autoren TEXT NOT NULL,verlag_ort_url TEXT NOT NULL, publikationsdatum);";
    private static final String CREATE_STICHWORTE = "CREATE TABLE Stichworte(id INTEGER PRIMARY KEY AUTOINCREMENT, stichwort TEXT NOT NULL, quelle TEXT NOT NULL, fundstelle TEXT NOT NULL, text TEXT NOT NULL, CONSTRAINT QuellenFK FOREIGN KEY(quelle) REFERENCES Quellen(kurzbezeichnung) ON DELETE RESTRICT ON UPDATE CASCADE);";



    public DatumBooleanHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}