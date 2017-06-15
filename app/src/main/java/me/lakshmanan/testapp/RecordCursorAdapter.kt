package me.lakshmanan.testapp

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView

/**
 * Created by laxmena on 14/6/17.
 */
class RecordCursorAdapter(context: Context,cursor: Cursor):CursorAdapter(context, cursor, 0) {

    val ID: String = "_id"
    val SCORE1 : String = "SCORE1"
    val SCORE2 : String = "SCORE2"

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.record_item,parent,false)
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        var textBody: TextView = view!!.findViewById(R.id.recordElement) as TextView
        var id = cursor!!.getInt(cursor.getColumnIndex(ID))
        var score1 = cursor!!.getInt(cursor.getColumnIndex(SCORE1))
        var score2 = cursor!!.getInt(cursor.getColumnIndex(SCORE2))
        var body:String = "ID: "+id+" | Score 1: "+score1+" | Score 2: "+score2
        textBody.setText(body)
    }


}