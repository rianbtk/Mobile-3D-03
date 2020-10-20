package org.aplas.basicappx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertBtn = (Button) findViewById(R.id.convertButton);
        inputTxt = (EditText) findViewById(R.id.inputText);
        outputTxt = (EditText) findViewById(R.id.outputText);
        unitOri = (Spinner) findViewById(R.id.oriList);
        unitConv = (Spinner) findViewById(R.id.convList);
        unitType = (RadioGroup) findViewById(R.id.radioGroup);
        roundBox = (CheckBox) findViewById(R.id.chkRounded);
        formBox = (CheckBox) findViewById(R.id.chkFormula);
        imgView = (ImageView) findViewById(R.id.img);
        unitType.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton selected = (RadioButton) findViewById(checkedId);
                        ArrayAdapter<CharSequence> adapter;
                        inputTxt.setText("0");
                        outputTxt.setText("0");
                        if (selected.getText().equals("Temperature")) {
                            adapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.tempList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.temperature);
                            imgView.setTag(R.drawable.temperature);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(adapter);
                            unitConv.setAdapter(adapter);
                        } else if (selected.getText().equals("Distance")) {
                            adapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.distList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.distance);
                            imgView.setTag(R.drawable.distance);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(adapter);
                            unitConv.setAdapter(adapter);
                        } else {
                            adapter = ArrayAdapter.createFromResource(unitType.getContext(), R.array.weightList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.weight);
                            imgView.setTag(R.drawable.weight);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(adapter);
                            unitConv.setAdapter(adapter);
                        }
                    }
                });
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doConvert();
            }
        });
        unitOri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doConvert();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        unitConv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doConvert();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        roundBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            doConvert();
            }
        });
        formBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((ImageView)findViewById(R.id.imgFormula)).setVisibility((isChecked)?View.VISIBLE:View.INVISIBLE);
            }
        });
    }

    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;

    protected double convertUnit (String type,String oriUnit,String convUnit,double value) {
        if (type.equals("Temperature")) {
            return temp.convert(oriUnit, convUnit, value);
        } else if (type.equals("Distance")) {
            return dist.convert(oriUnit, convUnit, value);
        } else {
            return weight.convert(oriUnit, convUnit, value);
        }
    }

    protected String strResult (double val,boolean rounded) {
        if (rounded) {
            DecimalFormat f = new DecimalFormat("#.##");
            return f.format(val);
        } else {
            DecimalFormat f = new DecimalFormat("#.#####");
            return f.format(val);
        }
    }

    private AlertDialog startDialog;
    @Override
    protected void onStart() {
        super.onStart();
        startDialog = new AlertDialog.Builder(MainActivity.this).create();
        startDialog.setTitle("Tugas Mobile");
        startDialog.setMessage("Agus Salim Hadjrianto");
        startDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        startDialog.show();
    }

    public void doConvert() {
        RadioButton selected = (RadioButton) findViewById(unitType.getCheckedRadioButtonId());
        double val = Double.parseDouble(inputTxt.getText().toString());
        double res = convertUnit(selected.getText().toString(),unitOri.getSelectedItem().toString(),unitConv.getSelectedItem().toString(),val);
        outputTxt.setText(strResult(res,roundBox.isChecked()));
    }

}
