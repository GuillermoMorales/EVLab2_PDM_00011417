package com.example.evlab2_pdm_00011417


import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FakeBarFragmen.OnSelectOption {

    override fun onAction(id: Int) {
        var content = when (id) {
            1 -> {
                "IMAGEN1"
            }

            2 -> {
                "IMAGEN2"
            }
            else -> {
                "ERROR AL CARGAR IMAGEN"
            }
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, ContentFragment.newInstance(content))
                .addToBackStack("Co")
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = FakeBarFragmen.newInstace(
                "PREVIOUS",

                "FORWARD"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_bar, barFragment)
                    .commit()
        }
    }
}