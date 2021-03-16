package android.reserver.com;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mSubmitButton;
    private EditText mSeatInput;
    private TextView mTypeError;
    private TextView mRangeError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSubmitButton = findViewById(R.id.submitButton);
        mSeatInput = findViewById(R.id.seatNumEditText);
        mTypeError = findViewById(R.id.typeErrorMessage);
        mRangeError = findViewById(R.id.rangeErrorMessage);

        this.handleSeatInput(mSeatInput);
    }

    // first lets do all the logic here
    // then we will create our model and perform the appropriate actions in that file
    public void handleSeatInput(View view) {
        int seatInput;
        // set seatInput to number user typed & catch error
        try {
            String seatInputString = mSeatInput.getText().toString();
            seatInput = Integer.parseInt(seatInputString);
        } catch (NumberFormatException e) {
            seatInput = 0;
        }

        // error if not integer
        mSeatInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    mTypeError.setVisibility(View.INVISIBLE);
                    // error if > 6
                    if (Integer.parseInt(s.toString()) > 6) {
                        mRangeError.setVisibility(View.VISIBLE);
                    } else {
                        mRangeError.setVisibility(View.INVISIBLE);
                    }
                } catch (NumberFormatException e) {
                    mTypeError.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

}
