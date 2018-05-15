package edu.braz.com.br.festafimdeano.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import edu.braz.com.br.constants.FimDeAnoConstants
import edu.braz.com.br.festafimdeano.R
import edu.braz.com.br.util.SecurityPrefences



class DetailsActivity : AppCompatActivity(), View.OnClickListener{

    private val mViewHolder: ViewHolder = ViewHolder()
    private lateinit var mSecurityPrefences: SecurityPrefences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)

        this.mSecurityPrefences = SecurityPrefences(this)

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate) as CheckBox

        this.mViewHolder.checkParticipate!!.setOnClickListener(this)

        this.loadDataFromActivity()
    }

    override fun onClick(view: View) {
        val id = view.getId()
        if (id == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked) {
                this.mSecurityPrefences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WILL_GO)
            } else {
                this.mSecurityPrefences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WONT_GO)
            }
        }
    }

    private fun loadDataFromActivity() {
        val extras = intent.extras
        if (extras != null) {
            val presence = extras.getString(FimDeAnoConstants.PRESENCE)
            this.mViewHolder.checkParticipate.isChecked = (presence == FimDeAnoConstants.CONFIRMED_WILL_GO)
        }
    }

    private class ViewHolder {
        lateinit var checkParticipate: CheckBox
    }
}
