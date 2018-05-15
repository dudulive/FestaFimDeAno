package edu.braz.com.br.festafimdeano

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
       val id = v?.id
        if(id == R.id.button_confirm){
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private val mViewHolder: ViewHolder = ViewHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)

        mViewHolder.textToday = findViewById(R.id.text_today) as TextView
        mViewHolder.textDeysLeft = findViewById(R.id.text_days_left) as TextView
        mViewHolder.buttonConfirm = findViewById(R.id.button_confirm) as Button

        mViewHolder.buttonConfirm.setOnClickListener(this)
    }

    private class ViewHolder{
        lateinit var textToday: TextView
        lateinit var textDeysLeft: TextView
        lateinit var buttonConfirm: Button
    }
}
