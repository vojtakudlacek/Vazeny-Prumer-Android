package cz.soft.vojta_kudlacek.VazenyPrumerAndroid

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var array : Array<Grade> = arrayOf<Grade>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var gradesList = findViewById<TextView>(R.id.gradeList)
        var weightList = findViewById<TextView>(R.id.weightList)
        gradesList.text = gradesList.text.toString() + ": \n"
        weightList.text = weightList.text.toString() + ": \n"

    }

    fun Add(view:View) {

        var gradeET = findViewById<EditText>(R.id.grade)
        var weightET = findViewById<EditText>(R.id.weight)
        var gradesList = findViewById<TextView>(R.id.gradeList)
        var weightList = findViewById<TextView>(R.id.weightList)

        gradeList.text = (gradesList.text.toString() + gradeET.text.toString() + "\n")
        weightList.text = (weightList.text.toString() + weightET.text.toString() + "\n")

        array += Grade(gradeET.text.toString().toByte(), weightET.text.toString().toByte())
        var diameterTW = findViewById<TextView>(R.id.diameter)
        var diameter:Float =  getDiameter()

        if (diameter<=2.5f)
        {
            diameterTW.setTextColor(ColorStateList.valueOf(Color.GREEN))
        }else if(diameter>=3.5)
        {
            diameterTW.setTextColor(ColorStateList.valueOf(Color.RED))
        }else
        {
            diameterTW.setTextColor(ColorStateList.valueOf(Color.BLACK))
        }
        diameterTW.text = diameter.toString()

    }

    fun getDiameter() : Float
    {
        var diameter:Float = 0.0f
        var gradesAdd:Float = 0.0f
        var weigthsAdd:Float = 0.0f
        for (grade:Grade in array)
        {
            gradesAdd += grade.getGrade() * grade.getWeight()
            weigthsAdd += grade.getWeight()
        }
        diameter = gradesAdd / weigthsAdd
        return diameter
    }
}
