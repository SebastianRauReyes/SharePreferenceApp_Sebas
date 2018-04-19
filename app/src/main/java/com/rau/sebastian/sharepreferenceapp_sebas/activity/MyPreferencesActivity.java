package com.rau.sebastian.sharepreferenceapp_sebas.activity;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.os.Bundle;
import android.util.Log;

import com.rau.sebastian.sharepreferenceapp_sebas.R;

public class MyPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(final Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }


        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

            Log.d("settings", "preference changed: " + key);
            if("username".equals(key)){
                Log.d("settings", "new value for username: " + sharedPreferences.getString(key, null));
            }else if("applicationUpdates".equals(key)){
                Log.d("settings", "new value for applicationUpdates: " + sharedPreferences.getBoolean(key, false));
            }else if("downloadType".equals(key)){
                Log.d("settings", "new value for downloadType: " + sharedPreferences.getString(key, null));
            }

        }
        @Override
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onPause() {
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();
        }



    }

}

