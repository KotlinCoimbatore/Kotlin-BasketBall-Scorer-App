package me.lakshmanan.testapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ListView
import kotlin.properties.Delegates

class RecordsView : AppCompatActivity() {

    val mydb = DBHelper(this)


    val ID: String = "_id"
    val SCORE1 : String = "SCORE1"
    val SCORE2 : String = "SCORE2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records_view)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        displayData()
    }

    fun displayData(){
        val cur = mydb.getScores()
        var lv:ListView = findViewById(R.id.recordListView) as ListView
        var cursorAdaptor = RecordCursorAdapter(this, cur)
        lv.adapter = cursorAdaptor
    }
}
