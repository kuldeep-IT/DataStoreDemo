package com.example.datastoregithubdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.lifecycle.asLiveData
import com.example.datastoregithubdemo.DataStore.DataStoreManager
import com.example.datastoregithubdemo.DataStore.PreferenceKeys
import com.example.datastoregithubdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
    Reference: https://gist.github.com/hamurcuabi/63d627d999703a81906581bbbfe5b1e3#file-datastorehelper-kt
*/


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        dataStoreManager = DataStoreManager(this)


        /*setContentView(R.layout.activity_main)*/

        CoroutineScope(Dispatchers.IO).launch {
            dataStoreManager.saveStringToDataStore(PreferenceKeys.MY_STRING, "Hello World")
            dataStoreManager.saveBooleanToDataStore(PreferenceKeys.MY_BOOLEAN, true)
            dataStoreManager.saveFloatToDataStore(PreferenceKeys.MY_FLOAT, 1.24f)
            dataStoreManager.saveIntToDataStore(PreferenceKeys.MY_INT, 55)
            dataStoreManager.saveLongToDataStore(PreferenceKeys.MY_LONG, 123456)

        }

        var resultString = ""
       dataStoreManager.readStringFromDataStore(PreferenceKeys.MY_STRING).asLiveData().observe(
           this,
           {
               resultString = it
           }
       )


      dataStoreManager.readBooleanFromDataStore(PreferenceKeys.MY_BOOLEAN).asLiveData().observe(
            this,{
                resultString = resultString+"\n"+ it
              /*binding.tv.text = resultString.toString()*/
            }
        )

        dataStoreManager.readFloatFromDataStore(PreferenceKeys.MY_FLOAT).asLiveData().observe(
            this,
            {
                resultString = resultString+"\n"+ it

            }
        )

        dataStoreManager.readIntegerFromDataStore(PreferenceKeys.MY_INT).asLiveData().observe(
            this,
            {
                resultString = resultString+"\n"+ it

            }
        )
        dataStoreManager.readLongFromDataStore(PreferenceKeys.MY_LONG).asLiveData().observe(
            this,
            {
                resultString = resultString+"\n"+ it
                binding.tv.text = resultString.toString()
            }
        )


    }
}