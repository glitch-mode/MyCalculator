package com.example.mycalculator.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycalculator.Model.Calculator;
import com.example.mycalculator.R;


public class CalculatorFragment extends Fragment {


    private Button mButtonZero, mButtonOne, mButtonTwo, mButtonThree, mButtonFour, mButtonFive, mButtonDot,
            mButtonSix, mButtonSeven, mButtonEight, mButtonNine, mButtonEquals, mButtonSummation, mButtonSubtract,
            mButtonDivide, mButtonMultiply, mButtonDelete;
    private TextView mTextViewResult, mTextViewInput;
    private Calculator mCalculator = new Calculator();
    private String mStringInputPrint, mStringCurrentInput;
    private Long mIntMemory;
    private Double mDoubleMemory;
    private char mCharLastOperation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        return view;
    }
}