package me.lakshmanan.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    val mydb = DBHelper(this)
    var TeamAScore = 0
    var TeamBScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayScores()
        
    }

    fun addScore(team:Int,point:Int){
        when(team){
            1 -> TeamAScore += point
            2 -> TeamBScore += point
        }
        displayScores()
    }

    fun updateScoreA1(v: View):Unit = addScore(1,1)
    fun updateScoreB1(v: View):Unit = addScore(2,1)

    fun updateScoreA2(v: View):Unit = addScore(1,2)
    fun updateScoreB2(v: View):Unit = addScore(2,2)

    fun updateScoreA3(v: View):Unit = addScore(1,3)
    fun updateScoreB3(v: View):Unit = addScore(2,3)

    fun reset(v: View):Unit{
        TeamAScore = 0
        TeamBScore = 0
        displayScores()
    }

    fun save(view: View):Unit{
        mydb.insertScores(TeamAScore,TeamBScore)
        val intent: Intent = Intent(this, RecordsView::class.java)
        startActivity(intent)
    }
    fun displayScores(){
        scoreTeamA.text = ""+TeamAScore
        scoreTeamB.text = ""+TeamBScore
    }

}





