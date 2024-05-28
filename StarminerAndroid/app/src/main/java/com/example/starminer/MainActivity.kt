package com.example.starminer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var score = 0
    private var multiplier = 1
    private var upgradeCost = 10

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter = findViewById<TextView>(R.id.Counter)
        val miner = findViewById<Button>(R.id.minebutton)
        val reset = findViewById<Button>(R.id.Reset)
        val upgrade = findViewById<Button>(R.id.UpgradeButton)
        val upgradeCostText = findViewById<TextView>(R.id.UpgradeCost)
        val layout = findViewById<ConstraintLayout>(R.id.main)

        miner.setOnClickListener {
            score += multiplier
            counter.text = "Rocks Mined: $score"
            layout.setBackgroundResource(R.drawable.starminer2)

            Handler(Looper.getMainLooper()).postDelayed({
                layout.setBackgroundResource(R.drawable.starminer1)
            }, 100)
        }

        reset.setOnClickListener {
            score = 0
            multiplier = 1
            upgradeCost = 10
            counter.text = "Rocks Mined: $score"
            upgradeCostText.text = "First Upgrade: $upgradeCost"
        }

        upgrade.setOnClickListener {
            if (score >= upgradeCost) {
                score -= upgradeCost
                multiplier++
                upgradeCost *= 2 * 2
                counter.text = "Rocks Mined: $score"
                updateUpgradeCostText(upgradeCostText)
            }
        }
    }
    private fun updateUpgradeCostText(upgradeCostText: TextView) {
        upgradeCostText.text = "Next Upgrade: $upgradeCost"
    }
}
