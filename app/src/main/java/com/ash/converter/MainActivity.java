package com.ash.converter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Spinner unitIn, unitOut;
    private String[] category, shortCategory;
    private String input, type;
    private LinearLayout length, area, volume, weight, time, speed, pressure, temperature, data, frequency, money, energy;
    private EditText in;
    private TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        length = findViewById(R.id.length);
        area = findViewById(R.id.area);
        volume = findViewById(R.id.volume);
        weight = findViewById(R.id.weight);
        time = findViewById(R.id.time);
        speed = findViewById(R.id.speed);
        pressure = findViewById(R.id.pressure);
        temperature = findViewById(R.id.temperature);
        data = findViewById(R.id.data);
        frequency = findViewById(R.id.frequency);
        money = findViewById(R.id.money);
        energy = findViewById(R.id.energy);
        length.setOnClickListener(this);
        area.setOnClickListener(this);
        volume.setOnClickListener(this);
        weight.setOnClickListener(this);
        time.setOnClickListener(this);
        speed.setOnClickListener(this);
        pressure.setOnClickListener(this);
        temperature.setOnClickListener(this);
        data.setOnClickListener(this);
        frequency.setOnClickListener(this);
        money.setOnClickListener(this);
        energy.setOnClickListener(this);
        unitIn = findViewById(R.id.unitIn);
        unitOut = findViewById(R.id.unitOut);
        in = findViewById(R.id.in);
        out = findViewById(R.id.out);

        TextWatcher text = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        in.addTextChangedListener(text);
    }

    private void calculate() {
        input = in.getText().toString();
        if (!input.isEmpty()) {
            float inputValue = Float.parseFloat(input);
            float outputValue = 0;
            String inputUnit = (String) unitIn.getSelectedItem();
            Log.d("MainActivity", inputUnit);
            Log.d("MainActivity", String.valueOf(inputValue));
            String outputUnit = (String) unitOut.getSelectedItem();
            switch (type) {
                case "Length":
                    switch (inputUnit) {
                        case "Meter":
                            break;
                        case "Centimeter":
                            inputValue = inputValue / 100;
                            break;
                        case "Kilometer":
                            inputValue = inputValue * 1000;
                            break;
                        case "Inch":
                            inputValue = (float) (inputValue * 0.0254);
                            break;
                        case "Foot":
                            inputValue = (float) (inputValue * 0.3048);
                            break;
                        case "Yard":
                            inputValue = (float) (inputValue * 0.9144);
                            break;
                        case "Mile":
                            inputValue = (float) (inputValue * 1609.34);
                            break;
                    }
                    switch (outputUnit) {
                        case "Meter":
                            outputValue = inputValue;
                            break;
                        case "Centimeter":
                            outputValue = inputValue * 100;
                            break;
                        case "Kilometer":
                            outputValue = inputValue / 1000;
                            break;
                        case "Inch":
                            outputValue = (float) (inputValue / 0.0254);
                            break;
                        case "Foot":
                            outputValue = (float) (inputValue / 0.3048);
                            break;
                        case "Yard":
                            outputValue = (float) (inputValue / 0.9144);
                            break;
                        case "Mile":
                            outputValue = (float) (inputValue / 1609.34);
                            break;
                    }
                    break;
                case "Area":
                    switch (inputUnit) {
                        case "Square Meter":
                            break;
                        case "Square Centimeter":
                            inputValue = inputValue / 10000;
                            break;
                        case "Square Kilometer":
                            inputValue = inputValue * 1000000;
                            break;
                        case "Square Inch":
                            inputValue = (float) (inputValue * 0.00064516);
                            break;
                        case "Square Foot":
                            inputValue = (float) (inputValue * 0.092903);
                            break;
                        case "Square Yard":
                            inputValue = (float) (inputValue * 0.836127);
                            break;
                        case "Square Mile":
                            inputValue = (float) (inputValue * 3.861e-7);
                            break;
                    }
                    switch (outputUnit) {
                        case "Square Meter":
                            outputValue = inputValue;
                            break;
                        case "Square Centimeter":
                            outputValue = inputValue * 100;
                            break;
                        case "Square Kilometer":
                            outputValue = inputValue / 1000000;
                            break;
                        case "Square Inch":
                            outputValue = (float) (inputValue / 0.00064516);
                            break;
                        case "Square Foot":
                            outputValue = (float) (inputValue / 10.7639);
                            break;
                        case "Square Yard":
                            outputValue = (float) (inputValue / 1.19599);
                            break;
                    }
                    break;
                case "volume":
                    switch (inputUnit) {
                        case "Milliliter":
                            break;
                        case "Liter":
                            inputValue = inputValue * 1000;
                            break;
                        case "Cubic Meter":
                            inputValue = inputValue * 1000000;
                            break;
                        case "Cubic Inch":
                            inputValue = (float) (inputValue * 16.3871);
                            break;
                        case "Cubic Foot":
                            inputValue = (float) (inputValue * 28316.8);
                            break;
                    }
                    switch (outputUnit) {
                        case "Milliliter":
                            outputValue = inputValue;
                            break;
                        case "Liter":
                            outputValue = inputValue / 1000;
                            break;
                        case "Cubic Meter":
                            outputValue = inputValue / 1000000;
                            break;
                        case "Cubic Inch":
                            outputValue = (float) (inputValue / 16.3871);
                            break;
                        case "Cubic Foot":
                            outputValue = (float) (inputValue / 28316.8);
                            break;
                    }
                    break;
                case "mass":
                    switch (inputUnit) {
                        case "Kilogram":
                            break;
                        case "Gram":
                            inputValue = inputValue / 1000;
                            break;
                        case "Milligram":
                            inputValue = inputValue / 1000000;
                            break;
                        case "Pound":
                            inputValue = (float) (inputValue * 0.453592);
                            break;
                        case "Ounce":
                            inputValue = (float) (inputValue * 0.0283495);
                            break;
                    }
                    switch (outputUnit) {
                        case "Kilogram":
                            outputValue = inputValue;
                            break;
                        case "Gram":
                            outputValue = inputValue * 1000;
                            break;
                        case "Milligram":
                            outputValue = inputValue * 1000000;
                            break;
                        case "Pound":
                            outputValue = (float) (inputValue / 0.453592);
                            break;
                        case "Ounce":
                            outputValue = (float) (inputValue / 0.0283495);
                            break;
                    }
                    break;
                case "time":
                    switch (inputUnit) {
                        case "Second":
                            break;
                        case "Minute":
                            inputValue = inputValue * 60;
                            break;
                        case "Hour":
                            inputValue = inputValue * 3600;
                            break;
                        case "Day":
                            inputValue = inputValue * 86400;
                            break;
                        case "Week":
                            inputValue = inputValue * 604800;
                            break;
                    }
                    switch (outputUnit) {
                        case "Second":
                            outputValue = inputValue;
                            break;
                        case "Minute":
                            outputValue = inputValue / 60;
                            break;
                        case "Hour":
                            outputValue = inputValue / 3600;
                            break;
                        case "Day":
                            outputValue = inputValue / 86400;
                            break;
                        case "Week":
                            outputValue = inputValue / 604800;
                            break;
                    }
                    break;

                case "speed":
                    switch (inputUnit) {
                        case "Meter per Second":
                            break;
                        case "Kilometer per Hour":
                            inputValue = (float) (inputValue / 3.6);
                            break;
                        case "Mile per Hour":
                            inputValue = (float) (inputValue / 2.23694);
                            break;
                    }
                    switch (outputUnit) {
                        case "Meter per Second":
                            outputValue = inputValue;
                            break;
                        case "Kilometer per Hour":
                            outputValue = (float) (inputValue * 3.6);
                            break;
                        case "Mile per Hour":
                            outputValue = (float) (inputValue * 2.23694);
                            break;
                    }
                    break;
                case "pressure":
                    switch (inputUnit) {
                        case "Pascal":
                            break;
                        case "Kilopascal":
                            inputValue = inputValue / 1000;
                            break;
                        case "Bar":
                            inputValue = inputValue / 100000;
                            break;
                        case "Atmosphere":
                            inputValue = inputValue / 101325;
                            break;
                    }
                    switch (outputUnit) {
                        case "Pascal":
                            outputValue = inputValue;
                            break;
                        case "Kilopascal":
                            outputValue = inputValue * 1000;
                            break;
                        case "Bar":
                            outputValue = inputValue * 100000;
                            break;
                        case "Atmosphere":
                            outputValue = inputValue * 101325;
                            break;
                    }
                    break;
                case "data":
                    switch (inputUnit) {
                        case "Byte":
                            break;
                        case "Kilobyte":
                            inputValue = inputValue * 1024;
                            break;
                        case "Megabyte":
                            inputValue = inputValue * 1048576;
                            break;
                        case "Gigabyte":
                            inputValue = inputValue * 1073741824;
                            break;
                        case "Terabyte":
                            inputValue = inputValue * 1099511627776L;
                            break;
                    }
                    switch (outputUnit) {
                        case "Byte":
                            outputValue = inputValue;
                            break;
                        case "Kilobyte":
                            outputValue = inputValue / 1024;
                            break;
                        case "Megabyte":
                            outputValue = inputValue / 1048576;
                            break;
                        case "Gigabyte":
                            outputValue = inputValue / 1073741824;
                            break;
                        case "Terabyte":
                            outputValue = inputValue / 1099511627776L;
                            break;
                    }
                    break;
                case "money":
                    switch (inputUnit) {
                        case "Rupee":
                            break;
                        case "Dollar":
                            inputValue = inputValue / 75;
                            break;
                        case "Euro":
                            inputValue = inputValue / 85;
                            break;
                    }
                    switch (outputUnit) {
                        case "Rupee":
                            outputValue = inputValue;
                            break;
                        case "Dollar":
                            outputValue = inputValue * 75;
                            break;
                        case "Euro":
                            outputValue = inputValue * 85;
                            break;
                    }
                    break;
                case "energy":
                    switch (inputUnit) {
                        case "Joule":
                            break;
                        case "Kilowatt-hour":
                            inputValue = inputValue / 3600000;
                            break;
                        case "Megawatt-hour":
                            inputValue = inputValue / 3600000000L;
                            break;
                        case "Gigawatt-hour":
                            inputValue = inputValue / 3600000000000L;
                            break;
                        case "Terawatt-hour":
                            inputValue = inputValue / 3600000000000000L;
                            break;
                    }
                    switch (outputUnit) {
                        case "Joule":
                            outputValue = inputValue;
                            break;
                        case "Kilowatt-hour":
                            outputValue = inputValue * 3600000;
                            break;
                        case "Megawatt-hour":
                            outputValue = inputValue * 3600000000L;
                            break;
                        case "Gigawatt-hour":
                            outputValue = inputValue * 3600000000000L;
                            break;
                        case "Terawatt-hour":
                            outputValue = inputValue * 3600000000000000L;
                            break;
                    }
                    break;
                case "temperature":
                    switch (inputUnit) {
                        case "Celsius":
                            break;
                        case "Fahrenheit":
                            inputValue = (float) ((inputValue - 32) * 5 / 9);
                            break;
                        case "Kelvin":
                            inputValue = (float) (inputValue - 273.15);
                            break;
                    }
                    switch (outputUnit) {
                        case "Celsius":
                            outputValue = inputValue;
                            break;
                        case "Fahrenheit":
                            outputValue = (float) ((inputValue * 9 / 5) + 32);
                            break;
                        case "Kelvin":
                            outputValue = (float) (inputValue + 273.15);
                            break;
                    }
                    break;
                case "frequency":
                    switch (inputUnit) {
                        case "Hertz":
                            break;
                        case "Kilohertz":
                            inputValue = inputValue / 1000;
                            break;
                        case "Megahertz":
                            inputValue = inputValue / 1000000;
                            break;
                        case "Gigahertz":
                            inputValue = inputValue / 1000000000;
                            break;
                        case "Terahertz":
                            inputValue = inputValue / 1000000000000L;
                            break;
                    }
                    switch (outputUnit) {
                        case "Hertz":
                            outputValue = inputValue;
                            break;
                        case "Kilohertz":
                            outputValue = inputValue * 1000;
                            break;
                        case "Megahertz":
                            outputValue = inputValue * 1000000;
                            break;
                        case "Gigahertz":
                            outputValue = inputValue * 1000000000;
                            break;
                        case "Terahertz":
                            outputValue = inputValue * 1000000000000L;
                            break;
                    }
                    break;
            }
            out.setText(String.valueOf(outputValue));
        }
    }

    @Override
    public void onClick(View view) {
        type = (String) view.getContentDescription();
        Log.d("MainActivity", type + " " + "clicked");
        findViewById(R.id.calc).setVisibility(View.VISIBLE);
        ScrollView scrollLayout = findViewById(R.id.linearLayout);
//        ScrollView.LayoutParams params = (ScrollView.LayoutParams) scrollLayout.getLayoutParams();
//        params.height = 400;
//        params.width = 700;
//        scrollLayout.setLayoutParams(params);
        scrollLayout.setScaleX(1);
        scrollLayout.setScaleY(1);

        switch (type) {
            case "Length":
                category = new String[]{"Meter", "Centimeter", "Kilometer", "Inch", "Foot", "Yard", "Mile"};
                shortCategory = new String[]{"m", "cm", "km", "in", "ft", "yd", "mi"};
                break;
            case "Area":
                category = new String[]{"Square Meter", "Square Centimeter", "Square Kilometer", "Square Inch", "Square Foot", "Square Yard", "Square Mile"};
                shortCategory = new String[]{"m²", "cm²", "km²", "in²", "ft²", "yd²", "mi²"};
                break;
            case "volume":
                category = new String[]{"Milliliter", "Liter", "Cubic Meter", "Cubic Inch", "Cubic Foot"};
                shortCategory = new String[]{"ml", "l", "m³", "in³", "ft³"};
                break;
            case "mass":
                category = new String[]{"Kilogram", "Gram", "Milligram", "Pound", "Ounce"};
                shortCategory = new String[]{"kg", "g", "mg", "lb", "oz"};
                break;
            case "time":
                category = new String[]{"Second", "Minute", "Hour", "Day", "Week"};
                shortCategory = new String[]{"s", "min", "h", "d", "w"};
                break;
            case "speed":
                category = new String[]{"Meter per Second", "Kilometer per Hour", "Mile per Hour"};
                shortCategory = new String[]{"m/s", "km/h", "mph"};
                break;
            case "pressure":
                category = new String[]{"Pascal", "Kilopascal", "Bar", "Atmosphere"};
                shortCategory = new String[]{"Pa", "kPa", "bar", "atm"};
                break;
            case "temperature":
                category = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
                shortCategory = new String[]{"°C", "°F", "K"};
                break;
            case "data":
                category = new String[]{"Byte", "Kilobyte", "Megabyte", "Gigabyte", "Terabyte"};
                shortCategory = new String[]{"B", "KB", "MB", "GB", "TB"};
                break;
            case "frequency":
                category = new String[]{"Hertz", "Kilohertz", "Megahertz", "Gigahertz", "Terahertz"};
                shortCategory = new String[]{"Hz", "kHz", "MHz", "GHz", "THz"};
                break;
            case "money":
                category = new String[]{"Rupee", "Dollar", "Euro", "Pound"};
                shortCategory = new String[]{"₹", "$", "€", "£"};
                break;
            case "energy":
                category = new String[]{"Joule", "Kilowatt-hour", "Megawatt-hour", "Gigawatt-hour", "Terawatt-hour"};
                shortCategory = new String[]{"J", "kWh", "MWh", "GWh", "TWh"};
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // This sets what is shown after selection
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setText(shortCategory[position]); // show short form
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                // This sets what is shown in the dropdown list
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                view.setText(category[position]); // show full name
                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitIn.setAdapter(adapter);
        unitOut.setAdapter(adapter);
        unitIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        unitOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}