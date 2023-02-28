package uz.farxod.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;

import uz.farxod.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;

    StringBuilder edit_Text = new StringBuilder();
    StringBuilder text_View = new StringBuilder();
    String[] arr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void onClickButton(View view){

        switch (view.getId()){
            case R.id.btn_one:
                edit_Text.append("1");
                text_View.append("1");
                break;
            case R.id.btn_two:
                edit_Text.append("2");
                text_View.append("2");
                break;
            case R.id.btn_three:
                edit_Text.append("3");
                text_View.append("3");
                break;
            case R.id.btn_four:
                edit_Text.append("4");
                text_View.append("4");
                break;
            case R.id.btn_five:
                edit_Text.append("5");
                text_View.append("5");
                break;
            case R.id.btn_six:
                edit_Text.append("6");
                text_View.append("6");
                break;
            case R.id.btn_seven:
                edit_Text.append("7");
                text_View.append("7");
                break;
            case R.id.btn_edge:
                edit_Text.append("8");
                text_View.append("8");
                break;
            case R.id.btn_nine:
                edit_Text.append("9");
                text_View.append("9");
                break;
            case R.id.btn_null:
                edit_Text.append("0");
                text_View.append("0");
                break;
            case R.id.btn_c:
                edit_Text.delete(0, edit_Text.length());
                text_View.delete(0, text_View.length());
                break;
            case R.id.btn_del:
                if(edit_Text.length()>0){
                    edit_Text.deleteCharAt(edit_Text.length()-1);
                    text_View.deleteCharAt(text_View.length()-1);}
                break;
            case R.id.btn_plus:
                edit_Text.append("+");
                text_View.append("+");
                break;
            case R.id.btn_minus:
                edit_Text.append("-");
                text_View.append("-");
                break;
            case R.id.btn_kupaytiruv:
                edit_Text.append("x");
                text_View.append("x");
                break;
            case R.id.btn_boluv:
                edit_Text.append("/");
                text_View.append("/");
                break;
            case R.id.btn_nuqta:
                nuqta();
                break;
        }   binding.editText.setText(edit_Text);
            binding.textView.setText(text_View);
    }

    public void nuqta(){
        arr = ((edit_Text.toString().split("[^\\d.]")));
        for(int i=0; i< arr.length; i++){
            if(!arr[arr.length-1].contains(".")){

                edit_Text.append(".");
                text_View.append(".");
            }
        }
    }
   @SuppressLint("SetTextI18n")
   public void teng(View view){
       arr = ((edit_Text.toString().split("[^\\d.]")));
       double value1 = Double.parseDouble(arr[0]);
       double value2 = Double.parseDouble(arr[1]);
       double value3 = 0;

            if(edit_Text.toString().contains("+")){
                 value3 = value1 + value2;
                binding.editText.setText(String.valueOf(value3));
            }else if(edit_Text.toString().contains("-")){
                value3 = value1 - value2;
                binding.editText.setText(String.valueOf(value3));
            }else if(edit_Text.toString().contains("/")){
                value3 = value1 / value2;
                binding.editText.setText(String.valueOf(value3));
            }else if(edit_Text.toString().contains("x")){
                value3 = value1 * value2;
                binding.editText.setText(String.valueOf(value3));
            }else binding.editText.setText("0");

            binding.textView.setText(text_View +"="+ value3);
            edit_Text.delete(0, edit_Text.length());
    }
}