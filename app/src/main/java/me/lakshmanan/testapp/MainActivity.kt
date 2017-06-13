package me.lakshmanan.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

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
    fun displayScores(){
        var scoreA = findViewById(R.id.scoreTeamA) as TextView
        scoreA.text = TeamAScore.toString()

        var scoreB = findViewById(R.id.scoreTeamB) as TextView
        scoreB.text = TeamBScore.toString()
    }

}
