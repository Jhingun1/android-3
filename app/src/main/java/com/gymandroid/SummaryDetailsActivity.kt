package com.gymandroid

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kotlinx.android.synthetic.main.activity_summary_details.*


class SummaryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_details)
        summary_detail_bar.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.exit_old_from_right, R.anim.exit_new_from_right)
        }

        inflateCorrectRateChart(85f)
    }

    fun inflateCorrectRateChart(correctRate: Float) {
        val pieChart = findViewById<PieChart>(R.id.piechart)
        val correctRateData = ArrayList<PieEntry>()

        correctRateData.add(PieEntry(85f))
        correctRateData.add(PieEntry(15f))
        val dataSet = PieDataSet(correctRateData, null)

        pieChart.data = PieData(dataSet)
        dataSet.setColors(
            // green and red
            Color.rgb(0x3d, 0xdc, 0x84),
            Color.rgb(0xba, 0x16, 0x0c)
        )

        pieChart.centerText = "85% Correct"
        pieChart.setTransparentCircleAlpha(1)
        pieChart.setCenterTextSize(24f)

        dataSet.setDrawValues(false)
        dataSet.valueFormatter = PercentFormatter(pieChart)
        dataSet.valueTextSize = 18f
        dataSet.valueTextColor = Color.WHITE
        pieChart.description.isEnabled = false
        pieChart.legend.isEnabled = false
    }
}
