package edu.braz.com.br.festafimdeano.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import edu.braz.com.br.constants.FimDeAnoConstants
import edu.braz.com.br.festafimdeano.R
import edu.braz.com.br.util.SecurityPrefences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPrefences: SecurityPrefences


    override fun onClick(v: View?) {
       val id = v?.id
        if(id == R.id.button_confirm){
            val presence = this.mSecurityPrefences.getStoredString(FimDeAnoConstants.PRESENCE)
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(FimDeAnoConstants.PRESENCE, presence)
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

        this.mSecurityPrefences = SecurityPrefences(this)

        mViewHolder.textToday = findViewById(R.id.text_today) as TextView
        mViewHolder.textDeysLeft = findViewById(R.id.text_days_left) as TextView
        mViewHolder.buttonConfirm = findViewById(R.id.button_confirm) as Button

        mViewHolder.buttonConfirm.setOnClickListener(this)
        verifyPresence()
    }

    override fun onResume() {
        super.onResume()
        this.verifyPresence()
    }

    private fun verifyPresence() {
        val presence = this.mSecurityPrefences.getStoredString(FimDeAnoConstants.PRESENCE)
        if (presence == "")
            this.mViewHolder.buttonConfirm.setText(R.string.nao_confirmado)
        else if (presence == FimDeAnoConstants.CONFIRMED_WILL_GO)
            this.mViewHolder.buttonConfirm.setText(R.string.sim)
        else
            this.mViewHolder.buttonConfirm.setText(R.string.nao)
    }

    private class ViewHolder{
        lateinit var textToday: TextView
        lateinit var textDeysLeft: TextView
        lateinit var buttonConfirm: Button
    }
}
