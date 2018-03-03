package org.gmetais.downloadmanager.ui

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.gmetais.downloadmanager.R
import org.gmetais.downloadmanager.addFragment
import org.gmetais.downloadmanager.ui.fragments.SharesBrowser
import org.gmetais.downloadmanager.ui.helpers.NavigationListener
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject internal lateinit var onNavigationItemSelectedListener: NavigationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: addFragment(R.id.fragment_placeholder, SharesBrowser(), "shares")
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun onBackPressed() {
        if ("shares" == supportFragmentManager.findFragmentById(R.id.fragment_placeholder)?.tag) {
            finish()
            return
        }
        super.onBackPressed()
    }
}
