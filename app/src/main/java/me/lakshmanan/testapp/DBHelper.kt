package me.lakshmanan.testapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

/**
 * Created by laxmena on 13/6/17.
 */
open class DBHelper(context: Context) : SQLiteOpenHelper(context, "tryKotlin.db", null, 1) {

    companion object{
        public val DATA_TABLE_NAME: String = "scores"
        public val ID: String = "_id"
        public val TIMESTAMP : String = "TIMESTAMP"
        public val SCORE1 : String = "SCORE1"
        public val SCORE2 : String = "SCORE2"
    }

    val DATABASE_CREATE =
        "CREATE TABLE if not exists " + DATA_TABLE_NAME + " (" +
        "${ID} integer PRIMARY KEY autoincrement,"+
        "${TIMESTAMP} integer,"+
        "${SCORE1} integer,"+
        "${SCORE2} integer"+
        ")"

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("DBHelper","Creating: " + DATABASE_CREATE)
        db?.execSQL(DATABASE_CREATE)
    }

    fun insertScores(score1:Int,score2:Int){
        val values = ContentValues()
        Log.d("DBHelper","Adding Data ")
        values.put(SCORE1,score1)
        values.put(SCORE2,score2)
        values.put(TIMESTAMP,System.currentTimeMillis())
        writableDatabase.insert(DATA_TABLE_NAME,null,values)
    }

    fun getScores() : Cursor{
        return readableDatabase
                .query(DATA_TABLE_NAME, arrayOf(ID, TIMESTAMP, SCORE1, SCORE2),null,null,null,null,null)

    }

}
