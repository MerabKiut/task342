package com.example.task342;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner langSelector;
    private Button btnOk;
    private Spinner themeSelector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        langSelector = findViewById(R.id.langSelector);
        btnOk = findViewById(R.id.btnOk);
        themeSelector = findViewById(R.id.themeSelector);
        btnOk.setOnClickListener(this);
        initSpinner();
        initSpinnerTheme();
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this,
                R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSelector.setAdapter(adapterLanguage);
        langSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String[] language = getResources().getStringArray(R.array.language);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    private void initSpinnerTheme() {
        ArrayAdapter<CharSequence> adapterTheme = ArrayAdapter.createFromResource(this,
                R.array.theme, android.R.layout.simple_spinner_item);
        adapterTheme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        themeSelector.setAdapter(adapterTheme);
        themeSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String[] theme = getResources().getStringArray(R.array.theme);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }


    @Override
    public void onClick(View v) {
        String selectLanguage = langSelector.getSelectedItem().toString();
        switch (selectLanguage) {
            case "Русский":
                Locale localeRu = new Locale("ru");
                Configuration configRu = new Configuration();
                configRu.setLocale(localeRu);
                getResources().updateConfiguration(configRu, getBaseContext().getResources().getDisplayMetrics());
                recreate();
                break;
            case "English":
                Locale localeEn = new Locale("en");
                Configuration configEn = new Configuration();
                configEn.setLocale(localeEn);
                getResources().updateConfiguration(configEn, getBaseContext().getResources().getDisplayMetrics());
                recreate();
                break;
        }
        String selectTheme = themeSelector.getSelectedItem().toString();
        switch (selectTheme) {
            case "Черный": //на что указать чтобы не писать значения во всех локалях?
            case "Black":
                Utils.changeToTheme(this, Utils.THEME_BLACK);
                break;
            case "Зеленый":
            case "Green":
                Utils.changeToTheme(this, Utils.THEME_GREEN);
                break;
            case "Синий":
            case "Blue":
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                break;

        }
    }
}
