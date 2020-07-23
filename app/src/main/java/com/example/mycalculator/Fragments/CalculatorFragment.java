package com.example.mycalculator.Fragments;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycalculator.R;

import java.util.InputMismatchException;


public class CalculatorFragment extends Fragment {


    private Button mButtonZero, mButtonOne, mButtonTwo, mButtonThree, mButtonFour, mButtonFive, mButtonDot,
            mButtonSix, mButtonSeven, mButtonEight, mButtonNine, mButtonEquals, mButtonSummation, mButtonSubtract,
            mButtonDivide, mButtonMultiply, mButtonDelete;
    private TextView mTextViewResult, mTextViewInput;
    private double mDoubleResult = 0;
    private View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_calculator, container, false);
        findAllViews();
        setOnClickListeners();
        if (savedInstanceState != null) {
            mDoubleResult = savedInstanceState.getDouble("result");
            mTextViewInput.setText(savedInstanceState.getString("input"));
        }
        return mView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("input", mTextViewInput.getText().toString());
        outState.putDouble("result", mDoubleResult);
    }

    public void findAllViews() {
        mButtonDelete = mView.findViewById(R.id.button_delete);
        mButtonDivide = mView.findViewById(R.id.button_divide);
        mButtonDot = mView.findViewById(R.id.button_dot);
        mButtonZero = mView.findViewById(R.id.button_zero);
        mButtonOne = mView.findViewById(R.id.button_one);
        mButtonTwo = mView.findViewById(R.id.button_two);
        mButtonThree = mView.findViewById(R.id.button_three);
        mButtonFour = mView.findViewById(R.id.button_four);
        mButtonFive = mView.findViewById(R.id.button_five);
        mButtonSix = mView.findViewById(R.id.button_six);
        mButtonSeven = mView.findViewById(R.id.button_seven);
        mButtonEight = mView.findViewById(R.id.button_eight);
        mButtonNine = mView.findViewById(R.id.button_nine);
        mButtonMultiply = mView.findViewById(R.id.button_multiplication);
        mButtonSummation = mView.findViewById(R.id.button_summation);
        mButtonSubtract = mView.findViewById(R.id.button_subtraction);
        mButtonEquals = mView.findViewById(R.id.button_equals);
        mTextViewInput = mView.findViewById(R.id.text_view_input);
        mTextViewResult = mView.findViewById(R.id.text_view_result);
    }

    public void setNumViewListener(final int n, View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAnimation(v);
                String s = mTextViewInput.getText().toString() + n;
                mTextViewInput.setText(s);
                Toast.makeText(getActivity(), String.valueOf(n), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setFuncViewListener(final String s, View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAnimation(v);
                String str = mTextViewInput.getText().toString() + " " + s + " ";
                mTextViewInput.setText(str);
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void buttonAnimation(View v) {
        Animator scale = ObjectAnimator.ofPropertyValuesHolder(v,
                PropertyValuesHolder.ofFloat(View.SCALE_X, 1, 1.5f, 1),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, 1, 1.5f, 1)
        );
        scale.setDuration(250);
        scale.start();
    }


    public void setOnClickListeners() {
        setNumViewListener(1, mButtonOne);
        setNumViewListener(2, mButtonTwo);
        setNumViewListener(3, mButtonThree);
        setNumViewListener(4, mButtonFour);
        setNumViewListener(5, mButtonFive);
        setNumViewListener(6, mButtonSix);
        setNumViewListener(7, mButtonSeven);
        setNumViewListener(8, mButtonEight);
        setNumViewListener(9, mButtonNine);
        setNumViewListener(0, mButtonZero);

        mButtonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAnimation(v);
                String s = mTextViewInput.getText().toString() + ".";
                mTextViewInput.setText(s);
                Toast.makeText(getActivity(), ".", Toast.LENGTH_SHORT).show();
            }
        });

        mButtonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAnimation(v);
                calculate();
                if (mDoubleResult == (int) mDoubleResult) {
                    mTextViewResult.setText(String.valueOf(Math.round(mDoubleResult)));
                    mTextViewInput.setText(String.valueOf(Math.round(mDoubleResult)));
                } else {
                    mTextViewResult.setText(String.valueOf(mDoubleResult));
                    mTextViewInput.setText(String.valueOf(mDoubleResult));
                }
            }
        });
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                mTextViewResult.setText("");
                mTextViewInput.setText("");
            }
        });
        setFuncViewListener("+", mButtonSummation);
        setFuncViewListener("-", mButtonSubtract);
        setFuncViewListener("÷", mButtonDivide);
        setFuncViewListener("×", mButtonMultiply);
    }

    public void calculate() {
        String[] s = mTextViewInput.getText().toString().split(" ");
        try {
            for (int i = 0; i < s.length; i++) {
                double d;
                try {
                    d = Double.parseDouble(s[i + 1]);
                } catch (NumberFormatException illegal) {
                    continue;
                }
                if (mDoubleResult == 0) {
                    mDoubleResult = Double.parseDouble(s[0]);
                    mTextViewInput.setText(String.valueOf(mDoubleResult));
                }
                switch (s[i]) {
                    case "+":
                        mDoubleResult += d;
                        i++;
                        break;
                    case "-":
                        mDoubleResult -= d;
                        i++;
                        break;
                    case "×":
                        mDoubleResult *= d;
                        i++;
                        break;
                    case "÷":
                        mDoubleResult /= d;
                        i++;
                        break;
                }
            }
        } catch (NullPointerException n) {
            Log.w("out of bounds", "Index out of bounds");
        } catch (ArithmeticException a) {
            Toast.makeText(getActivity(), a.getMessage(), Toast.LENGTH_LONG).show();
            delete();
        }
    }

    public void delete() {
        mDoubleResult = 0;
    }
}