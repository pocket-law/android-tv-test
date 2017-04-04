package org.pocketlaw.tv_cld;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;


/**
 * Created by gcgol on 04/03/2017.
 */

public class MainActivity extends Activity {

    private TextView centerText;

    private Dpad mDpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        centerText = (TextView) findViewById(R.id.text_center);
        mDpad = new Dpad();
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {

        // Check if this event if from a D-pad and process accordingly.
        if (Dpad.isDpadDevice(event)) {

            int press = mDpad.getDirectionPressed(event);
            switch (press) {
                case Dpad.LEFT:
                    // Do something for LEFT direction press
                    centerText.setText("LEFT");
                    return true;
                case Dpad.RIGHT:
                    // Do something for RIGHT direction press
                    centerText.setText("RIGHT");
                    return true;
                case Dpad.UP:
                    // Do something for UP direction press
                    centerText.setText("UP");
                    return true;
                case Dpad.DOWN:
                    // Do something for UP direction press
                    centerText.setText("DOWN");
                    return true;
            }
        }

        // TODO: Check if this event is from a joystick movement and process accordingly.

        return super.onGenericMotionEvent(event);
    }
}