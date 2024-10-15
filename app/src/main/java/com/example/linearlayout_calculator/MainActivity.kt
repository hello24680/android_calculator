package com.example.linearlayout_calculator



import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textReuslt: TextView

    var op1: Int = 0
    var op2: Int = 0
    var state: Int = 1
    var op: Int = 0
    var idThaoTac: Int = 0
    var res: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textReuslt = findViewById(R.id.text_result)

        findViewById<Button>(R.id.C).setOnClickListener(this)
        findViewById<Button>(R.id.CE).setOnClickListener(this)
        findViewById<Button>(R.id.BS).setOnClickListener(this)

        findViewById<Button>(R.id.btn0).setOnClickListener(this)
        findViewById<Button>(R.id.btn1).setOnClickListener(this)
        findViewById<Button>(R.id.btn2).setOnClickListener(this)
        findViewById<Button>(R.id.btn3).setOnClickListener(this)
        findViewById<Button>(R.id.btn4).setOnClickListener(this)
        findViewById<Button>(R.id.btn5).setOnClickListener(this)
        findViewById<Button>(R.id.btn6).setOnClickListener(this)
        findViewById<Button>(R.id.btn7).setOnClickListener(this)
        findViewById<Button>(R.id.btn8).setOnClickListener(this)
        findViewById<Button>(R.id.btn9).setOnClickListener(this)

        findViewById<Button>(R.id.cong).setOnClickListener(this)
        findViewById<Button>(R.id.tru).setOnClickListener(this)
        findViewById<Button>(R.id.nhan).setOnClickListener(this)
        findViewById<Button>(R.id.chia).setOnClickListener(this)

        findViewById<Button>(R.id.bang).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id

        if(id == R.id.btn0){
            basicCalculator(0)
        }else if (id == R.id.btn1){
            basicCalculator(1)
        }else if (id == R.id.btn2) {
            basicCalculator(2)
        }else if (id == R.id.btn3){
            basicCalculator(3)
        }else if (id == R.id.btn4) {
            basicCalculator(4)
        }else if (id == R.id.btn5){
            basicCalculator(5)
        }else if (id == R.id.btn6) {
            basicCalculator(6)
        }else if (id == R.id.btn7){
            basicCalculator(7)
        }else if (id == R.id.btn8) {
            basicCalculator(8)
        }else if (id == R.id.btn9) {
            basicCalculator(9)
        }

        if(id == R.id.C){
            thaoTac("C")
        }else if(id == R.id.BS){
            thaoTac("BS")
        }else if(id == R.id.CE){
            thaoTac("CE")
        }else if(id == R.id.cong){
            thaoTac("cong")
        }else if(id == R.id.tru) {
            thaoTac("tru")
        }else if(id == R.id.nhan){
            thaoTac("nhan")
        }else if(id == R.id.chia) {
            thaoTac("chia")
        }else if(id == R.id.bang) {
            thaoTac("bang")
        }


    }

    fun basicCalculator(n: Int){
        if(op == 0 && state == 1){
            op1 = n
            textReuslt.text = "$op1"
        }else if(op == 1 && state == 2){
            op2 = n
            textReuslt.text = "$op2"
        }


    }

    fun thaoTac(s: String){
        if(s == "CE"){
            if(op == 0){
                op1 = 0
                textReuslt.text = "$op1"
            }else if(op == 1){
                op2 = 0
                textReuslt.text = "$op2"
            }
        }else if(s == "C"){
            op1 = 0
            op2 = 0
            state = 1
            op = 0
            idThaoTac = 0
            textReuslt.text = "$op1"
        }else if(s == "BS"){
            if(op == 1){
                op2 = 0
                state = 1
                op == 0
                textReuslt.text = "$op1"
            }else if(op == 0){
                op1 = 0
                textReuslt.text = "$op1"
            }
        }else if(s == "cong"){
            state = 2
            op = 1
            idThaoTac = 1
        }else if(s == "tru"){
            state = 2
            op = 1
            idThaoTac = 2
        }else if(s == "nhan"){
            state = 2
            op = 1
            idThaoTac = 3
        }else if(s == "chia"){
            state = 2
            op = 1
            idThaoTac = 4
        }else if(s == "bang"){
            if(idThaoTac == 1){
                res = op1 + op2
                textReuslt.text = "$res"
            }else if(idThaoTac == 2){
                res = op1 - op2
                textReuslt.text = "$res"
            }else if(idThaoTac == 3) {
                res = op1 * op2
                textReuslt.text = "$res"
            }else if(idThaoTac == 4) {
                if(op2 == 0){
                    textReuslt.setText("khong chia dc 0")
                }else {
                    res = op1 / op2
                    textReuslt.text = "$res"
                }
            }

            if(idThaoTac != 0){
                op1 = 0
                op2 = 0
                state = 1
                op = 0
                idThaoTac = 0
            }
        }
    }
}